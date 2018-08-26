import models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
        private Customer customer_1;


    @Before
    public void before(){
        Shop shop = new Shop("new shop");

        customer_1 = new Customer("Ricardo", "Edinburgh", shop);
    }
    @Test
    public void hasName(){
        assertEquals("Ricardo", customer_1.getCustomerName());
    }

    @Test
    public void canSetName(){
        customer_1.setCustomerName("Stu");
        assertEquals("Stu", customer_1.getCustomerName());
    }

    @Test
    public void gotAddress(){
        assertEquals("Edinburgh", customer_1.getCustomerAddress());
    }

    @Test
    public void canSetAddress(){
        customer_1.setCustomerAddress("Glasgow");
        assertEquals("Glasgow", customer_1.getCustomerAddress());
    }


//    @Test
//    public void canSetEnvInfo(){
//        customer_1.addEnvironmentalInfo("co2", "test");
//        assertEquals("test", customer_1.getEnvironmetnInfo().get("co2"));
//    }
//
//    @Test
//    public void canAddToBasket(){
//        Farms farm1 = new Farms("Animal Farms", "McDonnald", "FarmRoad 7", FuelConversionFactorType.ELECTRIC);
//        Product product1 = new Product("potatoes", GroupType.DAIRY, TagType.ORGANIC,1, farm1);
//        customer_1.addToBasket(product1);
//        assertEquals("potatoes", customer_1.getBasket().get(0).getProductName());
//    }
//



}
