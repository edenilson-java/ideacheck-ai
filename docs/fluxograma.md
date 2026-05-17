# Fluxograma — IdeaCheck AI

Este documento apresenta o fluxo principal de funcionamento do **IdeaCheck AI**.

O objetivo do fluxograma é demonstrar como o usuário interage com a aplicação, como os dados são enviados para o backend, como a camada de IA ou mock processa a ideia e como a análise estruturada é retornada ao frontend.

---

## 1. Fluxo principal da aplicação

```mermaid
flowchart TD
    A[Usuário acessa o frontend] --> B[Preenche formulário da ideia]
    B --> C[Informa título, descrição, segmento, público-alvo e problema]
    C --> D[Clica em validar ideia]

    D --> E[Frontend envia POST /api/v1/validate-idea]
    E --> F[Backend recebe ValidationRequest]

    F --> G{Campos obrigatórios válidos?}

    G -- Não --> H[Backend retorna erro 400]
    H --> I[Frontend exibe mensagem de erro]

    G -- Sim --> J[IdeaValidationController chama IdeaValidationService]

    J --> K[PromptBuilder monta prompt estruturado]
    K --> L{Chave/API de IA disponível?}

    L -- Sim --> M[OpenAiClient envia prompt para LLM]
    L -- Não --> N[MockAiClient retorna resposta simulada]

    M --> O[IA retorna análise em JSON]
    N --> O

    O --> P[ValidationResponseParser valida resposta]
    P --> Q{Resposta segue o schema do PRD?}

    Q -- Não --> R[Backend trata erro ou usa fallback]
    R --> S[Frontend exibe erro controlado]

    Q -- Sim --> T[Backend retorna ValidationResponse]
    T --> U[Frontend recebe análise estruturada]

    U --> V[Frontend exibe resumo, problema, público-alvo, proposta de valor, riscos, pontos fortes, nota, justificativa e próximos passos]
```

---

## 2. Fluxo resumido

```mermaid
flowchart LR
    A[Usuário] --> B[Frontend]
    B --> C[API Spring Boot]
    C --> D[Serviço de IA]
    D --> E[LLM ou Mock]
    E --> F[Resposta estruturada]
    F --> C
    C --> B
    B --> A
```

---

## 3. Observações

- O frontend é responsável por capturar os dados da ideia e exibir a análise.
- O backend é responsável por validar a entrada, acionar o serviço de IA e retornar resposta padronizada.
- A camada de IA pode usar uma integração real com LLM ou um mock para permitir execução sem chave de API.
- O schema da resposta deve seguir a especificação definida no `docs/PRD.md`.
- O modo mock garante que o MVP continue demonstrável mesmo sem integração real disponível no momento da apresentação.

---

## 4. Relação com os requisitos

Este fluxograma contribui para evidenciar:

- funcionamento geral da aplicação;
- papel funcional da IA no produto;
- integração entre frontend, backend e serviço de IA;
- existência de fallback/mock;
- organização do fluxo de dados;
- alinhamento com o PRD e com a matriz de rastreabilidade.