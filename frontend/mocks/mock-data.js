const SEGMENTS_DATA = {
  saude: {
    concorrenciaAlternativas: [
      'iClinic e sistemas de gestão de clínicas',
      'Armazenamento em nuvem (Google Drive, iCloud)',
      'Prontuário eletrônico do paciente (PEP)',
      'Plataformas de telemedicina (Docway, Doctoralia)',
    ],
    pontosFortes: [
      'Resolve problema recorrente em um setor crítico',
      'Alta demanda por digitalização no setor de saúde',
      'Pode economizar tempo de profissionais e pacientes',
      'Potencial de integração com sistemas hospitalares existentes',
    ],
    riscos: [
      'Conformidade rigorosa com LGPD e normativas de saúde',
      'Alta barreira regulatória de entrada no setor',
      'Infraestrutura segura para dados sensíveis é cara',
      'Resistência à adoção por parte de profissionais de saúde',
    ],
    perguntasAbertas: [
      'Como garantir conformidade com a LGPD no armazenamento dos dados?',
      'Qual modelo de monetização: SaaS, freemium ou licença?',
      'Quem é o decisor de compra: clínica, médico ou paciente?',
      'Como diferenciar de soluções já consolidadas no mercado?',
    ],
    analiseDoSegmento:
      'O segmento de saúde exige atenção especial à privacidade e segurança dos dados, com conformidade obrigatória à LGPD e normativas do CFM e ANS. Ao mesmo tempo, apresenta alta demanda reprimida por soluções digitais e disposição real de pagamento por valor percebido.',
    notaBase: 7,
  },
  educacao: {
    concorrenciaAlternativas: [
      'Plataformas LMS consolidadas (Moodle, Google Classroom)',
      'Aplicativos de estudo (Duolingo, Khan Academy)',
      'Cursos em plataformas abertas (Coursera, Udemy)',
      'Tutoria presencial e serviços de reforço escolar',
    ],
    pontosFortes: [
      'Mercado educacional em crescimento acelerado pós-pandemia',
      'Alta demanda por personalização no aprendizado',
      'Escalabilidade digital elevada com baixo custo marginal',
      'Impacto social positivo e mensurável',
    ],
    riscos: [
      'Mercado com players consolidados e bem financiados',
      'Monetização complexa em segmento público',
      'Engajamento de longo prazo difícil de manter',
      'Necessidade de conteúdo de qualidade constante e atualizado',
    ],
    perguntasAbertas: [
      'O foco é ensino básico, técnico, superior ou corporativo?',
      'Qual o modelo de negócio: B2C, B2B ou B2G?',
      'Como garantir qualidade e atualização contínua do conteúdo?',
      'Qual diferencial real em relação às plataformas já estabelecidas?',
    ],
    analiseDoSegmento:
      'O setor educacional passa por transformação digital acelerada, com crescimento expressivo no ensino híbrido e online. Há espaço para soluções inovadoras focadas em personalização, engajamento e acompanhamento do aluno, especialmente em nichos ainda pouco atendidos.',
    notaBase: 7,
  },
  tecnologia: {
    concorrenciaAlternativas: [
      'Soluções SaaS consolidadas no mercado global',
      'Ferramentas open source amplamente adotadas',
      'Grandes players de tecnologia (Google, Microsoft, AWS)',
      'Startups com produtos similares já com tração e financiamento',
    ],
    pontosFortes: [
      'Mercado global com escala potencial muito elevada',
      'Custo de distribuição digital baixo após desenvolvimento',
      'Possibilidade de automação e crescimento acelerado',
      'Perfil técnico alinhado ao perfil de adotantes iniciais',
    ],
    riscos: [
      'Alta concorrência de soluções já estabelecidas e gratuitas',
      'Ciclo de adoção pode ser longo dependendo do público',
      'Necessidade de investimento contínuo em desenvolvimento',
      'Risco de obsolescência rápida da tecnologia utilizada',
    ],
    perguntasAbertas: [
      'Qual é o diferencial técnico claro em relação às alternativas?',
      'Como será o modelo de precificação (freemium, trial, licença)?',
      'Qual o custo de aquisição de cliente (CAC) esperado?',
      'Existe barreira técnica que impeça cópia rápida por concorrentes?',
    ],
    analiseDoSegmento:
      'O setor de tecnologia é altamente competitivo e dinâmico, com ciclos de inovação curtos. O sucesso depende do diferencial técnico concreto, velocidade de execução e capacidade de escalar rapidamente. Soluções B2B tendem a ter maior previsibilidade de receita e menor churn.',
    notaBase: 7,
  },
  comercio: {
    concorrenciaAlternativas: [
      'Marketplaces consolidados (Mercado Livre, Amazon, Shopee)',
      'E-commerce próprio com plataformas prontas (VTEX, Shopify)',
      'Lojas físicas estabelecidas no segmento',
      'Distribuidores e atacadistas tradicionais',
    ],
    pontosFortes: [
      'Demanda de consumo sempre existente',
      'Potencial de margens atrativas em nichos específicos',
      'Possibilidade de fidelização e receita recorrente',
      'Oportunidade em mercados locais ou de nicho ignorados',
    ],
    riscos: [
      'Concorrência intensa de grandes marketplaces com poder de preço',
      'Logística e fulfillment como desafio operacional crítico',
      'Pressão de margem em produtos sem diferenciação clara',
      'Necessidade de capital de giro para gestão de estoque',
    ],
    perguntasAbertas: [
      'Qual é o nicho específico e o diferencial de produto?',
      'Como será resolvida a logística de entrega de forma competitiva?',
      'Qual a margem esperada e o volume mínimo viável?',
      'Como fidelizar o cliente após a primeira compra?',
    ],
    analiseDoSegmento:
      'O setor comercial tem alta competição de plataformas estabelecidas, mas ainda apresenta oportunidades reais em nichos específicos, produtos artesanais, experiências de compra diferenciadas e atendimento personalizado. O sucesso depende de uma proposta de valor clara e estratégia de diferenciação sustentável.',
    notaBase: 6,
  },
  servicos: {
    concorrenciaAlternativas: [
      'Prestadores de serviço tradicionais locais',
      'Marketplaces de serviços (GetNinjas, Workana, 99freelas)',
      'Agências e consultorias estabelecidas',
      'Freelancers e profissionais autônomos',
    ],
    pontosFortes: [
      'Menor necessidade de capital inicial para validação',
      'Possibilidade de validação rápida com clientes reais',
      'Alta recorrência potencial se o serviço for bem executado',
      'Relacionamento próximo com o cliente gera fidelização',
    ],
    riscos: [
      'Escalabilidade limitada em modelos humano-intensivos',
      'Dependência de profissionais qualificados e confiáveis',
      'Dificuldade de padronização da qualidade do serviço',
      'Precificação e comparação fácil com concorrentes diretos',
    ],
    perguntasAbertas: [
      'Como o serviço será padronizado e mantido em qualidade?',
      'Qual o modelo de precificação: por hora, projeto ou assinatura?',
      'Como o negócio escala além do esforço do fundador?',
      'Quais certificações ou credenciais são necessárias?',
    ],
    analiseDoSegmento:
      'O setor de serviços oferece oportunidades de validação rápida com baixo capital inicial, mas apresenta desafios de escalabilidade. Modelos de serviço como plataforma (marketplace) ou produtização do serviço podem aumentar a escalabilidade e a previsibilidade de receita.',
    notaBase: 6,
  },
};

