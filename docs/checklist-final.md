# Checklist Final de Entrega — IdeaCheck AI

Este checklist deve ser usado antes da entrega final do mini-projeto avaliativo.

O objetivo é garantir que o repositório esteja completo, acessível, funcional e alinhado aos requisitos da atividade.

---

## 1. Repositório e organização

- [x] Repositório criado como `ideacheck-ai`.
- [x] Repositório no local correto conforme orientação do tutor.
- [x] Link do repositório testado em aba anônima.
- [x] Repositório acessível para avaliação.
- [x] Todos os integrantes adicionados como colaboradores.
- [x] Cada integrante possui pelo menos um commit real.
- [x] Branches por funcionalidade criadas.
- [x] Pelo menos um Pull Request aberto com template preenchido.
- [x] Histórico de commits reflete a evolução real do projeto.

---

## 2. Documentação obrigatória

- [x] `README.md` preenchido.
- [x] `docs/PRD.md` preenchido.
- [x] `docs/VIABILIDADE.md` preenchido.
- [x] `docs/prompts.md` preenchido com seção por integrante.
- [x] `docs/fluxograma.md` preenchido.
- [x] `docs/uml.md` preenchido.
- [x] `docs/MATRIZ_RASTREABILIDADE.md` preenchido.
- [x] `docs/checklist-final.md` preenchido.

---

## 3. Uso de IA no projeto

- [x] IA possui papel funcional no produto.
- [x] O usuário envia uma ideia de negócio para análise.
- [x] O sistema retorna uma análise estruturada com apoio de IA ou mock.
- [x] O prompt principal está versionado no repositório.
- [x] O projeto documenta o uso de IA no desenvolvimento.
- [x] Cada integrante registrou os prompts usados na sua parte.
- [x] Limitações da IA estão documentadas.
- [x] O projeto deixa claro que a análise é inicial e não validação definitiva de mercado.

---

## 4. Funcionalidades mínimas

- [x] Aplicação Spring Boot sobe localmente.
- [x] Endpoint `GET /api/v1/health` funciona.
- [x] Bootstrap mínimo do backend concluído (`IdeacheckAiApplication`, `application.yml`, DTOs e controllers base).
- [x] Endpoint `POST /api/v1/validate-idea` funciona com camada de serviço de IA e modo mock.
- [x] Request segue o schema inicial definido no PRD.
- [x] Response segue o schema inicial definido no PRD.
- [x] Existe modo mock para funcionamento sem chave de API.
- [x] Frontend envia dados para a API.
- [x] Frontend exibe a análise retornada.
- [x] Erros básicos são tratados.

---

## 5. Testes e qualidade

- [x] Existem pelo menos 5 testes automatizados.
- [x] Testes da API implementados.
- [x] Testes da camada de serviço implementados.
- [x] Testes do prompt/parser implementados, se aplicável.
- [x] `mvn test` executa com sucesso após inclusão dos testes.
- [x] GitHub Actions executa os testes.
- [x] GitHub Actions está verde antes da entrega.

---

## 6. Pull Requests e contribuição individual

- [x] Ernesto possui commits na parte de Backend/API/CI.
- [x] Filipe possui commits na parte de Serviço de IA.
- [x] Eliandro possui commits na parte de Prompt/Parser/Critérios.
- [x] Jardel possui commits na parte de Frontend.
- [x] Edenilson possui commits na parte de Documentação/Requisitos.
- [x] Pull Requests possuem descrição clara.
- [x] Pull Requests explicam o que foi alterado e como testar.

---

## 7. Revisão final

- [x] Projeto testado localmente.
- [x] README contém instruções de execução.
- [x] README contém instruções para rodar testes.
- [x] Link do repositório testado em aba anônima.
- [x] Slides de 2 a 3 páginas preparados, se exigidos.
- [x] Link final enviado no AVA antes do prazo.
- [x] Repositório congelado após o envio.