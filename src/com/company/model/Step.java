/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

/**
 *
 * @author 
 */
public class Step {
    
    private String url;
    private String description;

    /**
     * 
     * @param url
     * @param description 
     */
    public Step(String url, String description) {
        this.setUrl( url);
        this.setDescription(description);
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
