package com.example.food_order.Menu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
//insert 기준으로 사용.
public class RequestMenuVo {

    @Schema(
            description = "food name",
            example = "chicken",
            type = "string",
            maxLength = 40,
            nullable = false
    )
    @NotBlank
    @Size(min= 5, max = 40)
    private String foodname;

    @Schema(
            description = "food price",
            example = "12000",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int foodprice;
}
