package com.example.food_order.Order.service;

import com.example.food_order.Order.dao.OrderDao;
import com.example.food_order.Order.vo.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{

    private OrderDao dao;

    @Override
    public void createOrder(RequestOrderVo vo) throws Exception {

        OrderVo orderVo = OrderVo
                .builder()
                .customerid(vo.getCustomerid())
                .foodid(vo.getFoodid())
                .build();

        dao.createOrder(orderVo);
    }

    @Override
    public List<OrderVo> veiwAllOrders(RequestOrderListVo vo) throws Exception {
        return dao.veiwAllOrders(vo);
    }

    @Override
    public void deleteOrder(RequestOrderIdVo vo) throws Exception {
        dao.deleteOrder(vo);
    }

    @Override
    public void updateOrders(RequestUpdateOrderVo vo) throws Exception {

        OrderVo orderVo = OrderVo
                .builder()
                .orderid(vo.getOrderid())
                .foodid(vo.getFoodid())
                .succDel(vo.isSuccDel())
                .build();

        dao.updateOrders(orderVo);

    }

    @Override
    public boolean checkExistId(int id) throws Exception {
        return dao.checkExistId(id);
    }

    @Override
    public int countOrders(RequestOrderListVo vo) throws Exception {
        return dao.countOrders(vo);
    }


}
