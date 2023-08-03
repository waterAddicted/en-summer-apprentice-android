package com.events_management.ticketmangmenta.app;

public class ItemModel {
    private String name;
    private String description;
    private int imageName; // Câmp pentru numele imaginii

    public ItemModel(String name, String description, int imageName) {
        this.name = name;
        this.description = description;
        this.imageName = imageName;
    }

    // Getters și setters pentru a accesa și seta valorile câmpurilor.

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

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }
}
