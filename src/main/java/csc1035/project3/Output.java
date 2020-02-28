package csc1035.project3;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class Output {
    public static void main(String[] args) {
        getDBCategory();
        getDBCost();
    }
    public static void getDBCategory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List items = session.createQuery("FROM Item ").list();
            for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();){
                Item nextItem = iterator.next();
                System.out.println("Category: " + nextItem.getCategory());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session!=null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void getDBCost(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            List items = session.createQuery("FROM Item ").list();
            for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();){
                Item nextItem = iterator.next();
                System.out.println("Cost: " + nextItem.getCost());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session!=null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void getDBName(){

    }
    public static void getDBSellPrice() {

    }
    public static void getDBStock(){
    }
}