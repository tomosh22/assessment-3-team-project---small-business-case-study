package csc1035.project3;
import org.hibernate.HibernateException;
import org.hibernate.query.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public static void main(String[] args) {
        outputResults(getAllDBStock());
    }

    /**
     * Return the category of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return the String of the category of the item
     */
    public static String getDBCategory(String nameOfItem) {

        //First creates a session to start the transaction

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List results;

        // Start a query and save the result to a list
        try {
            Query query = s.createQuery("select i.category from Item i WHERE i.name = :name");
            query.setParameter("name", nameOfItem);
            results = query.getResultList();
            s.close();
            return (String) results.get(0);
        }
        catch(HibernateException e){
            if (s!=null) s.getTransaction().rollback();
            e.printStackTrace();
            return "";
        }
        finally {
            s.close();
        }
    }
    /**
     * return the stock of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return the integer of the stock of the item
     */
    public static int getDBStock(String nameOfItem) {

        //First creates a session to start the transaction

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List results;

        // Start a query and save the result to a list
        try {
            Query query = s.createQuery("select i.stock from Item i where i.name = :name");
            query.setParameter("name", nameOfItem);
            results = query.getResultList();
            s.close();
            return (int) results.get(0);
        }
        catch(HibernateException e){
            if (s!=null) s.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            s.close();
        }
    }

    /**
     * return the cost of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return a double of the cost of the item
     */
    public static double getDBCost(String nameOfItem) {

        //First creates a session to start the transaction

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List results;

        // Start a query and save the result to a list
        try {
            Query query = s.createQuery("select i.cost from Item i where i.name = :name");
            query.setParameter("name", nameOfItem);
            results = query.getResultList();
            s.close();
            return (double) results.get(0);
        }
        catch(HibernateException e){
            if (s!=null) s.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            s.close();
        }
    }

    /**
     * return the sell price of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return a double of the sell price of the item
     */
    public static double getDBSellPrice(String nameOfItem) {

        //First creates a session to start the transaction

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List results;

        // Start a query and save the result to a list
        try {
            Query query = s.createQuery("select i.sell_price from Item i where i.name = :name");
            query.setParameter("name", nameOfItem);
            results = query.getResultList();
            s.close();
            return (double) results.get(0);
        }
        catch(HibernateException e){
            if (s!=null) s.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            s.close();
        }
    }

    /**
     * return the id of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return an integer of the sell price of the item
     */
    public static int getDBId(String nameOfItem) {

        //First creates a session to start the transaction

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List results;

        // Start a query and save the result to a list
        try {
            Query query = s.createQuery("select i.id from Item i where i.name = :name");
            query.setParameter("name", nameOfItem);
            results = query.getResultList();
            s.close();
            return (int) results.get(0);
        }
        catch(HibernateException e){
            if (s!=null) s.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            s.close();
        }
    }

    public static Object[] getAllDBStock() {

        //This method will be used to return the stock of all the items in the Items table.

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Object[] items;

        try {
            Query query = s.createQuery("select i.name, i.stock from Item i");
            List results = query.list();
            s.getTransaction().commit();
            // The values of the names and stock are added to an array.

            items = results.toArray();

            // The array is returned. This can be looped through to output all values in the
            s.close();
            return items;
        }
        catch(HibernateException e){
            if (s!=null) s.getTransaction().rollback();
            e.printStackTrace();
            Object[] emptyArray = new Object[0];
            return emptyArray;
        }
        finally {
            s.close();
        }
    }

    public static void outputResults(Object[] items) {

        // This method is used to loop through and print the results of a results array
        // This is most likely to be used for the check stock part of the function

        for (int i = 0; i < items.length; i++) {
            Object[] tmp = (Object[]) items[i];
            for (int j = 0; j < tmp.length; j++) {
                System.out.print(tmp[j] + " ");
            }
            System.out.println();
        }
    }

}
