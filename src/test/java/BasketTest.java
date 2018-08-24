import models.Basket;
import models.Customer;
import models.Shop;
import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;

public class BasketTest {
    private Customer customer_1;
    private Basket basket_1;

    @Before
    public void before(){
        Shop shop = new Shop("new shop");
        customer_1 = new Customer("Ricardo", "Edinburgh", shop);
        basket_1 = new Basket(customer_1);
    }


    @Test
    public void startsEmpty(){
        assertEquals(0, basket_1.getProductsInBasket().size());
    }

    @Test
    public void hasCustomer(){
        assertEquals("Ricardo", basket_1.getCustomer().getCustomerName());
    }


}
