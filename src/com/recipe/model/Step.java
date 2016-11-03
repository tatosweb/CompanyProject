/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recipe.model;

import java.util.UUID;

/**
 *
 * @author
 */
public class Step {

    private String stepId;
    private String url;
    private String description;

    /**
     *
     * @param url
     * @param description
     */
    public Step(String url, String description) {
        this.setStepId();
        this.setUrl(url);
        this.setDescription(description);
    }

    public void setStepId() {
        if (stepId == null || stepId.isEmpty()) {
            this.stepId = UUID.randomUUID().toString();
        }
    }
    public String getStepId(){
        return stepId;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        if (url != null && !url.isEmpty()) {
            this.url = url;
        }
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

}
