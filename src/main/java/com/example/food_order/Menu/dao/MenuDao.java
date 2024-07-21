package com.example.food_order.Menu.dao;

import com.example.food_order.Menu.vo.MenuVo;
import com.example.food_order.Menu.vo.RequestMenuIdVo;
import com.example.food_order.Menu.vo.RequestMenuListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuDao {

    void insertFood(MenuVo vo) throws Exception;
    List<MenuVo> viewFoodMenu(RequestMenuListVo vo) throws Exception;
    void updateFoodMenu(MenuVo vo) throws Exception;
    boolean checkExistId(int id) throws Exception;
    void deleteFoodMenu(int id) throws Exception;
    int countFoodMenu(RequestMenuListVo vo) throws Exception;
}
