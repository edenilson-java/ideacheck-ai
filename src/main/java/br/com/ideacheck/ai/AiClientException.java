package br.com.ideacheck.ai;

/**
 * Exceção lançada quando ocorre falha na comunicação com o cliente de IA.
 */
public class AiClientException extends RuntimeException {

    public AiClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public AiClientException(String message) {
        super(message);
    }
}
