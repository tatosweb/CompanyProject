/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recipe.model;

import java.util.UUID;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class Step {

    private String id;
    private String url;
    private String description;

    /**
     *
     * @param url
     * @param description
     */
    public Step(BasicDBObject dbObject) {
        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.url = dbObject.getString("url");
        this.description = dbObject.getString("description");
    }

    public String getId(){
        return id;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
