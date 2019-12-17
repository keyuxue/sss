package com.kyx.service;

import com.kyx.pojo.IProduct;
import com.kyx.pojo.Orders;

import java.util.List;

public interface IOrdersService {
    public List<Orders> findAll(int page,int size);

    Orders findById(String ordersId);
}
