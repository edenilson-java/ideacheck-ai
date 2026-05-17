# Prompts Utilizados no Projeto — IdeaCheck AI

Este documento registra os prompts utilizados pelo grupo durante o desenvolvimento do projeto, conforme exigido no mini-projeto avaliativo.

Cada integrante é responsável por registrar os prompts utilizados em sua própria frente de trabalho.

---

## Edenilson

### Prompt 01 — Definição do tema do projeto

**Etapa:** Requisitos / concepção do produto  
**Ferramenta:** ChatGPT  
**Objetivo:** Avaliar qual tema seria mais viável para entregar dentro do prazo do mini-projeto.

**Prompt utilizado:**

> Com base nos requisitos do mini-projeto avaliativo e no prazo curto de entrega, ajude a decidir qual tema seria mais viável para o grupo desenvolver, considerando que precisamos de uma aplicação com IA funcional no produto, documentação, testes automatizados, PRD, viabilidade, prompts documentados e contribuições rastreáveis no GitHub.

**Resultado aproveitado:**

Foi definido o tema **IdeaCheck AI — Validador de Ideias de Negócio com IA**, mantendo o escopo genérico/multissetorial para evitar complexidade desnecessária.

---

### Prompt 02 — Definição do nome, slogan e descrição do produto

**Etapa:** Produto / documentação  
**Ferramenta:** ChatGPT  
**Objetivo:** Refinar nome, slogan e descrição do projeto.

**Prompt utilizado:**

> Ajude a melhorar o nome, slogan e descrição do projeto para um validador de ideias de negócio com IA, mantendo uma promessa realista para um MVP de uma semana.

**Resultado aproveitado:**

Nome definido:

> IdeaCheck AI — Validador de Ideias de Negócio com IA

Slogan definido:

> Transforme uma ideia solta em uma análise estruturada de negócio.

Descrição ajustada para deixar claro que a aplicação gera uma **análise inicial e estruturada**, e não uma validação definitiva de mercado.

---

### Prompt 03 — Divisão inicial das tarefas do grupo

**Etapa:** Organização do trabalho  
**Ferramenta:** ChatGPT  
**Objetivo:** Dividir responsabilidades entre os cinco integrantes do grupo.

**Prompt utilizado:**

> Ajude a melhorar a divisão de tarefas dos cinco participantes do grupo, considerando o perfil de cada integrante, o prazo curto, os requisitos do PDF e a necessidade de cada pessoa ter contribuições rastreáveis no GitHub.

**Resultado aproveitado:**

Foi proposta a divisão inicial:

- Ernesto — Backend/API Spring Boot + GitHub Actions
- Filipe — Serviço de IA, cliente LLM e mock
- Eliandro — Prompt principal, parser da resposta e critérios de análise
- Jardel — Frontend, formulário e exibição da análise
- Edenilson — README, PRD, VIABILIDADE, fluxograma, UML, matriz de rastreabilidade, checklist final, sua seção de prompts e apoio na conferência dos requisitos

---

### Prompt 04 — Estratégia de repositório-esqueleto

**Etapa:** Arquitetura / organização do repositório  
**Ferramenta:** ChatGPT  
**Objetivo:** Evitar que cada integrante desenvolvesse uma parte desconectada do projeto.

**Prompt utilizado:**

> Considerando o prazo curto e o risco de cada integrante desenvolver uma parte independente, ajude a definir uma estratégia de repositório-esqueleto com estrutura base, arquivos obrigatórios, branches e divisão de responsabilidades.

**Resultado aproveitado:**

Foi definida a estratégia de criar um repositório-esqueleto com:

- estrutura base de pastas;
- documentos obrigatórios;
- `.gitkeep` para pastas ainda vazias;
- branches por frente de trabalho;
- PRD com contrato da API;
- matriz de rastreabilidade;
- checklist final.

---

### Prompt 05 — Criação do PRD com contrato da API

**Etapa:** Documentação de produto  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar o `docs/PRD.md` contendo visão do produto, problema, público-alvo, requisitos, user stories e contrato da API.

**Prompt utilizado:**

> Crie o conteúdo inicial do docs/PRD.md para o projeto IdeaCheck AI, incluindo visão geral, problema, público-alvo, objetivo do MVP, user stories, requisitos funcionais, requisitos não funcionais, especificação da API, critérios de aceite e fora do escopo.

**Resultado aproveitado:**

