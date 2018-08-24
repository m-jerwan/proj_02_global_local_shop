package db;

import models.Product;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBShop {

    private static Session session;

    public static List<Product> allProductsForShop() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Product> results = null;
        try{
            Criteria cr = session.createCriteria(Product.class);
            //TODO get unique results
            results =  cr.list();

        }catch(HibernateException ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }
}
