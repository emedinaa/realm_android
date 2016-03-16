package com.emedinaa.samples.realm.storage;

import android.content.Context;

import com.emedinaa.samples.realm.model.ProductEntity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by em on 16/03/16.
 */
public class ProductCRUD {

    private Realm realm;
    private Context context;


    public ProductCRUD(Context context) {
        this.context= context;
        this.realm = Realm.getInstance(this.context);
    }

    public void add(ProductEntity productEntity)
    {
        realm.beginTransaction();

        // Add a type
        ProductRealm productRealm = realm.createObject(ProductRealm.class);
        productRealm.setId(productEntity.getId());
        productRealm.setName(productEntity.getName());
        productRealm.setPrice(productEntity.getPrice());
        productRealm.setUrl(productEntity.getUrl());
        productRealm.setType(productEntity.getType());

        realm.commitTransaction();
    }

    public List<ProductEntity> all()
    {
        List<ProductRealm> data=realm.where(ProductRealm.class).findAll();
        List<ProductEntity> productEntities = new ArrayList<>();
        ProductEntity productEntity;
        for (ProductRealm productRealm :data) {
            productEntity= new ProductEntity();
            productEntity.setId(productRealm.getId());
            productEntity.setName(productRealm.getName());
            productEntity.setPrice(productRealm.getPrice());
            productEntity.setUrl(productRealm.getUrl());
            productEntity.setType(productRealm.getType());
            productEntities.add(productEntity);
        }
        return productEntities;
    }

    public List<ProductEntity> getProductsByType(int type)
    {
        RealmResults<ProductRealm> typeEntities = realm.where(ProductRealm.class).equalTo("type", type).findAll();
        List<ProductEntity> productEntities= new ArrayList<>();

        for (ProductRealm productRealm:typeEntities) {
            ProductEntity productEntity= new ProductEntity();
            productEntity.setId(productRealm.getId());
            productEntity.setName(productRealm.getName());
            productEntity.setType(productRealm.getType());
            productEntity.setPrice(productRealm.getPrice());
            productEntity.setUrl(productRealm.getUrl());
            productEntities.add(productEntity);
        }

        return productEntities;
    }

    public void saveList(List<ProductEntity> productEntityList)
    {
        realm.beginTransaction();
        ProductRealm productRealm;
        for (ProductEntity productEntity:productEntityList) {
            productRealm = new ProductRealm();
            productRealm.setId(productEntity.getId());
            productRealm.setName(productEntity.getName());
            productRealm.setType(productEntity.getType());
            productRealm.setPrice(productEntity.getPrice());
            productRealm.setUrl(productEntity.getUrl());
            realm.copyToRealmOrUpdate(productRealm);
        }
        realm.commitTransaction();
    }

    public void close()
    {
        realm.close();
    }
}
