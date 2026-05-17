# Matriz de Rastreabilidade — IdeaCheck AI

Este documento relaciona os principais requisitos do mini-projeto aos arquivos, responsáveis e evidências esperadas no repositório.

O objetivo é garantir que os requisitos obrigatórios da entrega sejam cobertos e que as contribuições individuais fiquem claras.

---

## 1. Responsáveis e branches sugeridas

| Integrante | Frente | Branch sugerida |
|---|---|---|
| Ernesto | Backend/API Spring Boot + GitHub Actions | `feature/backend-api` |
| Filipe | Serviço de IA, cliente LLM e mock | `feature/ai-service` |
| Eliandro | Prompt principal, parser da resposta e critérios de análise | `feature/prompt-criteria` |
| Jardel | Frontend, formulário e exibição da análise | `feature/frontend` |
| Edenilson | README, PRD, VIABILIDADE, fluxograma, UML, matriz, checklist e sua seção de prompts | `feature/docs-requirements` |

---

## 2. Arquivos por responsável

### Ernesto — Backend/API + CI

Arquivos sugeridos:

- `pom.xml`
- `.gitignore`
- `.github/workflows/ci.yml`
- `src/main/resources/application.yml`
- `src/main/java/br/com/ideacheck/IdeacheckAiApplication.java`
- `src/main/java/br/com/ideacheck/controller/HealthController.java`
- `src/main/java/br/com/ideacheck/controller/IdeaValidationController.java`
- `src/main/java/br/com/ideacheck/dto/ValidationRequest.java`
- `src/main/java/br/com/ideacheck/dto/ValidationResponse.java`
- `src/main/java/br/com/ideacheck/exception/GlobalExceptionHandler.java`
- `src/test/java/br/com/ideacheck/controller/HealthControllerTest.java`
- `src/test/java/br/com/ideacheck/controller/IdeaValidationControllerTest.java`

Requisitos cobertos:

- API REST funcional.
- Endpoint de saúde.
- Endpoint de validação da ideia.
- DTOs alinhados ao PRD.
- Validação de entrada.
- Tratamento básico de erros.
- Execução local.
- CI com GitHub Actions.
- Testes automatizados da API.

---

### Filipe — Serviço de IA, cliente LLM e mock

Arquivos sugeridos:

- `.env.example`
- `src/main/java/br/com/ideacheck/service/AiClient.java`
- `src/main/java/br/com/ideacheck/service/OpenAiClient.java`
- `src/main/java/br/com/ideacheck/service/MockAiClient.java`
- `src/main/java/br/com/ideacheck/service/IdeaValidationService.java`
- `src/test/java/br/com/ideacheck/service/MockAiClientTest.java`
- `src/test/java/br/com/ideacheck/service/IdeaValidationServiceTest.java`

Requisitos cobertos:

- Componente funcional de IA no produto.
- Integração com LLM ou cliente preparado para integração.
- Modo mock para funcionamento sem chave de API.
- Serviço responsável por receber dados da ideia e retornar análise estruturada.
- Testes automatizados da camada de serviço.
- Separação entre cliente real e mock.

---

### Eliandro — Prompt principal, parser e critérios

Arquivos sugeridos:

- `src/main/resources/prompts/business-validator-system.txt`
- `src/main/java/br/com/ideacheck/service/PromptBuilder.java`
- `src/main/java/br/com/ideacheck/service/ValidationResponseParser.java`
- `docs/criterios-analise-ideia.md`
- `docs/exemplos-ideias.md`
- `src/test/java/br/com/ideacheck/service/PromptBuilderTest.java`
- `src/test/java/br/com/ideacheck/service/ValidationResponseParserTest.java`

Requisitos cobertos:

- Prompt engineering intencional.
- Saída estruturada conforme o schema do PRD.
- Critérios de análise da ideia.
- Exemplos para validação manual e testes.
- Mitigação de respostas fora do formato esperado.
- Testes do prompt e do parser.

