package com.danieleleaoe.graphql.youtube_graphql.modules.product;

import java.math.BigDecimal;
import java.util.UUID;

import com.danieleleaoe.graphql.youtube_graphql.modules.category.CategoryEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  private BigDecimal price;

  @ManyToOne()
  @JoinColumn(name = "category_id", insertable = false, updatable = false)
  private CategoryEntity category;

  @Column(name = "category_id")
  private UUID categoryId;

  public ProductEntity(String name, BigDecimal price, UUID categoryId) {
    this.name = name;
    this.price = price;
    this.categoryId = categoryId;
  }
}
