package csc1035.project3;
import org.hibernate.query.*;
import org.hibernate.Session;
import java.util.List;

public class Output {
    public static void main(String[] args) {
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

        // Start a query and save the result to a list

        Query query = s.createQuery("select i.category from Item i WHERE i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();

        // Closes the session
        s.close();

        // Return the category of the named item as String

        return (String) results.get(0);
    }

    /**
     * return the stock of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return the integer of the stock of the item
     */
    public static int getDBStock(String nameOfItem) {

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

    /**
     * return the cost of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return a double of the cost of the item
     */
    public static double getDBCost(String nameOfItem) {

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

    /**
     * return the sell price of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return a double of the sell price of the item
     */
    public static double getDBSellPrice(String nameOfItem) {

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

    /**
     * return the id of the item
     * @param nameOfItem which is item that they wish to find the stock for
     * @return an integer of the sell price of the item
     */
    public static int getDBId(String nameOfItem) {

        // Code is similar to the method for returning category. Follow comments from above.

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.id from Item i where i.name = :name");
        query.setParameter("name", nameOfItem);
        List results = query.getResultList();
        s.close();

        // The sell price of the named item is returned as a double.

        return (int) results.get(0);
    }


    public static Object[] getAllDBStock() {

        //This method will be used to return the stock of all the items in the Items table.

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.createQuery("select i.name, i.stock from Item i");
        List results = query.list();
        s.getTransaction().commit();

        // The values of the names and stock are added to an array.

        Object[] items = results.toArray();

        // The array is returned. This can be looped through to output all values in the
        s.close();
        return items;
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
}
