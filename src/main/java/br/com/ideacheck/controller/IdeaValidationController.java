package br.com.ideacheck.controller;

import br.com.ideacheck.ai.IdeaValidationService;
import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class IdeaValidationController {

    private final IdeaValidationService validationService;

    public IdeaValidationController(IdeaValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/validate-idea")
    public ResponseEntity<ValidationResponse> validateIdea(@Valid @RequestBody ValidationRequest request) {
        ValidationResponse response = validationService.validate(request);
        return ResponseEntity.ok(response);
    }
}
