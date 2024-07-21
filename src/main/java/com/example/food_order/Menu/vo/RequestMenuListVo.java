package com.example.food_order.Menu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

//select 기준으로 사용. /모즌 데이터를 조회/
@Data
public class RequestMenuListVo {

    @Schema(
            description = "food name",
            example = "chicken",
            type = "string",
            maxLength = 40,
            nullable = true
    )
    @Size(min = 5, max = 40)
    private String foodname;
}