Foi criado o arquivo `docs/PRD.md` com a seção **Especificação da API**, servindo como contrato entre backend, serviço de IA, frontend e testes.

---

### Prompt 06 — Criação da matriz de rastreabilidade

**Etapa:** Rastreabilidade / controle de requisitos  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar uma matriz relacionando requisitos, arquivos, responsáveis e evidências esperadas.

**Prompt utilizado:**

> Crie uma matriz de rastreabilidade para o projeto IdeaCheck AI relacionando os requisitos do mini-projeto, os arquivos do repositório, os responsáveis por cada frente e as evidências esperadas.

**Resultado aproveitado:**

Foi criado o arquivo `docs/MATRIZ_RASTREABILIDADE.md`, relacionando:

- responsáveis;
- branches sugeridas;
- arquivos por integrante;
- requisitos da entrega;
- requisitos funcionais;
- requisitos não funcionais.

---

### Prompt 07 — Criação do checklist final

**Etapa:** Qualidade / revisão final  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar checklist de conferência antes da entrega.

**Prompt utilizado:**

> Crie um checklist final para o projeto IdeaCheck AI, cobrindo repositório, documentação, uso de IA, funcionalidades mínimas, testes, Pull Requests, contribuições individuais e revisão final antes do envio no AVA.

**Resultado aproveitado:**

Foi criado o arquivo `docs/checklist-final.md`, usado como controle de entrega antes do envio final do projeto.

---

### Prompt 08 — Criação do arquivo de prompts

**Etapa:** Documentação de uso de IA  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar o arquivo `docs/prompts.md` para registrar as interações relevantes com IA utilizadas no projeto.

**Prompt utilizado:**

> Eu não deveria já estar registrando de alguma forma os prompts até aqui? Atualize o arquivo de prompts do projeto com os prompts relevantes utilizados até agora, separando por responsável e mantendo espaço para os demais integrantes registrarem seus próprios prompts.

**Resultado aproveitado:**

Foi estruturado o arquivo `docs/prompts.md` com a seção do Edenilson preenchida e espaços para Ernesto, Filipe, Eliandro e Jardel registrarem os prompts usados em suas respectivas frentes.

---

### Prompt 09 — Criação da viabilidade técnica

**Etapa:** Documentação técnica / viabilidade  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar o conteúdo do `docs/VIABILIDADE.md`, abordando problema, papel da IA, custo/benefício, limitações e próximos passos.

**Prompt utilizado:**

> Qual deve ser o conteúdo do arquivo docs/VIABILIDADE.md para o projeto IdeaCheck AI, considerando os requisitos do mini-projeto, o papel funcional da IA, limitações técnicas, custo/benefício, uso de mock e proposta futura com RAG?

**Resultado aproveitado:**

Foi criado o documento `docs/VIABILIDADE.md`, descrevendo a viabilidade técnica do MVP, o papel funcional da IA, as limitações conhecidas, os riscos técnicos, a estratégia com mock e as propostas futuras.

---

### Prompt 10 — Criação do fluxograma

**Etapa:** Documentação técnica / arquitetura  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar o conteúdo do `docs/fluxograma.md` em Mermaid, demonstrando o fluxo principal da aplicação.

**Prompt utilizado:**

> Crie o fluxograma do projeto IdeaCheck AI em Mermaid, mostrando o fluxo do usuário no frontend, envio para a API, validação dos campos, chamada ao serviço de IA ou mock, parser da resposta e exibição da análise estruturada.

**Resultado aproveitado:**

Foi criado o arquivo `docs/fluxograma.md` com um fluxo detalhado e um fluxo resumido da aplicação, ambos em Mermaid.

---

### Prompt 11 — Criação do diagrama UML

**Etapa:** Documentação técnica / UML  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar o conteúdo do `docs/uml.md` em Mermaid, representando as classes planejadas do MVP.

**Prompt utilizado:**

> Eu não deveria já ter o UML feito em Mermaid como abordado em aula? Crie um diagrama UML inicial para o projeto IdeaCheck AI, considerando controller, DTOs, serviço de IA, cliente real, mock, prompt builder, parser e tratamento de exceções.

**Resultado aproveitado:**

Foi criado o arquivo `docs/uml.md` com um diagrama de classes em Mermaid, representando a arquitetura inicial planejada do MVP.

---

### Prompt 12 — Criação do README

**Etapa:** Documentação principal do repositório  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar o conteúdo inicial do `README.md` do projeto.

