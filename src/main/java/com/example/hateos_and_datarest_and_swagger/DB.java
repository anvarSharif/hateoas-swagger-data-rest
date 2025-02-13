package com.example.hateos_and_datarest_and_swagger;

import com.example.hateos_and_datarest_and_swagger.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface DB {
    List<Product> PRODUCTS=new ArrayList<>(List.of(
            new Product(1,100,"Olma"),
            new Product(2,200,"Anor"),
            new Product(3,300,"Nok")
    ));
}
