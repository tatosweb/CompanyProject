package com.recipe.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.recipe.model.Step;
import com.mongodb.*;
import org.bson.types.ObjectId;
import com.google.gson.Gson;


/**
 * @author Jorge Ramirez
 *
 */
public class StepAPI {

    private final DB db;
    private final DBCollection collection;

    public StepAPI(DB db){
        this.db = db;
        this.collection = db.getCollection("steps");
    }

    /**
     * @return List<Step> a list with all the steps
     * 
     * step method create a list of all the steps
     */
    public List<Step> listSteps() { 
        List<Step> steps = new ArrayList<Step>();
        DBCursor dbObjects = collection.find();
        while(dbObjects.hasNext()){
            DBObject dbObject = dbObjects.next();
            steps.add(new Step((BasicDBObject) dbObject));
        }
        return steps;
    }
    
    /**
     * @param id of the step to search
     * @return Step with the respective id
     * 
     * company method returns a step that match with the given id
     */
    public Step getStep(String id) {
        return new Step((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
    }
    
    /**
     * @param body with the data to create
     * @return Step created with the given data
     * 
     * step method creates a new step with the given data
     */
    public Step createStep(String body) {
        Step step = new Gson().fromJson(body, Step.class);
        collection.insert(new BasicDBObject("url", step.getUrl()).append("description", step.getDescription()));
        return step;
    }
    
    /**
     * @param Step with the data to update
     * @return Step with the updated values
     * 
     * step method update a step with the given data
     */
    public Step updateStep(String id, String body) {
        Step step = new Gson().fromJson(body, Step.class);
        collection.update(new BasicDBObject("_id", new ObjectId(id)), new BasicDBObject("url", step.getUrl()).append("description", step.getDescription()));
        return this.getStep(id);
    }
    
    /**
     * @param id
     * 
     * step method, delete a step with the given id
     */
    public void deleteStep(String id){
        collection.remove(new BasicDBObject("_id", new ObjectId(id)));
    }
    
}
