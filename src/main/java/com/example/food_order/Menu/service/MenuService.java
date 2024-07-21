package com.example.food_order.Menu.service;

import com.example.food_order.Menu.vo.*;

import java.util.List;

public interface MenuService {
    void insertFood(RequestMenuVo vo) throws Exception;
    List<MenuVo> viewFoodMenu(RequestMenuListVo vo) throws Exception;
    void updateFoodMenu(RequestMenuUpdateVo vo) throws Exception;
    boolean checkExistId(int id) throws Exception;
    void deleteFoodMenu(RequestMenuIdVo vo) throws Exception;
    int countFoodMenu(RequestMenuListVo vo) throws Exception;
}
