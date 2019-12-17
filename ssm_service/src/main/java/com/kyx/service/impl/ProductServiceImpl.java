package com.kyx.service.impl;

import com.kyx.dao.IProductDao;
import com.kyx.pojo.IProduct;
import com.kyx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<IProduct> findAll() {
        System.out.println("service层");
        return productDao.findAll();
    }

    @Override
    public void save(IProduct product) {
     productDao.save(product);
    }
}
