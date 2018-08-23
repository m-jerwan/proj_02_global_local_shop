package models;

import java.util.List;

public class Product {

    private int id;
    private String productName;
    private Enum group;
    private List<Enum> tags;
    private double weight;
    private Farm farm;

    public Product(){}

    public Product(String productName, Enum group, List<Enum> tags, double weight, Farm farm) {
        this.productName = productName;
        this.group = group;
        this.tags = tags;
        this.weight = weight;
        this.farm = farm;
    }

    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Enum getGroup() {
        return group;
    }

    public void setGroup(Enum group) {
        this.group = group;
    }

    public List<Enum> getTags() {
        return tags;
    }

    public void setTags(List<Enum> tags) {
        this.tags = tags;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    //OTHER METHODS



}
