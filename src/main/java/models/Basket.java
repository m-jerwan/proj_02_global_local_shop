package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket {
    private int id;
    private List<Product> productsInBasket;
    private Customer customer;

    public Basket(){}

    public Basket(Customer customer) {
        this.productsInBasket = new ArrayList<Product>();
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "basket")
    public List<Product> getProductsInBasket() {
        return productsInBasket;
    }

    public void setProductsInBasket(List<Product> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) { //DO NOT USE!
        this.customer = customer;
    }
    //    public void addProductToBasket(Product product){
//        this.productsInBasket.add(product);
//    }

    public void addToBasket(Product product){
        this.productsInBasket.add(product);
    }

    public void removeFromBasket(Product product){
        this.productsInBasket.remove(product);
    }


    public double emissionsOfProductsInBasket(){
        double totalEmissions =0;
        for (Product product : productsInBasket){
            totalEmissions += product.emissionsOfProduct();
        }
        return totalEmissions;
    }

    public double foodMilesEmissionsOfProductsInBasket(){
        double totalMilesEmissions =0;
        for (Product product : productsInBasket){
            totalMilesEmissions += product.emissionsOfFoodMilesTravelled();
        }
        return totalMilesEmissions;
    }

    public double totalEmissionsCombined(){
        double totalCombinedEmissions = 0;
        for (Product product : productsInBasket){
            totalCombinedEmissions += product.totalEmissions();
        }
        return totalCombinedEmissions;
    }


}
