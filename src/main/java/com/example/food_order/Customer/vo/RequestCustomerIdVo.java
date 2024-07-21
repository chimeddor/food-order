package com.example.food_order.Customer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RequestCustomerIdVo {

    @Schema(
            description = "customer id",
            example = "1",
            type = "int",
            nullable = false
    )
    @Min(1)
    private int customer_id;
}
