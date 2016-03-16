package com.emedinaa.samples.realm.model;

import java.io.Serializable;

/**
 * Created by em on 16/03/16.
 */
public class ProductEntity implements Serializable {

    private String id;
    private String name;
    private float price;
    private String url;
    private int type;

    public ProductEntity(String id, String name, float price, String url, int type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.type = type;
    }

    public ProductEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", type=" + type +
                '}';
    }
}
