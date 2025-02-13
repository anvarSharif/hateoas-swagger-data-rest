package com.example.hateos_and_datarest_and_swagger.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class Product {
    private Integer id;
    private Integer price;
    private String name;



}
