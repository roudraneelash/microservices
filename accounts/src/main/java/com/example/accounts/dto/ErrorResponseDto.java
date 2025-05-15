package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema for error response details"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(description = "API path where the error occurred", example = "/api/v1/accounts")
    private String apiPath;

    @Schema(description = "HTTP status code of the error", example = "BAD_REQUEST")
    private HttpStatus errorCode;

    @Schema(description = "Detailed error message", example = "Invalid account number")
    private String errorMessage;

    @Schema(description = "Timestamp when the error occurred", example = "2024-06-01T12:34:56")
    private LocalDateTime errorTime;
}
