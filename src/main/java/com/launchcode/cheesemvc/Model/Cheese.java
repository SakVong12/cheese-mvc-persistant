package com.launchcode.cheesemvc.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name= "cheeses")
public class Cheese {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Size(min=3, max = 15, message = "not meeting requirement")
    @NotNull
    private String name;

    @Size(min=1, message = "at least 1 char is required")
    @NotNull
    private  String description;

    @ManyToOne
    private Category category;

    public Cheese() {
    }

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
