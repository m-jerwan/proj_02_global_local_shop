package models;

import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {

    private int id;
    private String productName;
    private GroupTypeNew groupTypeNew;
//    private GroupType group;
    private TagType tag;
    private double weight;
    private Farm farm;


    public Product(){}

    public Product(String productName, GroupTypeNew groupTypeNew, TagType tag, double weight, Farm farm) {
        this.productName = productName;
        this.groupTypeNew = groupTypeNew;
        this.tag = tag;
        this.weight = weight;
        this.farm = farm;
    }

    //GETTERS & SETTERS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Enumerated(value = EnumType.STRING)
    public GroupTypeNew getGroupTypeNew() {
        return groupTypeNew;
    }

    public void setGroupTypeNew(GroupTypeNew groupTypeNew) {
        this.groupTypeNew = groupTypeNew;
    }

    //    @Enumerated(value = EnumType.STRING)
//    public GroupType getGroup() {
//        return this.group;
//    }
//
//    public void setGroup(GroupType group) {
//        this.group = group;
//    }

    @Enumerated(value = EnumType.STRING)
    public TagType getTag() {
        return tag;
    }

    public void setTag(TagType tag) {
        this.tag = tag;
    }

    @Column(name = "weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id", nullable = false)
    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    //OTHER METHODS



}
