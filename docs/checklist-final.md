# Checklist Final de Entrega — IdeaCheck AI

Este checklist deve ser usado antes da entrega final do mini-projeto avaliativo.

O objetivo é garantir que o repositório esteja completo, acessível, funcional e alinhado aos requisitos da atividade.

---

## 1. Repositório e organização

- [ ] Repositório criado como `ideacheck-ai`.
- [ ] Repositório no local correto conforme orientação do tutor.
- [ ] Repositório migrado para a organização `IA-para-DEVs-SCTEC-T1` após confirmação do Tiago.
- [ ] Origin local atualizado para a nova URL após a migração.
- [ ] Link da nova URL testado em aba anônima.
- [ ] Repositório acessível para avaliação.
- [ ] Todos os integrantes adicionados como colaboradores.
- [ ] Cada integrante possui pelo menos um commit real.
- [ ] Branches por funcionalidade criadas.
- [ ] Pelo menos um Pull Request aberto com template preenchido.
- [ ] Histórico de commits reflete a evolução real do projeto.

---

## 2. Documentação obrigatória

- [ ] `README.md` preenchido.
- [ ] `docs/PRD.md` preenchido.
- [ ] `docs/VIABILIDADE.md` preenchido.
- [ ] `docs/prompts.md` preenchido com seção por integrante.
- [ ] `docs/fluxograma.md` preenchido.
- [ ] `docs/uml.md` preenchido.
- [ ] `docs/MATRIZ_RASTREABILIDADE.md` preenchido.
- [ ] `docs/checklist-final.md` preenchido.

---

## 3. Uso de IA no projeto

- [ ] IA possui papel funcional no produto.
- [ ] O usuário envia uma ideia de negócio para análise.
- [ ] O sistema retorna uma análise estruturada com apoio de IA ou mock.
- [ ] O prompt principal está versionado no repositório.
- [ ] O projeto documenta o uso de IA no desenvolvimento.
- [ ] Cada integrante registrou os prompts usados na sua parte.
- [ ] Limitações da IA estão documentadas.
- [ ] O projeto deixa claro que a análise é inicial e não validação definitiva de mercado.

---

## 4. Funcionalidades mínimas

- [ ] Aplicação Spring Boot sobe localmente.
- [ ] Endpoint `GET /api/v1/health` funciona.
- [ ] Bootstrap mínimo do backend concluído (`IdeacheckAiApplication`, `application.yml`, DTOs e controllers base).
- [ ] Endpoint `POST /api/v1/validate-idea` funciona.
- [ ] Request segue o schema definido no PRD.
- [ ] Response segue o schema definido no PRD.
- [ ] Existe modo mock para funcionamento sem chave de API.
- [x] Frontend envia dados para a API.
- [x] Frontend exibe a análise retornada.
- [x] Erros básicos são tratados.

---

## 5. Testes e qualidade

- [ ] Existem pelo menos 5 testes automatizados.
- [ ] Testes da API implementados.
- [ ] Testes da camada de serviço implementados.
- [ ] Testes do prompt/parser implementados, se aplicável.
- [ ] `mvn test` executa com sucesso.
- [ ] GitHub Actions executa os testes.
- [ ] GitHub Actions está verde antes da entrega.

---

## 6. Pull Requests e contribuição individual

- [ ] Ernesto possui commits na parte de Backend/API/CI.
- [ ] Filipe possui commits na parte de Serviço de IA.
- [ ] Eliandro possui commits na parte de Prompt/Parser/Critérios.
- [x] Jardel possui commits na parte de Frontend.
- [ ] Edenilson possui commits na parte de Documentação/Requisitos.
- [ ] Pull Requests possuem descrição clara.
- [ ] Pull Requests explicam o que foi alterado e como testar.

---

## 7. Revisão final

- [ ] Projeto testado localmente.
- [ ] README contém instruções de execução.
- [ ] README contém instruções para rodar testes.
- [ ] Link do repositório testado em aba anônima.
- [ ] Slides de 2 a 3 páginas preparados, se exigidos.
- [ ] Link final enviado no AVA antes do prazo.
- [ ] Repositório congelado após o envio.
