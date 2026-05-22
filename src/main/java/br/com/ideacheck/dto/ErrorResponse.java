package br.com.ideacheck.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    List<String> details
) {
    public static ErrorResponse of(int status, String error, String message, List<String> details) {
        return new ErrorResponse(LocalDateTime.now(), status, error, message, details);
    }
}
