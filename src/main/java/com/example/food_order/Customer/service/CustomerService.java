package com.example.food_order.Customer.service;

import com.example.food_order.Customer.vo.*;
import com.example.food_order.Menu.vo.*;

import java.util.List;

public interface CustomerService {
    void insertCustomer(RequestCustomerVo vo) throws Exception;
    List<CustomerVo> viewCustomer(RequestCustomerListVo vo) throws Exception;
    void updateCustomer(RequestCustomerUpdateVo vo) throws Exception;
    boolean checkExistId(int id) throws Exception;
    void deleteCustomer(RequestCustomerIdVo vo) throws Exception;
    int countCustomer(RequestCustomerListVo vo) throws Exception;
}
