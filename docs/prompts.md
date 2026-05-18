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
```

Foram validados localmente:

- endpoint `GET /api/v1/health`;
- endpoint `POST /api/v1/validate-idea`;
- retorno HTTP `200` no endpoint de validação;
- resposta mock estática seguindo o schema inicial definido no `docs/PRD.md`.

A validação confirmou que o bootstrap mínimo estava funcional após o PR #4, sem avançar na implementação substantiva das frentes de serviço de IA, prompt/parser, testes, CI ou frontend.

---

### Prompt 19 — Conferência documental pós-merge do PR #4

**Etapa:** Documentação / rastreabilidade / conferência final  
**Ferramenta:** ChatGPT e Claude/Opus  
**Objetivo:** Revisar o estado documental do projeto após o merge do PR #4, registrando evidências reais do bootstrap mínimo e preservando a divisão de responsabilidades entre os integrantes.

**Prompt utilizado:**

> Vamos continuar o projeto IdeaCheck AI. Leia o ZIP atual do projeto após o merge do PR #4 e o PDF oficial dos requisitos do mini-projeto. Antes de sugerir qualquer alteração, confirme o estado atual do projeto, os arquivos existentes, os requisitos oficiais, o que já foi feito e o que ainda falta especificamente na minha frente documental. A tarefa é implementar somente minha parte principal como Edenilson: documentação, requisitos, rastreabilidade e conferência final, sem assumir implementação substantiva dos demais integrantes.

**Resultado aproveitado:**

Foi realizada a conferência documental pós-merge do PR #4.

Foram atualizados:

- `README.md`, registrando instruções reais de execução com `mvn spring-boot:run`, endpoints disponíveis no estado atual e status dos testes;
- `docs/checklist-final.md`, marcando como concluídas apenas as evidências já validadas localmente e mantendo pendentes testes, CI, frontend, modo mock estruturado e tratamento de erros;
- `docs/MATRIZ_RASTREABILIDADE.md`, registrando as evidências reais do PR #4 e corrigindo o requisito `REQ-13a` para indicar controllers base com mock estático validados após o merge.

Também foi decidido manter no README a data de entrega final em `22/05 via AVA`, conforme orientação posterior do professor, sem substituir pela data anterior presente no PDF oficial.

A revisão preservou os limites da frente documental do Edenilson, sem criar service, `AiClient`, `MockAiClient`, `OpenAiClient`, `PromptBuilder`, `ValidationResponseParser`, `GlobalExceptionHandler`, testes, GitHub Actions ou frontend.

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

> Prompts utilizados na frente **Serviço de IA, cliente LLM e mock**.

### Prompt 01 — Implementação completa da camada de serviço de IA

**Etapa:** Implementação / serviço de IA  
**Ferramenta:** Kiro (Claude)  
**Objetivo:** Implementar a camada completa de serviço de IA do projeto, incluindo interface, cliente mock, cliente real (OpenAI), service de validação, testes unitários e integração com o controller existente.

**Prompt utilizado:**

> Analise o README.md do projeto e sugira como devo proceder com a parte que sou responsável. Minha responsabilidade é: Filipe — Serviço de IA. Responsável por: interface de cliente de IA; cliente real de LLM; cliente mock; serviço de validação da ideia; testes da camada de serviço.

Seguido de confirmação para implementar:

> Sim

**Resultado aproveitado:**

Foi implementada a camada completa de serviço de IA na branch `feature/ai-service`, com os seguintes artefatos:

**Pacote `br.com.ideacheck.ai`:**

- `AiClient.java` — interface contrato para clientes de IA, permitindo alternância entre mock e real via Spring Profiles;
- `MockAiClient.java` — implementação mock ativada com `@Profile("mock")`, retorna resposta dinâmica baseada nos dados do request;
- `OpenAiClient.java` — implementação real usando `RestClient` do Spring 6.1, com chamada à API da OpenAI, montagem de prompt (system + user) e parse do JSON de resposta;
- `IdeaValidationService.java` — service que orquestra a chamada ao `AiClient` com logging;
- `AiClientException.java` — exceção customizada para falhas na comunicação com IA.

**Testes (10 testes, todos passando):**

- `MockAiClientTest.java` — 4 testes: resposta completa, uso do título no resumo, tratamento de campos nulos, limite de itens por lista;
- `IdeaValidationServiceTest.java` — 3 testes: delegação ao client, propagação de exceção, invocação única;
- `OpenAiClientTest.java` — 3 testes: parse correto da resposta da API, envio do header Authorization, lançamento de exceção em erro HTTP.

**Alterações em arquivos existentes:**

- `IdeaValidationController.java` — refatorado para injetar `IdeaValidationService` em vez de retornar mock estático;
- `application.yml` — adicionado profile `mock` ativo por padrão e configurações de IA (`api-key`, `model`, `base-url`);
- `pom.xml` — adicionadas dependências `spring-boot-starter-test` e `mockwebserver` para testes.

**Decisões técnicas:**

- Uso de `@Profile("mock")` / `@Profile("!mock")` para alternar entre mock e real sem alterar código;
- `RestClient` (Spring 6.1) como cliente HTTP — já disponível no Spring Boot 3.x, sem necessidade de WebFlux;
- Prompt com instrução explícita para retornar apenas JSON válido, conforme regras do PRD §8.5;
- MockWebServer (OkHttp) para testar o cliente real sem dependência de API externa.

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

### Prompt 01 — Criação completa do frontend

**Etapa:** Implementação / Frontend  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Criar o frontend completo do IdeaCheck AI com HTML5, CSS3 e JavaScript Vanilla puro, seguindo fielmente os documentos do projeto (PRD, fluxograma, UML, VIABILIDADE e MATRIZ_RASTREABILIDADE).

**Prompt utilizado:**

Você é um engenheiro frontend sênior especialista em UX/UI.

Crie APENAS o frontend de um formulário baseado nos documentos:
- @docs/PRD.md  
- @docs/fluxograma.md  
- @docs/MATRIZ_RASTREABILIDADE.md  
- @docs/uml.md  
- @docs/VIABILIDADE.md  

Regras:
- Sem backend real
- Sem frameworks
- Não usar React, Vue ou Angular
- Utilizar apenas HTML5, CSS3 e JavaScript Vanilla
- APIs devem ser mockadas localmente

Objetivo:
Construir uma interface moderna, responsiva e pronta para produção, seguindo fielmente os documentos do projeto.

Analise os documentos e implemente:
- campos
- regras de negócio
- validações
- fluxos
- estados
- mensagens
- comportamento esperado

Estrutura esperada:
/
  index.html
  /css
    style.css
    components.css
    responsive.css
  /js
    app.js
    api.js
    validation.js
    ui.js
    storage.js
  /mocks
    mock-data.js
  /assets

Requisitos:
- UI moderna inspirada em Stripe, Linear, Notion e Vercel
- Layout clean e minimalista
- Mobile-first
- Feedback visual em ações
- Loading, success e error states
- Validação amigável
- Transições suaves
- Acessibilidade básica
- Código modular, reutilizável e sem duplicação

Funcionalidades:
- validação em JS
- máscaras quando necessário
- submit mockado
- prevenção de múltiplos submits
- mock de API com Promise + setTimeout
- sucesso, erro e loading simulados

Extras opcionais:
- multi-step form
- progress bar
- localStorage autosave
- toasts
- animações suaves
- resumo antes do envio

Entregáveis:
- frontend completo
- HTML organizado
- CSS responsivo
- JS modularizado
- mocks
- validações
- README com instruções

Importante:
- Não gerar interface genérica
- Priorizar UX, clareza e refinamento visual
- Usar dados mockados realistas
- A aplicação deve parecer profissional e pronta para uso

Ao finalizar:
- preencher @docs/checklist-final.md
- adicionar este prompt em @docs/prompts.md na seção "## Jardel", linha 420, seguindo o padrão do arquivo

**Resultado aproveitado:**

Foi criado o frontend completo em `frontend/` com:

- `index.html` — estrutura semântica acessível com formulário multi-step (3 passos: ideia → detalhes → revisão)
- `css/style.css` — design system com CSS custom properties, suporte a dark mode, tipografia Inter e layout responsivo
- `css/components.css` — todos os componentes: badge animado, botões, form card, progress bar, segment selector, inputs, loading animation, score circle SVG animado, result cards, tag lists, step list, toast notifications
- `css/responsive.css` — breakpoints para mobile (<600px), tablet (600–900px) e desktop (≥900px), com suporte a prefers-reduced-motion
- `js/app.js` — orquestrador principal com state machine, navegação entre passos, autosave no localStorage, submit com prevenção de duplo envio
- `js/api.js` — serviço mockado com Promise + setTimeout (3.2s de delay realista), flag USE_MOCK para alternar entre mock e API real
- `js/validation.js` — regras de validação por campo com mensagens em português, validação por passo e inline (no blur e no input)
- `js/ui.js` — renderização do segment selector, review card, loading steps sequenciais, score circle com animação SVG, result cards, toasts
- `js/storage.js` — autosave de rascunho e preferência de tema no localStorage
- `mocks/mock-data.js` — respostas mockadas personalizadas por segmento (Saúde, Educação, Tecnologia, Comércio, Serviços) usando os dados reais do formulário

---

### Prompt 02 — Correções de UX/UI no frontend

**Etapa:** Ajustes visuais / refinamento de UX  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Corrigir pontos de UX e UI identificados após visualização da interface.

**Prompt utilizado:**

Pontos de correções

Na primeira etapa:
1 - Remova o powered by ai da pagina inicial.
2 - Centralize as etapas do processo (1 Sua ideia, 2 Detalhes, 3 Revisão). Utilize todo o espaço do formulario dando mais espaçamento entre as etapas.
3 - Em segmento, deixe todas as opções do mesmo tamanho, pode utilizar duas linhas para melhorar a utilização e nao cortar o nome dos segmentos.

Etapa de resultados:
1 - As cores do "Analise gerada por ia" estão horriveis de leitura no modo escuro. Melhore a UX.
2 - A nota da ideia está quebrando, diminua o tamanho para que caiba dentro do circulo.

Ao finalizar:
- adicionar este prompt em @docs/prompts.md na seção "## Jardel", linha 473, seguindo o padrão do arquivo

**Resultado aproveitado:**

Foram aplicadas as seguintes correções:

- Badge "Powered by AI" removido da seção hero
- Step indicators centralizados com `justify-content: space-between` ocupando todo o espaço disponível; labels visíveis em todos os tamanhos; ícone do step com `flex-direction: column`
- Segmento fixado em `repeat(4, 1fr)` em todos os breakpoints (2 linhas de 4), `min-height: 72px` para uniformidade, `word-break: break-word` para nomes completos sem abreviação; nomes completos "Sustentabilidade" e "Entretenimento" restaurados
- Badge `badge--ai` corrigido no dark mode com override explícito `[data-theme='dark'] .badge--ai` usando cores `#3b2f6e` / `#c4b5fd` para contraste adequado
- `score-number` reduzido de 32px para 26px e `score-max` de 14px para 11px com `gap: 1px` para garantir encaixe dentro do círculo SVG de 120px

