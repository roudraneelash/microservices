package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema for response details"
)
public class ResponseDto {

//    @Schema(description = "Response code indicating the status of the operation", example = "200")
    private String statusCode;
//    @Schema(description = "Response message of the operation", example = "request processed successfully")
    private String statusMessage;
}
