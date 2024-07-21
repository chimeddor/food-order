package com.example.food_order.Menu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestMenuIdVo {

    @Schema(
            description = "menu id",
            example = "1",
            type = "int",
            minLength = 1,
            nullable = false
    )
    @Min(1)
    private int food_id;

}
