package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 * AccountsDto is a Data Transfer Object (DTO) that represents the account details of a customer.
 * It contains fields for account number, account type, and branch address.
 * The class includes validation annotations to ensure that the data provided is valid.
 */
@Schema(
        name = "Accounts",
        description = "Schema for account details")
@Data
public class AccountsDto {

    @Schema(description = "Account number of the customer", example = "1234567890")
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be 10 digits")
    private Long accountNumber;

    @Schema(description = "Account type of the customer", example = "Savings/Current/Fixed Deposit")
    @NotEmpty(message = "Account type cannot be empty")
    private String accountType;

    @Schema(description = "Branch address of the bank",example = "124 Main St, Cityville")
    @NotEmpty(message = "Branch address cannot be empty")
    private String branchAddress;

}
