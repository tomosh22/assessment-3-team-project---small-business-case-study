package csc1035.project3;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Input {
    public static void main(String[] args) {
        Item i1 = new Item("Gold Ring","Jewellery",false,120.00,4,180.00);
        insertEntity(i1);
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
    }
}
