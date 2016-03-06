package com.uttamavillain.unavu.backend.Model;

/**
 * Created by uttamavillain on 3/5/16.
 */
public class FoodItem {

    private String name;
    private String imageUrl;
    private String description;
    private String cusine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCusine() {
        return cusine;
    }

    public void setCusine(String cusine) {
        this.cusine = cusine;
    }

    @Override
    public String toString() {
        return name+" - "+cusine;
    }
}
