package br.com.uanderson.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/docs")
public class DocumentsController {
    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    @Value("classpath:prompts/java17.ai.st")
    private Resource stPromptTemplate;

    public DocumentsController(ChatClient.Builder chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient
                .defaultAdvisors(new PromptChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
        this.vectorStore = vectorStore;
    }

    @GetMapping("/chat")
    private String generateResponse(@RequestParam String query){
        PromptTemplate promptTemplate = new PromptTemplate(stPromptTemplate);
        HashMap<String, Object> promptParameters = new HashMap<>();
        promptParameters.put("input", query);
        promptParameters.put("documents", String.join("\n", this.findSimilarDocuments(query)));

        Prompt prompt = promptTemplate.create(promptParameters);

        ChatResponse chatResponse = this.chatClient.prompt(prompt).call().chatResponse();

        return chatResponse.getResult().getOutput().getContent();
    }

    private List<String> findSimilarDocuments(String query) {
        List<Document> similarDocuments = vectorStore
                .similaritySearch(SearchRequest.query(query).withTopK(3));

        return similarDocuments.stream()
                .map(Document::getContent)
                .toList();
    }


}//class
