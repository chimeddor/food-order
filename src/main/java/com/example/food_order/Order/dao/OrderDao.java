package com.example.food_order.Order.dao;

import com.example.food_order.Order.vo.OrderVo;
import com.example.food_order.Order.vo.RequestOrderIdVo;
import com.example.food_order.Order.vo.RequestOrderListVo;
import com.example.food_order.Order.vo.RequestUpdateOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDao {

    void createOrder(OrderVo vo) throws Exception;
    List<OrderVo> veiwAllOrders(RequestOrderListVo vo) throws Exception;
    void deleteOrder(RequestOrderIdVo vo) throws Exception;
    void updateOrders(OrderVo vo) throws Exception;
    boolean checkExistId(int id) throws Exception;
    int countOrders(RequestOrderListVo vo) throws Exception;


}
