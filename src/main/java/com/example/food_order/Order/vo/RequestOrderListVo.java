package com.example.food_order.Order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
public class RequestOrderListVo {

    @Schema(
            description = "order num",
            example = "1",
            type = "int",
            nullable = true
    )
    private int order_num;

    @Schema(
            description = "del status",
            example = "true",
            type = "boolean",
            nullable = true
    )
    private boolean succDel;
}
