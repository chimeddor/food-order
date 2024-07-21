package com.example.food_order.Customer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerVo {

    @Schema(
            description = "customer id",
            example = "1",
            type = "int",
            nullable = false
    )
    private int customer_id;

    @Schema(
            description = "customer phone number",
            example = "88634858",
            type = "string",
            maxLength = 20,
            nullable = false
    )
    private String phone;

    @Schema(
            description = "customer address",
            example = "seoul konkuk-de",
            type = "string",
            maxLength = 100,
            nullable = false
    )
    private String address;

    @Schema(
            description = "customer message",
            example = "pleas add cheese",
            type = "string",
            maxLength = 255,
            nullable = true
    )
    private String message;

    private String foodname;

    private int foodprice;

    private int ordernum;
}
