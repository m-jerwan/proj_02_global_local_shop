package models;

import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {

    private int id;
    private String productName;
    private GroupType groupType;
    private TagType tag;
    private double weight;
    private Farm farm;
    private Shop shop;
    private Basket basket;


    public Product(){}

    public Product(String productName, GroupType groupType, TagType tag, double weight, Farm farm, Shop shop) {
        this.productName = productName;
        this.groupType = groupType;
        this.tag = tag;
        this.weight = weight;
        this.farm = farm;
        this.shop = shop;
        this.basket = null; // PRODUCTS START WITH NULL BASKET
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
    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "farm_id", nullable = false)
    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id", nullable = true)
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }


 //OTHER METHODS


//    RETURNS EMISSIONS OF ONE PRODUCT BASED ON QUANTITY 1 -- WE NEED TO UPDATE THE QUANTITY

    public double emissionsOfProduct(){
        return (getGroupType().getFoodConversionFactor() * 1 * this.getWeight())/1000;
    }

//

    public double emissionsOfProductKG(){
        return (getGroupType().getFoodConversionFactor() * 1 * this.getWeight());
    }

//    RETURNS EMISSIONS OF ONE PRODUCT BASED OF DISTANCE 1 -- WE NEED TO UPDATE THE DISTANCE




    public double emissionsOfFoodMilesTravelled(){
        return (getFarm().getFuelConversionFactorType().getFuelConversionFactor() * 100)/1000;
    }

    public double totalEmissions(){
        return emissionsOfProduct() + emissionsOfFoodMilesTravelled();
    }



//    public double emissionsOfFoodMilesTravelled(String point1, String point2){
//        int distanceTravelled = Distance.distanceBetween(point1, point2);
//        return (getFarm().getFuelConversionFactorType().getFuelConversionFactor() * distanceTravelled)/1000;
//    }
//    //    TODO: Patrycja to fix:
//    public double totalEmissions(String point1, String point2){
//        return emissionsOfProduct() + emissionsOfFoodMilesTravelled(point1, point2);
//    }




//    public double getEmissionsOfWaste(){
//        return 0.00;
//    }
//
//    public double getTotalFootprintOfProduct(){
//        return 0.00;
//    }

}
