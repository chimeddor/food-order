package com.example.food_order.Customer.dao;

import com.example.food_order.Customer.vo.CustomerVo;
import com.example.food_order.Customer.vo.RequestCustomerIdVo;
import com.example.food_order.Customer.vo.RequestCustomerListVo;
import com.example.food_order.Customer.vo.RequestCustomerVo;
import com.example.food_order.Menu.vo.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerDao {
    void insertCustomer(CustomerVo vo) throws Exception;
    List<CustomerVo> viewCustomer(RequestCustomerListVo vo) throws Exception;
    void updateCustomer(CustomerVo vo) throws Exception;
    boolean checkExistId(int id) throws Exception;
    void deleteCustomer(RequestCustomerIdVo vo) throws Exception;
    int countCustomer(RequestCustomerListVo vo) throws Exception;
}
