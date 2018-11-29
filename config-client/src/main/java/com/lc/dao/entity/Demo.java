package com.lc.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 *
 * @JsonIgnoreProperties(value = "{password}")这样可以忽略一些字段显示给前端
 * Created by lenovo on 2018/11/29.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demo {

    private int id;

    private String name;

    private Date date;

    public Demo(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
