# 📚 Projeto Assistente Inteligente com Spring Boot e pgvector

Bem-vindo ao projeto "Assistente Inteligente"! Este projeto demonstra como criar um assistente inteligente que pode responder perguntas sobre Java 17, utilizando Spring Boot e pgvector. Utilizamos a técnica RAG (Retrieval-Augmented Generation) para combinar a recuperação de documentos com a geração de texto, proporcionando respostas precisas baseadas na especificação do Java 17 em PDF.

## 📽️ Visão Geral do Projeto

Neste tutorial, abordaremos os seguintes tópicos:

1. **Implementação do Assistente**:
    - Integração do Spring Boot com o projeto Spring AI para criar o assistente.

2. **Carga e Teste de Dados**:
    - Carregamento da especificação do Java 17 em PDF.
    - Demonstração de como o assistente melhora sua capacidade de resposta após processar a informação.

## 🛠️ Ferramentas e Tecnologias

- **Java 17**
- **Spring Boot Starter Web**
- **Spring AI OpenAI Spring Boot Starter**
- **Spring AI pgvector Store Spring Boot Starter**
- **Spring Boot DevTools**
- **Spring Boot Docker Compose**
- **Spring AI Spring Boot Docker Compose**
- **Spring AI PDF Document Reader**
- **Spring Boot Configuration Processor**
- **Lombok**

> Lembrando que para realizar os testes com a Inteligência Artificial da OpenAI, é necessário ter créditos na plataforma.


## 📋 Instruções para Execução

1. Clone o repositório:

```bash
   git clone https://github.com/uncle-dave-code/ai-rag
```

2. Navegue até o diretório do projeto:

```bash
cd /caminho-diretorio-projeto
```

3. Configure suas variáveis de ambiente conforme necessário.

### Pelo Terminal

### Windows

Abra o Prompt de Comando (cmd) e execute:

```cmd
set NOME_DA_VARIAVEL=valor_da_variavel
```

Ou pelo PowerShell:

```powershell
$env:NOME_DA_VARIAVEL="valor_da_variavel"
```

### macOS e Linux

Abra o terminal e adicione o comando ao seu `.bashrc` ou `.zshrc` (dependendo do shell que você está usando):

```bash
export NOME_DA_VARIAVEL="valor_da_variavel"
```

Depois, execute:

```bash
source ~/.bashrc  # ou ~/.zshrc se estiver usando zsh
```

## Pela IDE IntelliJ IDEA

Vá em `Run > Edit Configurations...`

No painel de configurações da sua aplicação, adicione as variáveis de ambiente na seção `Environment Variables` no formato:

```
NOME_DA_VARIAVEL=valor_da_variavel
```

4. Execute o projeto:

```bash 
  mvn spring-boot:run
```


## 💡 Conclusões

### Vantagens do RAG

- **Alta Precisão**: Proporciona respostas precisas com base nos documentos fornecidos.
- **Flexibilidade**: Pode ser adaptado para diferentes tipos de documentos técnicos. Muito útil
                     quando trabalhamos com manuais, documentações técnicas que possuem muitas informações.
### Desvantagens do RAG

- **Processamento de Dados Tabulares**: Pode encontrar dificuldades ao lidar com dados tabulares, como listas de produtos ou relatórios de vendas.

### Fonte do tutorial 📢

Repositório original: [https://github.com/uncle-dave-code/ai-rag](https://github.com/uncle-dave-code/ai-rag)

Link do Tutorial: [https://youtu.be/q2zTo21PEMU?si=YQyvvwODkludsQAa](https://youtu.be/q2zTo21PEMU?si=YQyvvwODkludsQAa)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/maven-plugin/build-image.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#using.devtools)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#features.docker-compose)
* [OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/openai-chat.html)
* [PGvector Vector Database](https://docs.spring.io/spring-ai/reference/api/vectordbs/pgvector.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web)

