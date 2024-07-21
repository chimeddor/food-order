package com.example.food_order.Order.controller;
import com.example.food_order.Order.service.OrderService;
import com.example.food_order.Order.service.OrderServiceImpl;
import com.example.food_order.Order.vo.*;
import com.example.food_order.Response.ErrResponse;
import com.example.food_order.Response.SuccResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webjars.NotFoundException;

import java.util.List;

@Tag(name = "Order")
@Controller
@RequestMapping(value = "/order", method = RequestMethod.POST)
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @Operation(summary = "추가", description = "주문 추가",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })
    @RequestMapping("/createOrder")
    public @ResponseBody SuccResponse<?> createOrder(@Valid @RequestBody RequestOrderVo vo) throws Exception{

        service.createOrder(vo);
        return SuccResponse
                .builder()
                .status(HttpStatus.OK.value())
                .message("OK")
                .build();

    }

    @Operation(summary = "조회", description = "주문 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })
    @RequestMapping("/viewAllOrders")
    public @ResponseBody SuccResponse<List<OrderVo>> viewAllOrders(@Valid @RequestBody RequestOrderListVo vo) throws Exception{

        int count = service.countOrders(vo);

        if (count == 0){
            throw new NotFoundException("Not Found");
        }

        List<OrderVo> result = service.veiwAllOrders(vo);
        return SuccResponse
                .<List<OrderVo>>builder()
                .status(HttpStatus.OK.value())
                .message("OK")
                .data(result)
                .build();
    }

    @Operation(summary = "삭제", description = "주문 삭제",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })
    @RequestMapping("/deleteOrders")
    public @ResponseBody SuccResponse<?> deleteOrders(@Valid @RequestBody RequestOrderIdVo vo) throws Exception{
        boolean exist = service.checkExistId(vo.getOrderid());

        if (!exist){
            throw new NotFoundException("Not Found");
        }

        service.deleteOrder(vo);

        return SuccResponse
                .<List<OrderVo>>builder()
                .status(HttpStatus.OK.value())
                .message("OK")
                .build();
    }

    @Operation(summary = "번경", description = "주문 번경",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })
    @RequestMapping("/updateOrders")
    public @ResponseBody SuccResponse<?> updateOrders(@Valid @RequestBody RequestUpdateOrderVo vo) throws Exception{

        boolean exist = service.checkExistId(vo.getFoodid());

        if (!exist){
            throw new NotFoundException("Not Found");
        }

        service.updateOrders(vo);

        return SuccResponse
                .<List<OrderVo>>builder()
                .status(HttpStatus.OK.value())
                .message("OK")
                .build();
    }


}
