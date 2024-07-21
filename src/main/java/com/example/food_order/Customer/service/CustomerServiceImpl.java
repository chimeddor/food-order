package com.example.food_order.Customer.service;

import com.example.food_order.Customer.dao.CustomerDao;
import com.example.food_order.Customer.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao dao;


    @Override
    public void insertCustomer(RequestCustomerVo vo) throws Exception {

        CustomerVo customerVo = CustomerVo
                .builder()
                .phone(vo.getPhone())
                .address(vo.getAddress())
                .message(vo.getMessage())
                .build();

        dao.insertCustomer(customerVo);
    }

    @Override
    public List<CustomerVo> viewCustomer(RequestCustomerListVo vo) throws Exception {
        return dao.viewCustomer(vo);
    }

    @Override
    public void updateCustomer(RequestCustomerUpdateVo vo) throws Exception {

        CustomerVo customerVo = CustomerVo
                .builder()
                .customer_id(vo.getCustomer_id())
                .phone(vo.getPhone())
                .address(vo.getAddress())
                .message(vo.getMessage())
                .build();

        dao.updateCustomer(customerVo);
    }

    @Override
    public boolean checkExistId(int id) throws Exception {
        return dao.checkExistId(id);
    }

    @Override
    public void deleteCustomer(RequestCustomerIdVo vo) throws Exception {
        dao.deleteCustomer(vo);
    }

    @Override
    public int countCustomer(RequestCustomerListVo vo) throws Exception {
        return dao.countCustomer(vo);
    }
}
