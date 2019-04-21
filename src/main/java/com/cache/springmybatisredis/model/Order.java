package com.cache.springmybatisredis.model;

import java.io.Serializable;

public class Order implements Serializable{

    private static final long serialVersionUID = 1L;

    private long id = 0L;
    private String name = null;
    private long createTime = 0L;

    public Order() {
    }

    public Order(long id, String name, long createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
