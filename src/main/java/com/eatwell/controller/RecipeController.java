package com.eatwell.controller;

import com.eatwell.model.Recipe;
import com.eatwell.repository.RecipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Creates a Rest Controller for serving the recipe resources
 */
@RestController
@RequestMapping("api")
public class RecipeController {

	@Autowired
    RecipeRepository recipeRepository;

	@RequestMapping(method = RequestMethod.GET, value = "recipes")
    public List<Recipe> list() {
	    return recipeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "recipes/{id}")
    public Recipe get(@PathVariable Long id) {
        return recipeRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "recipes")
    public Recipe create(@RequestBody Recipe recipe) {
	    return recipeRepository.saveAndFlush(recipe);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "recipes/{id}")
    public Recipe delete(@PathVariable Long id){
	    //Get the existing recipe from db if required to be returned
        //no needed if returning void
        Recipe existingRecipe = recipeRepository.getOne(id);

        //delete the recipe
        recipeRepository.delete(id);

        return existingRecipe;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "recipes/{id}")
    public Recipe update(@PathVariable Long id, @RequestBody Recipe recipe){
        //Get the existing recipe from db
        Recipe existingRecipe = recipeRepository.getOne(id);

        //copy data from input recipe to existing recipe in db
        BeanUtils.copyProperties(recipe, existingRecipe);

        return recipeRepository.saveAndFlush(existingRecipe);
    }
}
