package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "customers")

public class Customer {

    private int id;
    private String customerName;
    private String customerAddress;
//    private Map<String, String> environmetnInfo;
    private List<Basket> baskets;
    private Shop shop;


    public Customer() {
    }

    public Customer(String customerName, String customerAddress, Shop shop) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
//        this.environmetnInfo = new HashMap<String, String>();
        this.baskets = new ArrayList<Basket>();
        this.shop = shop;
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

    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "customer_address")
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    @OneToMany(mappedBy = "customer")
    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }



    //OTHER METHODS
    public void addBasket(Basket basket){
        this.baskets.add(basket);
    }

    public void removeBasket(Basket basket){
        this.baskets.remove(basket);
    }
//
//    public void addEnvironmentalInfo(String key, String value){
//        this.environmetnInfo.put(key, value);
//    }
//
//    public void removeFromEnvironemtnalInfo(String key){
//        this.environmetnInfo.remove(key);
//    }


}
