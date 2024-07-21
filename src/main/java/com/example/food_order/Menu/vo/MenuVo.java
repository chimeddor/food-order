package com.example.food_order.Menu.vo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuVo {

    @Schema(
            description = "menu id",
            example = "1",
            type = "int",
            minLength = 1,
            nullable = false
    )
    private int food_id;

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

}
