/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//T

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Jozehan
 */
public class Category {
    private final int CategoryID;
    private String name;
    private String description;

    public Category(int CategoryID, String name, String description) {
        this.CategoryID = CategoryID;
        this.name = name;
        this.description = description;
    }

    public Category(int CategoryID) {
        this.CategoryID = CategoryID;
        //look for category with ID and add data
    }
    
    public ArrayList<Category> getCategories(){
        //get categories, populate them and send them. 
        ArrayList<Category> dummy = new ArrayList<Category>();
        dummy.add(new Category(1, "Cat1", "desc1"));
        dummy.add(new Category(1, "Cat2", "desc2"));
        dummy.add(new Category(1, "Cat3", "desc3"));
        return dummy;
    }
    public int getCategoryID() {
        return CategoryID;
    }

    public Category() {
        this.CategoryID = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
