package csc1035.project3;
import org.hibernate.query.*;
import org.hibernate.Session;
import java.util.List;

public class Output {
    public static void main(String[] args) {
    }

    public static void getAllDBCategory() {
        //This method returns the names and categories of all items in the Item table
        Session s = HibernateUtil.getSessionFactory().openSession();    //Create session
        s.beginTransaction();   //Start transaction
        Query query = s.createQuery("select i.name, i.category from Item i");
        List results = query.list();    //Creates lists of the results from the query
        s.getTransaction().commit();
        Object[] items = results.toArray(); //Changes stored results to an array
        outputResults(items);   //Pass object array storing results to be outputted
    }

    public static void getDBCategory(String nameOfItem) {
        //This method returns the names and categories of the item passed by parameter
        Session s = HibernateUtil.getSessionFactory().openSession();    //Create session
        s.beginTransaction();   //Start transaction
        Query query = s.createQuery("select i.name, i.category from Item i WHERE i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.list();    //Creates lists of the results from the query
        s.getTransaction().commit();
        Object[] items = results.toArray(); //Changes stored results to an array
        outputResults(items);   //Pass object array storing results to be outputted
    }

    public static void getAllDBCost() {
        //This methods returns the name and cost of all items stored in Item
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.cost from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getDBCost(String nameOfItem) {
        //This methods returns the name and cost of the item passed by parameter
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.cost from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getAllDBName() {
        //This method will return the names of all items stored in Item.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getAllDBSellPrice(){
        //This method returns the name and sell price of all items stored in Items.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.sell_price from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getDBSellPrice(String nameOfItem) {
        //This method returns the name and sell price of the item passed by parameter.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.sell_price from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getAllDBStock() {
        //This method will return the item name and stock of all items.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.stock from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        outputResults(items);
    }

    public static void getDBStock(String nameOfItem) {
        //This is the same method as selecting all stock, however a parameter can
        //be passed to select the item to show stock for.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.stock from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
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
