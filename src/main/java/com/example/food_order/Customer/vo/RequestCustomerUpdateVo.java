package com.example.food_order.Customer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestCustomerUpdateVo {

    @Schema(
            description = "customer id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int customer_id;

    @Schema(
            description = "customer phone number",
            example = "88634858",
            type = "string",
            maxLength = 11,
            nullable = false
    )
    @NotBlank
    @Size(min = 8, max = 11)
    private String phone;

    @Schema(
            description = "customer address",
            example = "seoul konkuk-de",
            type = "string",
            maxLength = 100,
            nullable = false
    )
    @NotBlank
    @Size(min = 10, max = 100)
    private String address;

    @Schema(
            description = "customer message",
            example = "pleas add cheese",
            type = "string",
            maxLength = 255,
            nullable = false
    )
    @NotBlank
    @Size(max = 255)
    private String message;
}