**Prompt utilizado:**

> Crie o README.md inicial do projeto IdeaCheck AI, incluindo visão geral, problema, papel da IA, stack, estrutura do projeto, modelo de trabalho, divisão de responsabilidades, documentação, contrato da API, execução, testes, engenharia de contexto, registro de prompts, limitações e status do projeto.

**Resultado aproveitado:**

Foi criado o `README.md`, descrevendo o propósito do projeto, o papel da IA, a estrutura de trabalho, a documentação existente, as instruções previstas de execução e teste, além das limitações conhecidas.

---

### Prompt 13 — Criação do template de Pull Request

**Etapa:** Organização do repositório / Pull Requests  
**Ferramenta:** ChatGPT  
**Objetivo:** Criar o template de Pull Request do projeto.

**Prompt utilizado:**

> Crie um template de Pull Request para o projeto IdeaCheck AI, com seções para resumo, tipo de alteração, arquivos alterados, requisitos atendidos, como testar, evidências, prompts utilizados e checklist.

**Resultado aproveitado:**

Foi criado o arquivo `.github/pull_request_template.md`, orientando os integrantes a documentarem suas alterações, requisitos atendidos, testes realizados, evidências e prompts utilizados.

---

### Prompt 14 — Revisão e correção dos arquivos de documentação

**Etapa:** Revisão / qualidade  
**Ferramenta:** ChatGPT e Claude/Opus  
**Objetivo:** Revisar os arquivos de documentação criados e identificar problemas de formatação, arquivos incompletos ou inconsistências.

**Prompt utilizado:**

> Leia o projeto anexado e me diga o que falta, verificando os arquivos de documentação, README, .gitignore e template de Pull Request. Aponte problemas críticos e ajustes necessários antes da entrega.

**Resultado aproveitado:**

Foram identificados e corrigidos pontos como:

- `docs/VIABILIDADE.md` e `docs/uml.md` com conteúdos trocados;
- `.github/pull_request_template.md` truncado;
- necessidade de placeholders no `docs/prompts.md` para os demais integrantes;
- ajuste de linguagem no README;
- reforço da documentação de limitações e engenharia de contexto.

---

---

### Prompt 15 — Revisão da viabilidade técnica e checklist final

**Etapa:** Revisão / documentação técnica  
**Ferramenta:** ChatGPT e Claude/Opus  
**Objetivo:** Revisar ajustes finais no `docs/VIABILIDADE.md` e no `docs/checklist-final.md`, garantindo aderência aos requisitos e mantendo referências técnicas adequadas.

**Prompt utilizado:**

> Verifique se a seção de viabilidade técnica deve citar referências externas sobre engenharia de contexto ou se é melhor manter uma formulação genérica. Também confira se o checklist final precisa incluir itens sobre migração do repositório para a organização SCTEC e atualização do origin local.

**Resultado aproveitado:**

Foi decidido não citar diretamente materiais internos, nomes específicos de aulas ou arquivos de apoio no `docs/VIABILIDADE.md`.

A seção foi ajustada para usar uma formulação baseada em **boas práticas de engenharia de contexto**, com referência pública ao artigo da Anthropic Engineering Blog, *Effective context engineering for AI agents*.

Também foi reforçada a necessidade de registrar no `docs/checklist-final.md` a conferência sobre eventual migração do repositório para a organização correta e atualização do `origin` local.

---

### Prompt 16 — Ajuste emergencial de divisão e bootstrap do backend

**Etapa:** Organização do trabalho / mitigação de risco  
**Ferramenta:** ChatGPT e Claude/Opus  
**Objetivo:** Definir como responder à indisponibilidade temporária do responsável inicial pela frente Backend/API e à oferta de um integrante de assumir a frente em outra stack, mantendo coerência com a documentação já versionada em Java 21 + Spring Boot.

**Prompt utilizado:**

> Considerando que o responsável inicial pelo backend só estará disponível próximo da data de entrega, outro integrante se ofereceu para assumir a frente em FastAPI, e toda a documentação do projeto — README, PRD, VIABILIDADE, UML, matriz e fluxograma — está estruturada em Java 21 + Spring Boot, qual a melhor estratégia para destravar o projeto sem trocar a stack nem remover a contribuição substancial prevista para o responsável inicial?

**Resultado aproveitado:**

Foi decidido manter a stack **Java 21 + Spring Boot** e registrar como **ajuste emergencial de divisão**:

