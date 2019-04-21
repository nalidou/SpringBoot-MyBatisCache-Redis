package com.cache.springmybatisredis.controller;

import com.alibaba.fastjson.JSONObject;
import com.cache.springmybatisredis.dao.OrderMapper;
import com.cache.springmybatisredis.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    public OrderController() {
        System.out.println("OrderController init...");
    }

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ValueOperations valueOperations;

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/")
    public JSONObject index () {
        JSONObject result = new JSONObject();
        result.put("msg", "aaa");
        return result;
    }

    @RequestMapping("add")
    public JSONObject add(Order order){
        JSONObject result = new JSONObject();

        order.setCreateTime(System.currentTimeMillis());
        orderMapper.add(order);
        result.put("order", order);
        return result;
    }

    @RequestMapping("set")
    public JSONObject set(String k, String v){

        System.out.println(k);
        JSONObject result = new JSONObject();
        valueOperations.set(k, v);
        result.put("status", 0);
        return result;
    }

    @RequestMapping("get")
    public JSONObject get(String id){
        long startTime = System.currentTimeMillis();
        JSONObject result = new JSONObject();
        for (int i=0;i<10;i++) {
            orderMapper.getById(Long.parseLong(id));
        }
        Order order = orderMapper.getById(Long.parseLong(id));
        result.put(id, order);

        long endTime = System.currentTimeMillis();

        System.out.println("查询耗时："+(endTime - startTime));
        return result;
    }

    @RequestMapping("update")
    public JSONObject update (Order order) {
        JSONObject result = new JSONObject();
        order.setCreateTime(System.currentTimeMillis());
        orderMapper.update(order);
        result.put("aa","aa");
        return result;
    }

    @RequestMapping("delete")
    public JSONObject delete(long id){
        JSONObject result = new JSONObject();
        int n = orderMapper.delete(id, null);
        System.out.println("delete: " + n);
        result.put("del", n);
        return result;
    }

}
