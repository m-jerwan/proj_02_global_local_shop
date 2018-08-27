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

public class DBCustomer {

    private static Session session;

    public static List<Basket> allBaskets(Customer customer) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Basket> results = null;
        try {
            Criteria cr = session.createCriteria(Basket.class);
            cr.add(Restrictions.eq("customer.id", customer.getId()));
            results = cr.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    // TODO TRY CATCH
//    public static Customer findCustomer(int id) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Criteria cr = session.createCriteria(Customer.class);
//        cr.add(Restrictions.eq("id", id));
//        result = getUnique(cr);
//    } catch (HibernateException ex) {
//        ex.printStackTrace();
//    } finally {
//        session.close();
//    }
//     return result;
//}

//    public static List<Product> giveMeAllProductsOfCustomer(Customer customer){
//
//        //give me all products from this customer all baskets
//
//    }


}
