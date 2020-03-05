package csc1035.project3;
import org.hibernate.query.*;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class Output {
    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("FROM Item");
        List results = query.getResultList();
        s.close();
        Iterator iter = results.iterator();
        while(iter.hasNext()){
            Item item = (Item) iter.next();
            System.out.println(item.getCategory());
        }
    }


    public static String getDBCategory(String nameOfItem) {

        //This method returns the category of the item that is passed by parameter
        //First creates a session to start the transaction

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        // Start a query and save the result to a list

        Query query = s.createQuery("select i.category from Item i WHERE i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();

        // Closes the session
        s.close();

        // Return the category of the named item as String

        return (String) results.get(0);
    }

    public static int getDBStock(String nameOfItem) {

        //This method returns the stock of the item that is passed by parameter.
        // Code is similar to the method for returning category. Follow comments from above.

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.stock from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();
        s.close();

        // The stock of the named item is returned as an integer.

        return (int) results.get(0);


    }

    public static double getDBCost(String nameOfItem) {

        //This methods returns the cost of the item passed by parameter
        // Code is similar to the method for returning category. Follow comments from above.

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.cost from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();
        s.close();

        // The cost of the named item is returned as a double.

        return (double) results.get(0);

    }

    public static double getDBSellPrice(String nameOfItem) {

        //This method returns the sell price of the item passed by parameter.
        // Code is similar to the method for returning category. Follow comments from above.

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.sell_price from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();
        s.close();

        // The sell price of the named item is returned as a double.

        return (double) results.get(0);


    }

    //The following methods are currently not needed, but may be needed at a later date.

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

    public static Object[] getAllDBCategory() {
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

    public static void outputResults(Object[] items) {

        // This method is used to loop through and print the results of a results array

        for (int i = 0; i < items.length; i++) {
            Object[] tmp = (Object[]) items[i];
            for (int j = 0; j < tmp.length; j++) {
                System.out.print(tmp[j] + " ");
            }
            System.out.println();
        }
    }
}
