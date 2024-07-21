package com.example.food_order.Customer.controller;

import com.example.food_order.Customer.service.CustomerService;
import com.example.food_order.Customer.vo.*;
import com.example.food_order.Response.ErrResponse;
import com.example.food_order.Response.SuccResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webjars.NotFoundException;

import java.util.List;

@Tag(name = "Customer")
@RequestMapping(value = "/customer", method = RequestMethod.POST)
//@RequiredArgsConstructor
@AllArgsConstructor
@Controller
public class CustomerController {

    @Autowired
    private final CustomerService service;

    @Operation(summary = "추가", description = "고객 추가",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })
    @RequestMapping("/insertCustomer")
    public @ResponseBody SuccResponse<?> insertCustomer(@Valid @RequestBody RequestCustomerVo vo) throws Exception{

        service.insertCustomer(vo);
        return SuccResponse.builder()
                .status(HttpStatus.OK.value())
                .message("OK").build();
    }

    @Operation(summary = "조회", description = "고객 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })
    @RequestMapping("/viewCustomer")
    public @ResponseBody SuccResponse<List<CustomerVo>> viewCustomer(@Valid @RequestBody RequestCustomerListVo vo) throws Exception{

        int count = service.countCustomer(vo);
        if(count == 0){
            throw new NotFoundException("Not Found");
        }

        List<CustomerVo> foodmnu = service.viewCustomer(vo);
        return SuccResponse
                .<List<CustomerVo>>builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .data(foodmnu)
                .build();
    }

    @Operation(summary = "변경", description = "고객 변경",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrResponse.NotFound.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })

    @RequestMapping("/updateCustomer")
    public @ResponseBody SuccResponse<?> updateCustomer(@Valid @RequestBody RequestCustomerUpdateVo vo) throws Exception{

        boolean exist = service.checkExistId(vo.getCustomer_id());

        if(!exist){
            throw new NotFoundException("Not Found");
        }

        service.updateCustomer(vo);

        return SuccResponse
                .builder()
                .message("OK")
                .status(HttpServletResponse.SC_OK)
                .build();
    }

    @Operation(summary = "삭제", description = "메뉴 삭제",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrResponse.NotFound.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })

    @RequestMapping("/deleteCustomer")
    public @ResponseBody SuccResponse<?> deleteCustomer(@Valid @RequestBody RequestCustomerIdVo vo) throws Exception{

        boolean exist = service.checkExistId(vo.getCustomer_id());

        if (!exist){
            throw new NotFoundException("Not Found");
        }

        service.deleteCustomer(vo);

        return SuccResponse
                .builder()
                .message("OK")
                .status(HttpServletResponse.SC_OK)
                .build();
    }
}
