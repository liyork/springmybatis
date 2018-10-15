package com.wolf.entities;

import java.util.Date;

/**
 * Description:与数据库对应的bean
 * <br/> Created on 28/08/2018 8:58 AM
 *
 * @author 李超
 * @since 1.0.0
 */
public class Book extends BaseModel {
    /**
     * 书名
     */
    private String name;
    /**
     * 价格
     */
    private double price;
    /**
     * 出版日期
     */
    private Date publishDate;

    public Book(String name, double price, Date publishDate) {
        this.name = name;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}