package com.kyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.kyx.dao.IOdersDao;
import com.kyx.pojo.Orders;
import com.kyx.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOdersServiceImpl implements IOrdersService {
    @Autowired
    private IOdersDao iOdersDao;
    @Override
    public List<Orders> findAll(int page,int size) {
     /*   List<Orders> list = iOdersDao.findAll();*/
        /*pagenum是页码值   pagesize是每页条数*/
        /*在正在执行sql前  使用PageHelper来完成分页*/
        PageHelper.startPage(page,size);
        return iOdersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) {
        return iOdersDao.findById(ordersId);
    }
}
