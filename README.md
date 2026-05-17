# IdeaCheck AI — Validador de Ideias de Negócio com IA

**Slogan:** Transforme uma ideia solta em uma análise estruturada de negócio.

## 1. Visão geral

O **IdeaCheck AI** é uma aplicação que utiliza inteligência artificial para gerar uma análise inicial e estruturada de ideias de negócio.

O usuário descreve uma ideia, informa o segmento de atuação e recebe uma análise contendo:

- problema identificado;
- público-alvo provável;
- proposta de valor;
- possíveis concorrentes ou alternativas;
- pontos fortes;
- riscos;
- perguntas em aberto;
- análise do segmento;
- nota estimada de viabilidade;
- justificativa da nota;
- próximos passos.

A proposta do MVP não é validar definitivamente uma ideia de mercado, mas oferecer uma análise inicial para apoiar reflexão, organização e próximos passos.

---

## 2. Problema que a aplicação resolve

Muitas pessoas têm ideias de negócio, mas não sabem avaliá-las de forma organizada antes de investir tempo ou recursos.

O **IdeaCheck AI** ajuda a transformar uma descrição livre em uma análise estruturada, facilitando a identificação de riscos, oportunidades e próximos passos.

---

## 3. Papel da IA no produto

A IA possui papel funcional dentro do produto.

Ela recebe os dados da ideia de negócio e gera uma resposta estruturada seguindo um prompt orientado por etapas.

A análise gerada inclui problema, público-alvo, proposta de valor, riscos, pontos fortes, possíveis concorrentes ou alternativas, nota estimada de viabilidade e próximos passos.

O sistema também prevê modo mock para permitir demonstração e testes mesmo sem chave de API de IA.

---

## 4. Stack

### Backend

- Java 21
- Spring Boot
- Maven

### Frontend

- HTML
- CSS
- JavaScript

### Testes

- JUnit
- Mockito
- MockMvc

### CI/CD

- GitHub Actions

### Documentação

- Markdown
- Mermaid

---

## 5. Estrutura inicial do projeto

```text
ideacheck-ai/
├── .github/
│   └── pull_request_template.md
├── docs/
│   ├── PRD.md
│   ├── VIABILIDADE.md
│   ├── prompts.md
│   ├── fluxograma.md
│   ├── uml.md
│   ├── MATRIZ_RASTREABILIDADE.md
│   └── checklist-final.md
├── frontend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       └── java/
├── .gitignore
└── README.md
```

---

## 6. Modelo de trabalho

Cada integrante deve trabalhar em uma branch própria e abrir Pull Request para a `main`.

Branches sugeridas:

```text
main
├── feature/backend-api        (Ernesto)
├── feature/ai-service         (Filipe)
├── feature/frontend           (Jardel)
├── feature/prompt-criteria    (Eliandro)
└── feature/docs-requirements  (Edenilson)
```

---

## 7. Divisão inicial de responsabilidades

### Ernesto — Backend/API + CI

Responsável por:

- projeto Spring Boot;
- controllers;
- DTOs;
- validações;
- tratamento de erros;
- testes da API;
- GitHub Actions.

### Filipe — Serviço de IA

Responsável por:

- interface de cliente de IA;
- cliente real de LLM;
- cliente mock;
- serviço de validação da ideia;
- testes da camada de serviço.

### Eliandro — Prompt, parser e critérios

Responsável por:

- prompt principal da IA;
- parser da resposta;
- critérios de análise da ideia;
- exemplos de ideias;
- testes de prompt/parser.

### Jardel — Frontend

Responsável por:

- tela da aplicação;
- formulário de envio da ideia;
- chamada para a API;
- exibição da análise;
- tratamento visual de carregamento e erro.

### Edenilson — Documentação e requisitos

Responsável por:

- README;
- PRD;
- VIABILIDADE;
- fluxograma;
- UML;
- matriz de rastreabilidade;
- checklist final;
- sua própria seção de prompts;
- apoio na conferência dos requisitos.

---

## 8. Documentação do projeto

Documentos principais:

- [`docs/PRD.md`](docs/PRD.md)
- [`docs/VIABILIDADE.md`](docs/VIABILIDADE.md)
- [`docs/prompts.md`](docs/prompts.md)
- [`docs/fluxograma.md`](docs/fluxograma.md)
- [`docs/uml.md`](docs/uml.md)
- [`docs/MATRIZ_RASTREABILIDADE.md`](docs/MATRIZ_RASTREABILIDADE.md)
- [`docs/checklist-final.md`](docs/checklist-final.md)

---

## 9. Contrato da API

A especificação inicial da API está documentada no PRD, na seção:

```text
docs/PRD.md → 8. Especificação da API
```

Endpoints previstos:

```http
GET /api/v1/health
```

```http
POST /api/v1/validate-idea
```

---

## 10. Como executar

> Esta seção será atualizada após a implementação do backend.

Execução prevista:

```bash
mvn spring-boot:run
```

A aplicação deverá subir localmente em:

```text
http://localhost:8080
```

---

## 11. Como rodar os testes

> Esta seção será atualizada após a implementação dos testes.

Execução prevista:

```bash
mvn test
```

---

## 12. Uso de IA, engenharia de contexto e scaffolding

O projeto utiliza IA tanto no produto quanto no processo de desenvolvimento.

No produto, a IA gera uma análise inicial estruturada de ideias de negócio.

No processo de desenvolvimento, a IA foi utilizada para apoiar:

- definição de tema;
- organização do escopo;
- divisão de tarefas;
- documentação;
- PRD;
- matriz de rastreabilidade;
- checklist final;
- estruturação do prompt principal.

A seção de especificação da API no PRD funciona como contexto compartilhado entre backend, serviço de IA, frontend e testes.

O repositório também foi iniciado com um scaffold comum para reduzir ambiguidades entre as frentes de desenvolvimento.

---

## 13. Registro de prompts

Os prompts utilizados durante o desenvolvimento devem ser registrados em:

```text
docs/prompts.md
```

Cada integrante é responsável por preencher sua própria seção.

---

## 14. Limitações conhecidas

- A análise gerada pela IA é inicial e não substitui pesquisa real de mercado.
- A IA pode gerar inferências imprecisas.
- A qualidade da resposta depende da qualidade da descrição enviada pelo usuário.
- O MVP não realiza scraping, RAG, busca externa ou validação financeira.
- A nota de viabilidade é uma estimativa qualitativa, não uma garantia de sucesso.

---

## 15. Status do projeto

Status atual:

```text
Em desenvolvimento.
```

Meta interna:

```text
Projeto tecnicamente pronto até 21/05.
```

Entrega final:

```text
22/05 via AVA.
```