/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

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