---

### Jardel — Frontend

Arquivos sugeridos:

- `frontend/index.html`
- `frontend/styles.css`
- `frontend/script.js`

Requisitos cobertos:

- Interface para envio da ideia.
- Formulário com campos do request definido no PRD.
- Consumo do endpoint `POST /api/v1/validate-idea`.
- Exibição da análise retornada pela IA.
- Tratamento visual de carregamento e erro.

---

### Edenilson — Documentação, requisitos, conferência e bootstrap mínimo do backend

Arquivos sugeridos:

- `README.md`
- `docs/PRD.md`
- `docs/VIABILIDADE.md`
- `docs/prompts.md`
- `docs/fluxograma.md`
- `docs/uml.md`
- `docs/MATRIZ_RASTREABILIDADE.md`
- `docs/checklist-final.md`
- `.github/pull_request_template.md`

Arquivos previstos no ajuste emergencial de bootstrap:

- `pom.xml`
- `src/main/java/br/com/ideacheck/IdeacheckAiApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/br/com/ideacheck/dto/ValidationRequest.java`
- `src/main/java/br/com/ideacheck/dto/ValidationResponse.java`
- `src/main/java/br/com/ideacheck/controller/HealthController.java`
- `src/main/java/br/com/ideacheck/controller/IdeaValidationController.java`

Requisitos cobertos:

- README completo.
- PRD versionado.
- Documento de viabilidade.
- Prompts documentados na sua própria seção.
- Fluxograma versionado.
- UML versionado.
- Matriz de rastreabilidade.
- Checklist final.
- Template de Pull Request.
- Apoio na conferência dos critérios da entrega.
- Bootstrap mínimo do Spring Boot para destravar as frentes de IA, prompt/parser, frontend e integração.

#### Ajuste emergencial — Bootstrap mínimo do backend

Devido à indisponibilidade temporária do responsável inicial pela frente Backend/API e para evitar bloqueio das demais frentes, o Edenilson assumiu o bootstrap mínimo do Spring Boot, já mergeado na `main` por meio do PR #4.

Esse bootstrap inclui apenas:

- `pom.xml`;
- `src/main/java/br/com/ideacheck/IdeacheckAiApplication.java`;
- `src/main/resources/application.yml`;
- `src/main/java/br/com/ideacheck/dto/ValidationRequest.java`;
- `src/main/java/br/com/ideacheck/dto/ValidationResponse.java`;
- `src/main/java/br/com/ideacheck/controller/HealthController.java`;
- `src/main/java/br/com/ideacheck/controller/IdeaValidationController.java`.

Evidências do estado atual após o PR #4:

- aplicação Spring Boot executada localmente na porta `8080`;
- endpoint `GET /api/v1/health` validado localmente;
- endpoint `POST /api/v1/validate-idea` validado localmente com resposta mock estática;
- registro documental do bootstrap realizado em `README.md`, `docs/checklist-final.md` e `docs/prompts.md`.

A parte substantiva da frente Backend/API permanece prevista para o Ernesto, incluindo:

- validações com Bean Validation;
- `GlobalExceptionHandler`;
- testes com MockMvc;
- GitHub Actions;
- revisão/refatoração do backend;
- integração final da API.

Justificativa e contexto do ajuste registrados em `docs/prompts.md`, Prompt 16.

---

## 3. Requisitos da entrega e evidências

