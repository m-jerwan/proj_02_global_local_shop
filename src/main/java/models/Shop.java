package models;


import javax.persistence.*;

@Entity
@Table(name = "shops")

public class Shop {

    private int id;
    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
