/**
 *
 */
package com.recipe.model;

import java.util.List;
import java.util.UUID;

/**
 * @author rezmos
 *
 */
public class Recipe {

    private String RecipeId;
    private String name;
    private String description;
    private String score;
    private List<Step> steps;

    public Recipe(String name, String description, String score, List<Step> steps) {
        this.setRecipeId();
        this.setName(name);
        this.setDescription(description);
        this.setScore(score);
        this.setSteps(steps);
    }

    public String getRecipeId() {
        return RecipeId;
    }

    public void setRecipeId() {
        if (RecipeId == null || RecipeId.isEmpty()) {
            this.RecipeId = UUID.randomUUID().toString();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        if (score != null && !score.isEmpty()) {
            this.score = score;
        }
    }

    public void setSteps(List<Step> steps) {
        if (steps != null && !steps.isEmpty()) {
            this.steps = steps;
        } else {
            throw new IllegalArgumentException("The Steps are Mandatory");
        }
    }
    
    public List<Step> getSteps(){
        return steps;
    }

    public void isValid() throws IllegalArgumentException {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The Name are Mandatory");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("The Addredd are Mandatory");
        }
        if (score == null || score.isEmpty()) {
            throw new IllegalArgumentException("The score are Mandatory");
        }
//        if (steps == null || steps.isEmpty()) {
//            throw new IllegalArgumentException("The steps are Mandatory");
//        }
    }
}
