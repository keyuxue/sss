package com.kyx.dao;

import com.kyx.pojo.IProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IProductDao {
    @Select("select * from orders where id= #{id}")
    public IProduct findById(String id);

    @Select("select * from product")
    public List<IProduct> findAll();

    @Insert("insert into  product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(IProduct product);
}
