package learn.spring.recipe.controller;

import learn.spring.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/{id}")
    public String getRecipes(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeRepository.findById(Long.valueOf(id)).orElseThrow());

        return "recipes/index";
    }
}
