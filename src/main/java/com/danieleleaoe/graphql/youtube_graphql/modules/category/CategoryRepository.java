package com.danieleleaoe.graphql.youtube_graphql.modules.category;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, UUID> {

}
