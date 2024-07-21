package com.example.food_order.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrResponse {
    @Schema(
            example = "400"
    )
    private int status;
    @Schema(example = "Invalid input value")
    private String message;
    private List<FieldError> fieldErrors;


    @Getter
    @AllArgsConstructor
    public static class FieldError{


        @Schema(example = "food name")
        private String field;

        @Schema(example = "a")
        private String val;

    }

    public static class NotFound extends ErrorDefaultBuild{
        @Schema(example = "404")
        @Override
        public int getStatus() {
            return super.getStatus();
        }

        @Schema(example = "Not Found")
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }

    public static class BadRequest extends ErrorDefaultBuild{

        @Schema(example = "500")
        @Override
        public int getStatus() {
            return super.getStatus();
        }

        @Schema(example = "Bad Request")
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }
}
