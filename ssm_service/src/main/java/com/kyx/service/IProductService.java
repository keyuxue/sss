package com.kyx.service;

import com.kyx.pojo.IProduct;

import java.util.List;

public interface IProductService {
    public List<IProduct> findAll();

    public void save(IProduct product);
}