| ID | Requisito | Evidência esperada | Responsável principal |
|---|---|---|---|
| REQ-01 | Repositório criado como `ideacheck-ai` | Link do GitHub | Grupo |
| REQ-02 | Repositório no local correto da organização, se confirmado pelo tutor | Transferência ou criação na organização SCTEC | Grupo |
| REQ-03 | Todos os integrantes com commits | Histórico de commits | Todos |
| REQ-04 | Branches por funcionalidade | Branches `feature/*` | Todos |
| REQ-05 | Pull Request com template preenchido | Aba Pull Requests do GitHub | Todos |
| REQ-06 | README completo | `README.md` | Edenilson |
| REQ-07 | PRD versionado | `docs/PRD.md` | Edenilson |
| REQ-08 | Documento de viabilidade | `docs/VIABILIDADE.md` | Edenilson |
| REQ-09 | Prompts documentados | `docs/prompts.md` com seção por integrante | Todos |
| REQ-10 | Fluxograma | `docs/fluxograma.md` | Edenilson |
| REQ-11 | UML | `docs/uml.md` | Edenilson |
| REQ-12 | IA funcional no produto | `IdeaValidationService`, `AiClient`, `PromptBuilder`, `MockAiClient` | Filipe / Eliandro |
| REQ-13 | Aplicação funcional | Backend + IA/mock + frontend | Ernesto / Filipe / Eliandro / Jardel |
| REQ-13a | Bootstrap mínimo do Spring Boot no ajuste emergencial | `pom.xml`, `IdeacheckAiApplication`, `application.yml`, DTOs e controllers base com mock estático validados após o PR #4 | Edenilson |
| REQ-14 | Mínimo de 5 testes automatizados | Arquivos em `src/test/java` | Ernesto / Filipe / Eliandro |
| REQ-15 | GitHub Actions | `.github/workflows/ci.yml` | Ernesto |
| REQ-16 | Evidência de uso de IA no desenvolvimento | `docs/prompts.md` | Todos |
| REQ-17 | Limitações conhecidas | `docs/VIABILIDADE.md` | Edenilson |
| REQ-18 | Link testado antes da entrega | `docs/checklist-final.md` | Grupo |
| REQ-19 | Repositório congelado após envio | `docs/checklist-final.md` | Grupo |

---

## 4. Mapeamento dos requisitos funcionais do produto

| ID | Requisito funcional | Arquivos relacionados | Responsáveis |
|---|---|---|---|
| RF01 | Informar dados da ideia | `ValidationRequest.java` (bootstrap por Edenilson), `frontend/index.html`, `frontend/script.js` | Edenilson (bootstrap) / Ernesto (validações) / Jardel |
| RF02 | Validar ideia com IA | `IdeaValidationController.java` (controller base com mock estático por Edenilson), `IdeaValidationService.java`, `AiClient.java` | Edenilson (controller base) / Ernesto (revisão backend) / Filipe |
| RF03 | Retornar análise estruturada | `ValidationResponse.java` (bootstrap por Edenilson), `MockAiClient.java`, `ValidationResponseParser.java` | Edenilson (bootstrap) / Ernesto (revisão backend) / Filipe / Eliandro |
| RF04 | Disponibilizar endpoint de saúde | `HealthController.java` (controller base validado por Edenilson), `HealthControllerTest.java` | Edenilson (controller base) / Ernesto (teste) |
| RF05 | Disponibilizar interface simples | `frontend/index.html`, `frontend/styles.css`, `frontend/script.js` | Jardel |
| RF06 | Tratar erros básicos | `GlobalExceptionHandler.java`, `script.js`, testes | Ernesto / Jardel |

---

## 5. Mapeamento dos requisitos não funcionais

| ID | Requisito não funcional | Evidência | Responsável |
|---|---|---|---|
| RNF01 | Execução local documentada | `README.md` | Edenilson |
| RNF02 | Estrutura de pastas organizada | Estrutura do repositório | Grupo |
| RNF03 | Pelo menos 5 testes automatizados | `src/test/java` | Ernesto / Filipe / Eliandro |
| RNF04 | Documentação obrigatória | `README.md`, `PRD.md`, `VIABILIDADE.md`, `prompts.md`, fluxograma, UML | Edenilson / Todos |
| RNF05 | Versionamento com branches e PRs | GitHub | Todos |
| RNF06 | Modo mock | `MockAiClient.java` | Filipe |
