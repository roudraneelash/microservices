package com.example.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDto {
    @Schema(
            description = "Status code in the response"
    )
    private String StatusCode;
    @Schema(
            description = "Status message in the response"
    )
    private String StatusMessage;
}
