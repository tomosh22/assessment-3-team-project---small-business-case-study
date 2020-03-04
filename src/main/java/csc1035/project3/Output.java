package csc1035.project3;
import org.hibernate.query.*;
import org.hibernate.Session;
import java.util.List;

public class Output {
    public static void main(String[] args) {
        System.out.println(getDBCategory("Gold Ring"));
    }

/*    public static Object[] getAllDBCategory() {
        //This method returns the names and categories of all items in the Item table
        Session s = HibernateUtil.getSessionFactory().openSession();    //Create session
        s.beginTransaction();   //Start transaction
        Query query = s.createQuery("select i.name, i.category from Item i");
        List results = query.list();    //Creates lists of the results from the query
        s.getTransaction().commit();
        Object[] items = results.toArray(); //Changes stored results to an array
        s.close();
        return items; // Return object array storing results to be outputted
    }
*/
    public static String getDBCategory(String nameOfItem) {
        //This method returns the names and categories of the item passed by parameter
        Session s = HibernateUtil.getSessionFactory().openSession();    //Create session
        s.beginTransaction();   //Start transaction
        Query query = s.createQuery("select i.category from Item i WHERE i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();    //Creates lists of the results from the query
        s.close();
        return (String) results.get(0);
    }
/*
    public static Object[] getAllDBCost() {
        //This methods returns the name and cost of all items stored in Item
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.cost from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        return items; //
    }
*/
    public static double getDBCost(String nameOfItem) {
        //This methods returns the name and cost of the item passed by parameter
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.cost from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();    //Creates lists of the results from the query
        s.close();
        return (double) results.get(0);

    }
/*
    public static Object[] getAllDBName() {
        //This method will return the names of all items stored in Item.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        return items;
    }
*/
/*
    public static Object[] getAllDBSellPrice(){
        //This method returns the name and sell price of all items stored in Items.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.sell_price from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        return items;
    }
*/
    public static double getDBSellPrice(String nameOfItem) {
        //This method returns the name and sell price of the item passed by parameter.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.sell_price from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();    //Creates lists of the results from the query
        s.close();
        return (double) results.get(0);


    }
/*
    public static Object[] getAllDBStock() {
        //This method will return the item name and stock of all items.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.stock from Item i");
        List results = query.list();
        s.getTransaction().commit();
        Object[] items = results.toArray();
        return items;

    }
*/
    public static int getDBStock(String nameOfItem) {
        //This is the same method as selecting all stock, however a parameter can
        //be passed to select the item to show stock for.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.stock from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();    //Creates lists of the results from the query
        s.close();
        return (int) results.get(0);


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
