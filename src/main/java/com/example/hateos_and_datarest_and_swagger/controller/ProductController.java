package com.example.hateos_and_datarest_and_swagger.controller;

import com.example.hateos_and_datarest_and_swagger.DB;
import com.example.hateos_and_datarest_and_swagger.component.ProductModelAssembler;
import com.example.hateos_and_datarest_and_swagger.entity.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductModelAssembler productModel;

    public ProductController(ProductModelAssembler productModel) {
        this.productModel = productModel;
    }


    @GetMapping
    public HttpEntity<?> getProducts(){
        List<Product> products = DB.PRODUCTS;
        return ResponseEntity.ok(productModel.toCollectionModels(products));
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOneProducts(@PathVariable Integer id){
        Product product=DB.PRODUCTS.stream().filter(item->item.getId().equals(id)).findFirst().orElseThrow();
       return ResponseEntity.ok(productModel.toModel(product));
    }

}