const DEFAULT_SEGMENT_DATA = {
  concorrenciaAlternativas: [
    'Soluções já estabelecidas no mercado',
    'Alternativas tradicionais não digitais',
    'Produtos similares de grandes empresas do setor',
  ],
  pontosFortes: [
    'Resolve um problema identificável e real',
    'Potencial de diferenciação no segmento escolhido',
    'Oportunidade de inovação em mercado ainda em evolução',
  ],
  riscos: [
    'Necessidade urgente de validação com usuários reais',
    'Concorrência de players estabelecidos no mercado',
    'Dependência da adesão e engajamento do público-alvo',
  ],
  perguntasAbertas: [
    'Quem pagaria pela solução e qual o valor percebido?',
    'Qual o diferencial real em relação às alternativas?',
    'Como será adquirido o primeiro cliente pagante?',
  ],
  analiseDoSegmento:
    'O segmento escolhido possui características específicas que devem ser mapeadas com cuidado. A análise de concorrentes diretos e a validação com potenciais usuários são etapas essenciais antes de qualquer investimento significativo.',
  notaBase: 6,
};

function getSegmentData(segmento) {
  if (!segmento) return DEFAULT_SEGMENT_DATA;
  const key = segmento
    .toLowerCase()
    .normalize('NFD')
    .replace(/[̀-ͯ]/g, '')
    .replace(/[^a-z]/g, '');

  if (key.includes('saude') || key.includes('saúde')) return SEGMENTS_DATA.saude;
  if (key.includes('educa')) return SEGMENTS_DATA.educacao;
  if (key.includes('tecnol')) return SEGMENTS_DATA.tecnologia;
  if (key.includes('comerc') || key.includes('comerci')) return SEGMENTS_DATA.comercio;
  if (key.includes('servic') || key.includes('serviç')) return SEGMENTS_DATA.servicos;
  return DEFAULT_SEGMENT_DATA;
}

