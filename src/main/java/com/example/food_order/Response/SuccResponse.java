package com.example.food_order.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class SuccResponse<T> {
    @Schema(
            example = "200"
    )
    private int status;

    @Schema(
            example = "OK"
    )
    private String message;

    private T data;

}
