package com.example.food_order.Order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestUpdateOrderVo {

    @Schema(
            description = "order id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int orderid;


    @Schema(
            description = "food id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int foodid;

    @Schema(
            description = "del status ",
            example = "false",
            type = "boolean",
            nullable = false
    )

    @NotNull
    private boolean succDel;
}
