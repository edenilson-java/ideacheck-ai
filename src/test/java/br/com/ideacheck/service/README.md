# Testes de Prompt e Parser — IdeaCheck AI

Este documento orienta como executar os testes automatizados da frente **Prompt, Parser e Critérios**.

Os testes cobrem dois componentes principais:

- `PromptBuilderTest`
- `ValidationResponseParserTest`

---

## 1. Objetivo dos testes

A frente de Prompt, Parser e Critérios é responsável por garantir que:

1. o prompt final enviado para a LLM seja montado corretamente;
2. os dados do usuário sejam inseridos no template de prompt;
3. os placeholders sejam substituídos corretamente;
4. caracteres especiais sejam tratados sem quebrar o JSON embutido no prompt;
5. a resposta bruta da IA seja validada antes de virar um `ValidationResponse`;
6. apenas respostas compatíveis com o contrato do PRD sejam aceitas.

---

## 2. Arquivos testados

### `PromptBuilderTest`

Testa a classe:

```text
src/main/java/br/com/ideacheck/service/PromptBuilder.java
```

Essa classe monta o prompt final a partir do template:

```text
src/main/resources/prompts/business-validator-system.txt
```

### `ValidationResponseParserTest`

Testa a classe:

```text
src/main/java/br/com/ideacheck/service/ValidationResponseParser.java
```

Essa classe recebe a resposta bruta da IA, extrai o JSON quando possível, valida o contrato esperado e converte a resposta para `ValidationResponse`.

---

## 3. Pré-requisitos

Antes de rodar os testes, verifique se você está na raiz do projeto e se o Maven está disponível.

Para conferir:

```bash
mvn -v
```

Também verifique se o projeto compila:

```bash
mvn clean test
```

---

## 4. Executar apenas o teste do PromptBuilder

Use o comando:

```bash
mvn -Dtest=PromptBuilderTest test
```

Esse teste verifica se o `PromptBuilder`:

* inclui os dados do usuário no prompt final;
* substitui todos os placeholders;
* preserva instruções importantes do prompt;
* trata campos opcionais nulos como string vazia;
* escapa aspas, quebras de linha, tabulações e barras invertidas;
* lança exceção previsível quando recebe `null`.

Resultado esperado:

```text
BUILD SUCCESS
```

---

## 5. Executar apenas o teste do ValidationResponseParser

Use o comando:

```bash
mvn -Dtest=ValidationResponseParserTest test
```

Esse teste verifica se o `ValidationResponseParser`:

* converte JSON válido em `ValidationResponse`;
* extrai JSON quando há texto antes ou depois;
* rejeita resposta nula, vazia ou sem JSON;
* rejeita JSON inválido;
* rejeita campo obrigatório ausente;
* rejeita campo obrigatório nulo;
* rejeita campo extra;
* rejeita campos de texto que não sejam string;
* rejeita campos de lista que não sejam array;
* rejeita listas com itens que não sejam string;
* rejeita listas com mais de 5 itens;
* rejeita `notaViabilidade` como string;
* rejeita `notaViabilidade` decimal;
* rejeita `notaViabilidade` menor que 0;
* rejeita `notaViabilidade` maior que 10;
* aceita strings vazias e listas vazias quando o schema continua válido.

Resultado esperado:

```text
BUILD SUCCESS
```

---

## 6. Executar os dois testes juntos

Use o comando:

```bash
mvn -Dtest=PromptBuilderTest,ValidationResponseParserTest test
```

Resultado esperado:

```text
BUILD SUCCESS
```

---

## 7. Executar todos os testes do projeto

Use o comando:

```bash
mvn test
```

ou, para limpar e rodar tudo do zero:

```bash
mvn clean test
```

---

## 8. Como interpretar falhas

Se algum teste falhar, observe a mensagem exibida no terminal.

Falhas comuns:

### Placeholder não substituído

Pode indicar que o template contém um placeholder diferente do esperado.

Exemplo:

```text
{{publico_alvo}}
```

em vez de:

```text
{{publicoAlvo}}
```

### Prompt não encontrado

Pode indicar que o arquivo não está no caminho esperado:

```text
src/main/resources/prompts/business-validator-system.txt
```

### Campo do JSON não encontrado

Pode indicar diferença entre o contrato do PRD e os campos usados no parser ou nos testes.

### Erro em `notaViabilidade`

Pode indicar que o parser está aceitando valores inválidos ou rejeitando valores válidos.

### Métodos do DTO não encontrados

Se `ValidationRequest` ou `ValidationResponse` não forem `record`, talvez seja necessário trocar chamadas como:

```java
response.resumo()
```

por:

```java
response.getResumo()
```

---

## 9. Critério de aceite

A tarefa de testes da frente Prompt, Parser e Critérios pode ser considerada concluída quando:

* `PromptBuilderTest` executa com sucesso;
* `ValidationResponseParserTest` executa com sucesso;
* os dois testes rodam juntos com sucesso;
* `mvn test` não quebra por causa desses testes;
* os testes cobrem cenários válidos e inválidos;
* o parser aceita apenas respostas compatíveis com o contrato esperado.
