# Frontend — IdeaCheck AI

Interface web do validador de ideias de negócio com IA. Desenvolvida com HTML5, CSS3 e JavaScript Vanilla puro — sem frameworks ou bundlers.

## Como rodar

Qualquer servidor HTTP estático serve. O mais simples:

```bash
# Python 3
python3 -m http.server 3000

# Node.js (npx)
npx serve .
```

Depois acesse `http://localhost:3000` no navegador.

> Não abra o `index.html` direto pelo sistema de arquivos (`file://`) — o carregamento dos scripts pode falhar em alguns navegadores por restrições de CORS local.

## Configuração do ambiente

As variáveis de ambiente do frontend ficam em `config.js`, que **não é versionado** (está no `.gitignore`).

Antes de rodar pela primeira vez, copie o arquivo de exemplo:

```bash
cp config.example.js config.js
```

Edite `config.js` conforme o seu ambiente:

```js
window.APP_CONFIG = {
  BASE_URL: 'http://localhost:8080/api/v1', // URL base da API
  USE_MOCK: true,                           // true = mock local, false = API real
  MOCK_DELAY_MS: 3200,                      // delay simulado do mock (ms)
};
```

> O `config.js` é carregado automaticamente pelo `index.html` antes dos demais scripts. Se o arquivo não existir, os valores padrão definidos em `js/api.js` são usados como fallback.

## Arquitetura de pastas

```
frontend/
├── index.html              # Único ponto de entrada da aplicação
├── config.example.js       # Modelo de configuração — copie para config.js
├── config.js               # Configuração local (não versionado)
├── css/
│   ├── style.css           # Design system: custom properties, dark mode, tipografia, layout
│   ├── components.css      # Todos os componentes visuais (cards, botões, score circle, toasts…)
│   └── responsive.css      # Breakpoints: <360px, <600px, 600–900px, ≥900px, ≥1200px
├── js/
│   ├── app.js              # Orquestrador: state machine, navegação entre steps, submit
│   ├── api.js              # Camada de API — lê configuração de window.APP_CONFIG
│   ├── validation.js       # Regras de validação por campo, validação por step
│   ├── ui.js               # Renderização de componentes (segmentos, score, resultados, toasts)
│   └── storage.js          # Autosave de rascunho e preferência de tema no localStorage
└── mocks/
    └── mock-data.js        # Respostas simuladas personalizadas por segmento
```

## Alternando entre mock e API real

Em `config.js`, altere a propriedade `USE_MOCK`:

```js
USE_MOCK: true,   // usa mock-data.js (padrão)
USE_MOCK: false,  // chama a URL definida em BASE_URL
```

O backend precisa estar rodando localmente para `USE_MOCK: false` funcionar.

## Dark mode

Alternado pelo botão no header. A preferência é salva no `localStorage` e restaurada automaticamente no próximo acesso.

## Autosave

O formulário salva o rascunho no `localStorage` a cada alteração de campo. Ao reabrir a página, os campos são restaurados automaticamente.