- Edenilson assume apenas o **bootstrap mínimo do Spring Boot**: `pom.xml`, `IdeacheckAiApplication`, `application.yml`, DTOs e stubs dos controllers, para destravar as frentes de IA, prompt/parser e integração com o frontend.
- A parte substantiva da frente Backend/API permanece prevista para o Ernesto: validações com Bean Validation, `GlobalExceptionHandler`, testes com MockMvc, GitHub Actions, revisão/refatoração e integração final.
- A troca de stack para FastAPI foi recusada para evitar retrabalho documental e manter coerência com o perfil técnico majoritário do grupo e com a documentação já versionada.

---

### Prompt 17 - Geracao assistida do bootstrap minimo do Spring Boot

**Etapa:** Implementacao emergencial / backend (scaffold)  
**Ferramenta:** Codex (GPT-5)  
**Objetivo:** Gerar com seguranca o bootstrap minimo do backend em Java 21 + Spring Boot 3.5.0, estritamente aderente ao contrato do `docs/PRD.md` secao 8, para destravar integracao com IA/mock e frontend sem avancar na parte substantiva da API.

**Prompt utilizado:**

> Tarefa: completar bootstrap minimo do Spring Boot - IdeaCheck AI. Criar apenas `IdeacheckAiApplication`, `application.yml`, DTOs `ValidationRequest` e `ValidationResponse`, `HealthController` e `IdeaValidationController` com mock estatico conforme PRD secao 8.4, sem criar service, exception handler, testes, CI ou dependencias extras. Ao final, atualizar `docs/checklist-final.md` com item de conferencia do bootstrap e registrar este uso de IA em `docs/prompts.md`.

**Resultado aproveitado:**

Foram gerados os arquivos minimos de inicializacao da API:

- classe principal com `@SpringBootApplication`;
- configuracao basica no `application.yml`;
- DTOs em Java 21 records alinhados ao schema do PRD;
- endpoint `GET /api/v1/health`;
- endpoint `POST /api/v1/validate-idea` com resposta mock aderente ao contrato;
- atualizacao do checklist com item especifico para conferencia do bootstrap.

Esse uso de IA foi limitado ao **scaffold tecnico minimo**, mantendo a implementacao substantiva do backend, tratamento de erros, testes e CI na frente originalmente planejada.

---

### Prompt 18 — Validação local do bootstrap mínimo do backend

**Etapa:** Validação técnica / conferência de bootstrap  
**Ferramenta:** ChatGPT  
**Objetivo:** Conferir se o bootstrap mínimo do backend Spring Boot estava funcional após o merge do PR #4.

**Prompt utilizado:**

> Antes de avisar o grupo, tenho como testar localmente o bootstrap mínimo do backend Spring Boot? Oriente os comandos para validar a aplicação, considerando que o Maven não estava disponível no PATH.

**Resultado aproveitado:**

Foi realizada a validação local do bootstrap mínimo do backend.

O Maven não estava disponível inicialmente no PATH, então foi instalado manualmente em `C:\tools\apache-maven-3.9.16`.

A aplicação subiu localmente na porta `8080` com:

```bash
mvn spring-boot:run

---

## Ernesto

> A ser preenchido com os prompts utilizados na frente **Backend/API + CI**.

### Prompt 01 — [Título]

**Etapa:**  
**Ferramenta:**  
**Objetivo:**  

**Prompt utilizado:**

> [colar aqui]

**Resultado aproveitado:**

[descrever]

---

## Filipe

> A ser preenchido com os prompts utilizados na frente **Serviço de IA, cliente LLM e mock**.

### Prompt 01 — [Título]

**Etapa:**  
**Ferramenta:**  
**Objetivo:**  

**Prompt utilizado:**

> [colar aqui]

**Resultado aproveitado:**

[descrever]

---

## Eliandro

> A ser preenchido com os prompts utilizados na frente **Prompt principal, parser da resposta e critérios de análise**.

### Prompt 01 — [Título]

**Etapa:**  
**Ferramenta:**  
**Objetivo:**  

**Prompt utilizado:**

> [colar aqui]

**Resultado aproveitado:**

[descrever]

---

## Jardel

> A ser preenchido com os prompts utilizados na frente **Frontend**.

### Prompt 01 — [Título]

**Etapa:**  
**Ferramenta:**  
**Objetivo:**  

**Prompt utilizado:**

> [colar aqui]

**Resultado aproveitado:**

[descrever]