---

### Prompt 03 — Correção do score circle (nota quebrando)

**Etapa:** Ajuste visual / score display  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Corrigir o posicionamento da nota de viabilidade dentro do círculo SVG, que seguia quebrando mesmo após a redução do tamanho da fonte.

**Prompt utilizado:**

> A nota segue quebrando, segue imagem. A nota precisa ficar em um tamanho agradavel e centralizada dentro do ciruclo, de maneira que o usuario consiga ver perfeitamente.

**Resultado aproveitado:**

A causa raiz foi identificada: o `.score-inner` usava `flex-direction: row` com `align-self: flex-end` no elemento `/10`, que o empurrava para fora do centro do círculo. A correção mudou o layout para `flex-direction: column` com `align-items: center` e `justify-content: center`, empilhando o número e o `/10` verticalmente e centralizando ambos dentro do SVG. O número foi ajustado para 30px e o `/10` para 11px com `gap: 2px`.

---

### Prompt 04 — Favicon com ícone do header

**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Adicionar favicon ao `frontend/index.html` usando o mesmo ícone `✦` exibido no logo do header, replicando o gradiente roxo → rosa em um SVG inline via data URI.

**Prompt utilizado:**

> Altere o favicon para o mesmo icone do header. Ao finalizar: - adicionar este prompt em @docs/prompts.md na seção '## Jardel', linha 585, seguindo o padrão do arquivo

