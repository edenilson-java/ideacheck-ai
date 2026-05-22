package br.com.ideacheck.controller;

import br.com.ideacheck.ai.AiClientException;
import br.com.ideacheck.dto.ErrorResponse;
import br.com.ideacheck.service.PromptBuilder;
import br.com.ideacheck.service.ValidationResponseParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        List<String> details = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(
                        HttpStatus.BAD_REQUEST.value(),
                        "Bad Request",
                        "Campos obrigatórios ausentes ou inválidos.",
                        details
                ));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(
                        HttpStatus.BAD_REQUEST.value(),
                        "Bad Request",
                        "Requisição com formato inválido.",
                        List.of()
                ));
    }

    @ExceptionHandler(AiClientException.class)
    public ResponseEntity<ErrorResponse> handleAiClient(AiClientException ex) {
        log.error("Falha no cliente de IA: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(ErrorResponse.of(
                        HttpStatus.BAD_GATEWAY.value(),
                        "Bad Gateway",
                        "Falha na comunicação com o serviço de IA.",
                        List.of()
                ));
    }

    @ExceptionHandler(ValidationResponseParser.ValidationResponseParseException.class)
    public ResponseEntity<ErrorResponse> handleParseException(
            ValidationResponseParser.ValidationResponseParseException ex) {
        log.error("Resposta da IA fora do formato esperado: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(ErrorResponse.of(
                        HttpStatus.BAD_GATEWAY.value(),
                        "Bad Gateway",
                        "Resposta da IA fora do formato esperado.",
                        List.of(ex.getMessage())
                ));
    }

    @ExceptionHandler(PromptBuilder.PromptBuilderException.class)
    public ResponseEntity<ErrorResponse> handlePromptBuilder(PromptBuilder.PromptBuilderException ex) {
        log.error("Erro ao montar prompt: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Internal Server Error",
                        "Erro interno ao preparar análise.",
                        List.of()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        log.error("Erro inesperado: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Internal Server Error",
                        "Erro interno inesperado.",
                        List.of()
                ));
    }
}
