package br.com.uanderson.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DocumentsLoader {

    private final JdbcClient jdbcClient;
    private final VectorStore vectorStore;

    @Value("classpath:docs/jls17.pdf")
    private Resource pdfResource;

    public DocumentsLoader(JdbcClient jdbcClient, VectorStore vectorStore) {
        this.jdbcClient = jdbcClient;
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadDocuments() {
        Integer count = jdbcClient.sql("SELECT COUNT(*) FROM VECTOR_STORE")
                .query(Integer.class)
                .single();

        if (count == 0) {
            log.info("Loading docs into vector store . . .");
            PdfDocumentReaderConfig config = PdfDocumentReaderConfig.builder()
                    .withPageExtractedTextFormatter(new ExtractedTextFormatter.Builder()
                            .withNumberOfBottomTextLinesToDelete(0)
                            .withNumberOfTopTextLinesToDelete(0)
                            .build()
                    )
                    .withPagesPerDocument(1)
                    .build();

            PagePdfDocumentReader pagePdfDocumentReader = new PagePdfDocumentReader(pdfResource, config);
            List<Document> result = pagePdfDocumentReader.get().stream()
                    .peek(doc -> log.info("Loading doc: {}", doc.getContent()))
                    .toList();

            vectorStore.accept(result);

            log.info("Loaded {} docs into vector store", result.size());
        }

    }//method


}//class
