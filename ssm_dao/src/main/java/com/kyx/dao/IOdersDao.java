package com.kyx.dao;

import com.kyx.pojo.IProduct;
import com.kyx.pojo.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Repository
public interface IOdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            /*这句为空  debug查不到数据*/
            @Result(property = "product", column = "productId", javaType = IProduct.class, one = @One(select = "com.kyx.dao.IProductDao.findById")),
            @Result(property = "member",column ="memberId" ,javaType = Member.class,one = @One(select = "com.kyx.dao.IMemberDao.findById"))
    })
    public List<Orders> findAll();

    public Orders findById(String ordersId);
}
