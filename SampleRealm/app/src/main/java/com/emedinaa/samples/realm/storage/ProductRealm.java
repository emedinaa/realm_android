package com.emedinaa.samples.realm.storage;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by em on 16/03/16.
 */
public class ProductRealm extends RealmObject {


    @PrimaryKey
    private String id;
    private String name;
    private float price;
    private String url;
    private int type;

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
}
