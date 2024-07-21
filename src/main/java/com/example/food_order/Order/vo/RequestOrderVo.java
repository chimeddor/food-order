package com.example.food_order.Order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RequestOrderVo {

    @Schema(
            description = "customer id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int customerid;

    @Schema(
            description = "food id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int foodid;
}
