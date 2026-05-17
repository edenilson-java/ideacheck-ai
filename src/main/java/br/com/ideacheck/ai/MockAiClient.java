package br.com.ideacheck.ai;

import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementação mock do AiClient.
 * Retorna resposta estática para demonstração e testes sem chave de API.
 * Ativada com o profile "mock" (--spring.profiles.active=mock).
 */
@Component
@Profile("mock")
public class MockAiClient implements AiClient {

    @Override
    public ValidationResponse analyze(ValidationRequest request) {
        return new ValidationResponse(
            "Análise da ideia: " + request.titulo(),
            request.problema() != null && !request.problema().isBlank()
                ? request.problema()
                : "Problema não especificado pelo usuário.",
            request.publicoAlvo() != null && !request.publicoAlvo().isBlank()
                ? request.publicoAlvo()
                : "Público-alvo não especificado.",
            "Solução que atende à necessidade identificada no segmento de " + request.segmento() + ".",
            List.of(
                "Soluções existentes no mercado",
                "Alternativas manuais ou informais",
                "Ferramentas genéricas adaptadas"
            ),
            List.of(
                "Resolve um problema real",
                "Público-alvo identificável",
                "Segmento com demanda"
            ),
            List.of(
                "Necessidade de validação com usuários reais",
                "Concorrência já estabelecida",
                "Modelo de monetização indefinido"
            ),
            List.of(
                "Quem pagaria pela solução?",
                "Qual o diferencial competitivo?",
                "Como adquirir os primeiros usuários?"
            ),
            "O segmento de " + request.segmento() + " apresenta oportunidades, mas exige atenção a regulamentações e concorrência.",
            7,
            "A ideia apresenta potencial, mas precisa de validação prática com usuários e definição clara de modelo de negócio.",
            List.of(
                "Entrevistar potenciais usuários",
                "Pesquisar concorrentes diretos",
                "Criar protótipo mínimo para validação"
            )
        );
    }
}
