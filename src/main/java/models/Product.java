package models;

import java.util.List;

public class Product {

    private int id;
    private String productName;
    private Enum group;
    private List<Enum> tags;
    private double weight;

    public Product(){}

    public Product(String productName, Enum group, List<Enum> tags, double weight) {
        this.productName = productName;
        this.group = group;
        this.tags = tags;
        this.weight = weight;
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


//OTHER METHODS



}
