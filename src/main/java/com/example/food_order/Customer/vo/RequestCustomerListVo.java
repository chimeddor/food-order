package com.example.food_order.Customer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestCustomerListVo {

    @Schema(
            description = "customer phone number",
            example = "88634858",
            type = "string",
            maxLength = 11,
            nullable = true
    )
    @Size(min = 8, max = 11)
    private String phone;

    @Schema(
            description = "customer address",
            example = "seoul konkuk-de",
            type = "string",
            maxLength = 100,
            nullable = true
    )
    @Size(min = 10, max = 100)
    private String address;
}
