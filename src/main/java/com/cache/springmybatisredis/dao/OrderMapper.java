package com.cache.springmybatisredis.dao;

import com.cache.springmybatisredis.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    public int add(Order order);

    public Order getById(long id);

    public int update(Order order);

    public List<Order> getAll();

    public int delete(@Param("id") long id, @Param("name") String name);
}