function generateMockResponse(formData) {
  const segData = getSegmentData(formData.segmento);
  const nota = Math.min(10, segData.notaBase + (Math.random() > 0.5 ? 1 : 0));

  const resumoParts = formData.descricao
    ? formData.descricao.trim().split(' ').slice(0, 20).join(' ')
    : `solução no segmento de ${formData.segmento}`;

  const resumo =
    resumoParts.length < formData.descricao.length
      ? resumoParts + '...'
      : resumoParts;

  return {
    resumo: `${formData.titulo}: ${resumo}`,
    problema:
      formData.problema ||
      `Dificuldade de acesso, organização e eficiência no segmento de ${formData.segmento.toLowerCase()}, resolvível com uma solução digital focada e bem executada.`,
    publicoAlvo:
      formData.publicoAlvo ||
      `Pessoas e organizações do segmento de ${formData.segmento.toLowerCase()} que buscam mais eficiência, praticidade e redução de fricção nos seus processos.`,
    propostaValor: `"${formData.titulo}" propõe simplificar e agregar valor no segmento de ${formData.segmento.toLowerCase()}, reduzindo fricção e oferecendo uma experiência superior às alternativas existentes no mercado.`,
    concorrenciaAlternativas: segData.concorrenciaAlternativas,
    pontosFortes: segData.pontosFortes,
    riscos: segData.riscos,
    perguntasAbertas: segData.perguntasAbertas,
    analiseDoSegmento: segData.analiseDoSegmento,
    notaViabilidade: nota,
    justificativaNota: `"${formData.titulo}" demonstra potencial no segmento de ${formData.segmento.toLowerCase()}, com problema identificável e público-alvo definido. A nota ${nota}/10 reflete a viabilidade inicial, considerando os riscos e oportunidades do segmento. É necessária validação com usuários reais antes de qualquer investimento significativo.`,
    proximosPassos: [
      'Entrevistar ao menos 5 potenciais usuários para validar o problema e a solução',
      'Criar um protótipo simples ou landing page para medir o interesse real do mercado',
      `Mapear os 3 principais concorrentes diretos no segmento de ${formData.segmento.toLowerCase()}`,
      'Definir o modelo de negócio e estimar o custo de aquisição de clientes (CAC)',
      'Desenvolver um MVP com as funcionalidades essenciais e testar com usuários reais',
    ],
  };
}