**Resultado aproveitado:**

Adicionado `<link rel="icon" type="image/svg+xml">` com data URI SVG inline no `<head>` do `index.html`. O SVG usa um `<rect rx='6'>` com `linearGradient` de `#7c3aed` a `#ec4899` (idêntico ao `.header__logo`) e um `<text>` centralizado com o caractere `✦` em branco. Nenhuma imagem externa foi necessária.

---

### Prompt 05 — README do frontend

**Etapa:** Documentação técnica / frontend  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Criar um `README.md` dentro de `frontend/` explicando a arquitetura de pastas e como rodar o frontend localmente.

**Prompt utilizado:**

> Crie um README.md dentro de @frontend/ explicando a arquitetura de pastas e como rodar o frontend.
>
> Ao finalizar adicione também em @docs/prompts.md

**Resultado aproveitado:**

Foi criado o arquivo `frontend/README.md` documentando:

- como rodar o frontend com servidor HTTP estático (Python 3 ou npx serve);
- aviso sobre não abrir via `file://`;
- arquitetura de pastas com descrição de cada arquivo;
- instruções para alternar entre mock e API real via flag `USE_MOCK` em `js/api.js`;
- funcionamento do dark mode e do autosave via localStorage.

---

### Prompt 06 — Atualização do README principal com o frontend

**Etapa:** Documentação técnica / README  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Atualizar o `README.md` principal do repositório para refletir a arquitetura do frontend implementado e as instruções de execução.

**Prompt utilizado:**

> Altere o @README.md principal com as alterações do frontend que foram desenvolvidas, tanto arquitetura quanto como rodar o frontend.

**Resultado aproveitado:**

Foram aplicadas três atualizações no `README.md` raiz:

