package com.danieleleaoe.graphql.youtube_graphql.modules.product;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @MutationMapping()
  ProductEntity addProduct(@Argument ProductInput productInput) {
    var product = this.productRepository
        .save(new ProductEntity(productInput.name, productInput.price, productInput.categoryId));
    return product;
  }

  @QueryMapping()
  Iterable<ProductEntity> products() {
    var products = this.productRepository.findAll();
    return products;
  }

  record ProductInput(String name, BigDecimal price, UUID categoryId) {
  }
}
