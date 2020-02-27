package csc1035.project3;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Input {
    public static void main(String[] args) {
        Item i1 = new Item("Gold Ring","Jewellery",false,120.00,4,180.00);
        //insertEntity(i1);
        //removeEntity(4);
        updateEntity(0, 2, "Test", 0.0, false, 0);
    }

    public static void insertEntity(Item I){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(I);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            if (session!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static void removeEntity(int key){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Item I = session.get(Item.class, key);
            session.delete(I);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            if (session!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static void updateEntity(int column, int key, String text, double cost, boolean perishable, int num){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Item I = session.get(Item.class, key);
        try {
            switch (column) {
                //update category
                case (0):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setCategory(text);
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update cost
                case (1):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setCost(cost);
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update name
                case (2):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setName(text);
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update perishable
                case (3):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setPerishable(perishable);
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update sell_price
                case (4):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setSell_price(cost);
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update stock
                case (5):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setStock(num);
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                default:
                    break;
            }
        }
        catch(HibernateException e){
            if (session!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