- **Seção 5** — estrutura de pastas expandida com todos os arquivos do `frontend/` e descrição de cada um (`index.html`, `css/`, `js/`, `mocks/`);
- **Seção 8** — link para `frontend/README.md` adicionado à lista de documentos do projeto;
- **Seção 10** — instruções de execução do frontend separadas do backend, com comandos para servidor HTTP estático (Python 3 / npx), aviso sobre `file://`, instrução da flag `USE_MOCK` e link para `frontend/README.md`.

---

### Prompt 07 — Externalizar configuração do frontend via config.js

**Etapa:** Configuração / ambiente  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Remover as variáveis de configuração hardcoded de `frontend/js/api.js` e externalizá-las em um arquivo `config.js` ignorado pelo git, com um `config.example.js` versionado como referência.

**Prompt utilizado:**

> Em @frontend/js/api.js altere as seguintes variáveis para que sejam pegas de um arquivo .env. Crie também um .env.example de exemplo para subir no repositório.
>
> const BASE_URL = 'http://localhost:8080/api/v1';  
> const USE_MOCK = true;  
> const MOCK_DELAY_MS = 3200;
>
> Adicione no arquivo @docs/prompts.md

**Resultado aproveitado:**

Como o frontend usa JS Vanilla sem bundler, variáveis `.env` não são acessíveis no browser. A solução adotada foi:

- Criado `frontend/config.example.js` (versionado) com `window.APP_CONFIG = { BASE_URL, USE_MOCK, MOCK_DELAY_MS }` como referência;
- O arquivo real `frontend/config.js` (copiado pelo dev a partir do exemplo) é carregado antes dos demais scripts em `index.html` e adicionado ao `.gitignore`;
- `frontend/js/api.js` passou a ler de `window.APP_CONFIG`, com fallback para os valores padrão caso o arquivo não exista.

---

### Prompt 08 — Documentar config.js no README do frontend e no README principal

**Etapa:** Documentação técnica / configuração  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Adicionar as instruções de uso do `config.js` nos arquivos `frontend/README.md` e `README.md` principal, mantendo a documentação sincronizada com a implementação.

**Prompt utilizado:**

> Adicione em @frontend/README.md e @README.md as informações sobre o config.js. Adicione isso em @docs/prompts.md também.

**Resultado aproveitado:**

- `frontend/README.md` — adicionada seção **Configuração do ambiente** com instrução de cópia do `config.example.js`, bloco de exemplo do `window.APP_CONFIG`, nota sobre fallback e atualização da arquitetura de pastas para incluir `config.example.js` e `config.js`; seção **Alternando entre mock e API real** atualizada para referenciar `config.js` em vez de `js/api.js`;
- `README.md` — seção **10. Como executar / Frontend** reescrita com passo a passo explícito: copiar o `config.example.js`, editar o `config.js` e subir o servidor HTTP; adicionado aviso sobre o arquivo não ser versionado.

---

### Prompt 09 — Tratamento de erro de conexão com o backend

**Etapa:** Robustez / tratamento de erros  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Substituir a mensagem genérica "Failed to fetch" por um erro legível e informativo quando `USE_MOCK` é `false` e o backend não está acessível.

**Prompt utilizado:**

> Implemente um tratamento de erro para quando USE_MOCK for false e o backend não estiver rodando. Atualmente está me retornando apenas o erro Failed to fetch. Adicione em @docs/prompts.md

**Resultado aproveitado:**

Em `frontend/js/api.js`:

- Adicionada função auxiliar `_isNetworkError(err)` que detecta `TypeError: Failed to fetch`;
- `_realValidate` passou a envolver o `fetch` em `try/catch`: erros de rede lançam um objeto estruturado com `status: 0` e mensagem "Não foi possível conectar ao servidor", e outros erros inesperados lançam "Erro de rede inesperado. Tente novamente.";
- `checkHealth` também passou a capturar erros de rede, retornando `{ status: 'DOWN' }` em vez de lançar uma exceção não tratada.

---

### Prompt 10 — Correção de erro de CORS no backend

**Etapa:** Configuração / integração frontend-backend  
**Ferramenta:** Claude Code (claude-sonnet-4-6)  
**Objetivo:** Corrigir o erro de CORS que impedia o frontend de fazer requisições ao backend Spring Boot rodando em `localhost:8080`.

**Prompt utilizado:**

> Estou tomando erro de cors ao tentar fazer o request

**Resultado aproveitado:**

Foi criado o arquivo `src/main/java/br/com/ideacheck/config/CorsConfig.java` implementando `WebMvcConfigurer` com a anotação `@Configuration`. A configuração libera as origens `http://localhost:3000` e `http://127.0.0.1:3000` para os métodos `GET` e `POST` no caminho `/api/**`, permitindo que o frontend sirido via servidor HTTP estático se comunique corretamente com a API.

---
