package com.example.food_order.Menu.controller;

import com.example.food_order.Menu.service.MenuService;
import com.example.food_order.Menu.vo.*;
import com.example.food_order.Response.SuccResponse;
import com.example.food_order.Response.ErrResponse;
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
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@Tag(name = "Menu")
@Controller
//@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping(value = "/menu", method = RequestMethod.POST)
public class MenuController {

    @Autowired
    private final MenuService service;

    @Operation(summary = "추가", description = "메뉴 추가",
            responses = {
                        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                        @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
    })

    @RequestMapping("/insertFood")
    public @ResponseBody SuccResponse<?> insertFood(@Valid @RequestBody RequestMenuVo vo) throws Exception{

        service.insertFood(vo);
        return SuccResponse.builder()
                .status(HttpStatus.OK.value())
                .message("OK").build();
    }

    @Operation(summary = "조회", description = "메뉴 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrResponse.NotFound.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
    })

    @RequestMapping("/viewFoodMenu")
    public @ResponseBody SuccResponse<List<MenuVo>> viewFoodMenu(@Valid @RequestBody RequestMenuListVo vo) throws Exception{

        int count = service.countFoodMenu(vo);
        if(count == 0){
            throw new NotFoundException("Not Found");
        }

        List<MenuVo> foodmnu = service.viewFoodMenu(vo);
        return SuccResponse
                .<List<MenuVo>>builder()
                .status(HttpServletResponse.SC_OK)
                .message("OK")
                .data(foodmnu)
                .build();
    }

    @Operation(summary = "변경", description = "메뉴 변경",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = SuccResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input value", content = @Content(schema = @Schema(implementation = ErrResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrResponse.NotFound.class))),
                    @ApiResponse(responseCode = "500", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrResponse.BadRequest.class)))
            })

    @RequestMapping("/updateFoodMenu")
    public @ResponseBody SuccResponse<?> updateFoodMenu(@Valid @RequestBody RequestMenuUpdateVo vo) throws Exception{

        boolean exist = service.checkExistId(vo.getFood_id());

        if(!exist){
            throw new NotFoundException("Not Found");
        }

        service.updateFoodMenu(vo);

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

    @RequestMapping("/deleteFoodMenu")
    public @ResponseBody SuccResponse<?> deleteFoodMenu(@Valid @RequestBody RequestMenuIdVo vo) throws Exception{

        boolean exist = service.checkExistId(vo.getFood_id());

        if (!exist){
            throw new NotFoundException("Not Found");
        }

        service.deleteFoodMenu(vo);

        return SuccResponse
                .builder()
                .message("OK")
                .status(HttpServletResponse.SC_OK)
                .build();
    }
}
