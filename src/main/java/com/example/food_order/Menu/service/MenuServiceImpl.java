package com.example.food_order.Menu.service;

import com.example.food_order.Menu.dao.MenuDao;
import com.example.food_order.Menu.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService{

    private MenuDao dao;

    @Override
    public void insertFood(RequestMenuVo vo) throws Exception {

        MenuVo menuVo = MenuVo.builder()
                .foodname(vo.getFoodname())
                .foodprice(vo.getFoodprice())
                .build();

        dao.insertFood(menuVo);
    }

    @Override
    public List<MenuVo> viewFoodMenu(RequestMenuListVo vo) throws Exception{
        return dao.viewFoodMenu(vo);
    }

    @Override
    public void updateFoodMenu(RequestMenuUpdateVo vo) throws Exception{

        MenuVo menuVo = MenuVo.builder()
                .food_id(vo.getFood_id())
                .foodname(vo.getFoodname())
                .foodprice(vo.getFoodprice())
                .build();

        dao.updateFoodMenu(menuVo);
    }

    @Override
    public boolean checkExistId(int id) throws Exception{
        return dao.checkExistId(id);
    }

    @Override
    public void deleteFoodMenu(RequestMenuIdVo vo) throws Exception{
        dao.deleteFoodMenu(vo.getFood_id());
    }

    @Override
    public int countFoodMenu(RequestMenuListVo vo) throws Exception{
        return dao.countFoodMenu(vo);
    }
}
