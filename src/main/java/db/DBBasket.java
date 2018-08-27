package db;

import models.Basket;
import models.Customer;
import models.Product;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static db.DBHelper.getUnique;

public class DBBasket {

    private static Session session;

//    public static List<Product> findAllProductsOfThis(Basket basket){
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Product> result = null;
////
//        try{
//
//            Criteria cr = session.createCriteria(Basket.class);
//            cr.add(Restrictions.eq("id", id));
//
//
//
//        }
//        catch (HibernateException ex){
//            ex.printStackTrace();
//        }finally {
//            session.close();
//        }
//
//        return result;
//
//    }
}
