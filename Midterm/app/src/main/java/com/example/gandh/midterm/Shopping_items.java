package com.example.gandh.midterm;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by gandh on 3/20/2017.
 */

public class Shopping_items implements Serializable{

    String name,  url, saleprice, msrpprice, discount;
Long id;
String uniquer;

    public String getUniquer() {
        return uniquer;
    }

    public void setUniquer(String uniquer) {
        this.uniquer = uniquer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shopping_items{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", saleprice='" + saleprice + '\'' +
                ", msrpprice='" + msrpprice + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getMsrpprice() {
        return msrpprice;
    }

    public void setMsrpprice(String msrpprice) {
        this.msrpprice = msrpprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
