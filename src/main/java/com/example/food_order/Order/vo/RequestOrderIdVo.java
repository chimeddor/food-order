package com.example.food_order.Order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RequestOrderIdVo {

    @Schema(
            description = "order id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int orderid;


}
