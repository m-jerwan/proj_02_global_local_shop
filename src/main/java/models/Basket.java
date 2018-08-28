package models;

import db.DBHelper;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket {
    private int id;
    private List<Product> productsInBasket;
    private Customer customer;

    public Basket() {
        this.productsInBasket = new ArrayList<Product>();
    }

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

    @ManyToOne(fetch = FetchType.EAGER)
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

    public void addToBasket(Product product) {
        if (this.productsInBasket != null) {
            this.productsInBasket.add(product);
        }
    }

    public void removeFromBasket(Product product) {
        this.productsInBasket.remove(product);
    }

    public double emissionsOfProductsInBasket() {
        double totalEmissions = 0;
        for (Product product : productsInBasket) {
            totalEmissions += product.emissionsOfProduct();
        }
        return totalEmissions;
    }

    public double foodMilesEmissionsOfProductsInBasket() {
        double totalMilesEmissions = 0;
        for (Product product : productsInBasket) {
            totalMilesEmissions += product.emissionsOfFoodMilesTravelled();
        }
        return totalMilesEmissions;
    }

    public double totalEmissionsCombined() {
        double totalCombinedEmissions = 0;
        for (Product product : productsInBasket) {
            totalCombinedEmissions += product.totalEmissions();
        }
        return totalCombinedEmissions;
    }

    public double emissionsSavedFromConventional() {
        double totalEmissionsSaved = 0;
        for (Product product : productsInBasket) {
            totalEmissionsSaved += product.differenceOfEmissions();
        }
        return totalEmissionsSaved;
    }

    public double emissionsOfPlasticPackaging() {
        double totalEmissionsSavedFromPlastic = 0;
        for (Product product : productsInBasket) {
            totalEmissionsSavedFromPlastic += product.productEmissionsPlastic();
        }
        return totalEmissionsSavedFromPlastic;
    }



    public void addAllProductsOrderedToBasket(ArrayList<Product> productsOrdered) {
        for (Product productOrdered : productsOrdered) {
            productOrdered.setBasket(this);
            addToBasket(productOrdered);
            DBHelper.update(productOrdered);
        }
    }



    public Double calculate£TotalForBasket() {
        Double basketTotal = 0.00;
        for (Product productOrdered : productsInBasket) {
            basketTotal += productOrdered.getPrice();
        }
        return basketTotal;
    }

    public void putUniqueTagsFromBasketInto(List<TagType> tagsFromOrder) {

        for (Product productOrdered : productsInBasket) {

            if (!tagsFromOrder.contains(productOrdered.getTag())) {
                tagsFromOrder.add(productOrdered.getTag());
            }
        }
    }

    public ArrayList<Farm> giveMeUniqueFarmsFromBasket() {
        HashMap<Integer, Farm> farmIdsAndFarms = new HashMap<>();
        ArrayList<Farm> listWithRepeatedValues = new ArrayList<>();

        for (Product product : productsInBasket
        ) {
            listWithRepeatedValues.add(product.getFarm());

        }

        for (Farm farm : listWithRepeatedValues) {
            farmIdsAndFarms.put(farm.getId(), farm);
        }
        return new ArrayList<Farm>(farmIdsAndFarms.values());
    }


    public Double calculateTotalMileageForBasket() {
        Double totalMileageBasket = 0.00;
        for (Product productOrdered : productsInBasket) {
            int distance = Distance.distanceBetween(customer, productOrdered);
            totalMileageBasket += distance;
        }
        return totalMileageBasket;
    }
}






