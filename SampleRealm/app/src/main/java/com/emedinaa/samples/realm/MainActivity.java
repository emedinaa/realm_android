package com.emedinaa.samples.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.emedinaa.samples.realm.model.ProductEntity;
import com.emedinaa.samples.realm.storage.ProductCRUD;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MainActivity" ;
    ProductCRUD productCRUD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productCRUD= new ProductCRUD(this);
        populate();
    }

    private void populate() {
        List<ProductEntity> products= productCRUD.all();
        if(products.size()==0)products=mockProducts();
        productCRUD.saveList(products);

        products= productCRUD.all();
        Log.v(TAG,"products "+products );
    }

    private List<ProductEntity> mockProducts()
    {
        List<ProductEntity> products= new ArrayList<>();
        products.add(new ProductEntity("100","Lapiceros A1",0.80f,"https://google.com.pe",2));
        products.add(new ProductEntity("101","Cuarderno",0.80f,"https://google.com.pe",1));
        products.add(new ProductEntity("102","Cartulina",0.80f,"https://google.com.pe",2));
        products.add(new ProductEntity("103","Pintura Acrílica",0.80f,"https://google.com.pe",3));
        products.add(new ProductEntity("104","Témperas",0.80f,"https://google.com.pe",3));
        products.add(new ProductEntity("105","Colores",0.80f,"https://google.com.pe",2));
        return  products;
    }
}
