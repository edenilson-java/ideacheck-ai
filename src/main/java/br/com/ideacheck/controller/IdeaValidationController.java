package br.com.ideacheck.controller;

import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class IdeaValidationController {

    @PostMapping("/validate-idea")
    public ResponseEntity<ValidationResponse> validateIdea(@Valid @RequestBody ValidationRequest request) {
        ValidationResponse mockResponse = new ValidationResponse(
            "Plataforma para organização e consulta de documentos médicos.",
            "Dificuldade de centralizar e acessar documentos médicos de forma prática.",
            "Clínicas, médicos e pacientes.",
            "Facilitar a organização, consulta e compartilhamento seguro de documentos.",
            List.of(
                "Pastas em nuvem",
                "Sistemas de gestão clínica",
                "Armazenamento manual de documentos"
            ),
            List.of(
                "Resolve um problema recorrente",
                "Pode economizar tempo dos usuários"
            ),
            List.of(
                "Necessidade de cuidado com privacidade",
                "Dependência da adesão dos usuários"
            ),
            List.of(
                "Quem pagaria pela solução?",
                "Como garantir segurança dos dados?"
            ),
            "O segmento de saúde exige atenção especial à privacidade e segurança das informações.",
            7,
            "A ideia resolve um problema real e tem público-alvo identificável, mas ainda depende de validação com usuários e definição de modelo de negócio.",
            List.of(
                "Entrevistar potenciais usuários",
                "Validar disposição de pagamento",
                "Criar protótipo simples"
            )
        );

        // TODO: substituir mock por chamada ao service quando estiver pronto
        return ResponseEntity.ok(mockResponse);
    }
}
