package com.example.food_order.Order.service;

import com.example.food_order.Order.vo.*;

import java.util.List;

public interface OrderService {
    void createOrder(RequestOrderVo vo) throws Exception;
    List<OrderVo> veiwAllOrders(RequestOrderListVo vo) throws Exception;
    void deleteOrder(RequestOrderIdVo vo) throws Exception;
    void updateOrders(RequestUpdateOrderVo vo) throws Exception;
    boolean checkExistId(int id) throws Exception;
    int countOrders(RequestOrderListVo vo) throws Exception;

}
