package csc1035.project3;
import org.hibernate.query.*;
import org.hibernate.Session;
import java.util.List;

public class Output {
    public static void main(String[] args) {
    }

    public static void getDBCategory() {

        Session s = HibernateUtil.getSessionFactory().openSession();    //Create session
        s.beginTransaction();   //Start transaction
        Query query = s.createQuery("select i.name, i.category from Item i WHERE i.category = 'Food'");
        List results = query.list();    //Creates lists of the results from the query
        s.getTransaction().commit();
        Object[] items = results.toArray(); //Changes stored results to an array
        outputResults(items);   //Pass object array storing results to be outputted
    }


    public static void getDBCost() {

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.cost from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);


    }

    public static void getDBName() {

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getDBSellPrice() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.sell_price from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getDBStock() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.stock from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void outputResults(Object[] items) {
        for (int i = 0; i < items.length; i++) {
            Object[] tmp = (Object[]) items[i];
            for (int j = 0; j < tmp.length; j++) {
                System.out.print(tmp[j] + " ");
            }
            System.out.println();
        }
    }
}
