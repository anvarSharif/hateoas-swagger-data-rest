package com.example.hateos_and_datarest_and_swagger.component;

import com.example.hateos_and_datarest_and_swagger.controller.ProductController;
import com.example.hateos_and_datarest_and_swagger.entity.Product;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {
    @Override
    public EntityModel<Product> toModel(Product product) {
        Link link1 = linkTo(ProductController.class).withRel("get all products");
        Link link2 = linkTo(methodOn(ProductController.class).getOneProducts(product.getId())).withRel("get one product");
        //bu ikkinchi usuli  Link link2 = linkTo(ProductController.class).slash("/"+product.getId()) .withRel("get one product");
        return EntityModel.of(product,link1,link2);
    }
    public CollectionModel<EntityModel<Product>> toCollectionModels(List<Product> products){
        List<EntityModel<Product>> list = products.stream().map(this::toModel).toList();
        return CollectionModel.of(list);
    }

}
