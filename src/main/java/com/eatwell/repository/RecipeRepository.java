package com.eatwell.repository;

import com.eatwell.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Creates a Spring JPA Repository for the recipes
 * Provides default implementation for basic methods - findOne, findAll, delete, saveAndFlush
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
