package com.example.food_order.Order.vo;

import com.example.food_order.Customer.vo.CustomerVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
public class OrderVo {

    @Schema(
            description = "order id",
            example = "1",
            type = "int",
            nullable = false
    )
    private int orderid;

    @Schema(
            description = "customer id",
            example = "1",
            type = "int",
            nullable = false
    )
    private int customerid;

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

    @Schema(
            description = "food id",
            example = "1",
            type = "int",
            nullable = false
    )
    private int foodid;

    @Schema(
            description = "food name",
            example = "chicken",
            type = "string",
            maxLength = 40,
            nullable = false
    )
    private String foodname;

    @Schema(
            description = "food price",
            example = "12000",
            type = "int",
            nullable = false
    )
    private int foodprice;

    @Schema(
            description = "delivery option",
            example = "true",
            type = "boolean",
            nullable = true
    )
    private boolean delivery;

    @Schema(
            description = "order date",
            example = "2024-07-15 10:56:59.365373",
            type = "local date",
            nullable = false)

    private Date order_dte;

    @Schema(
            description = "del status ",
            example = "false",
            type = "boolean",
            nullable = false
    )
    private boolean succDel;

    @Schema(
            description = "order number",
            example = "1",
            type = "int",
            nullable = true
    )
    private int orderNm;

}
