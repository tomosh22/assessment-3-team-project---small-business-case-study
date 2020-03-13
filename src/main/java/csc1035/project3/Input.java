package csc1035.project3;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Input {
    /**
     * Inserts one entry into the table
     * @param I passed Item that will be inserted into array
     */
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

    /**
     * Removes a entity from the table using its primary key
     * @param key primary key of the entity being removed
     */
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

    /**
     * Updates a single cell of one entity in the table
     * @param column what field is being changed
     * @param key the key of the entity being updated
     * @param value generic value of what the cell is being changed to
     */
    public static < E > void updateEntity(int column, int key, E value){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Item I = session.get(Item.class, key);
        try {
            switch (column) {
                //update category
                case (0):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setCategory(value.toString());
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update cost
                case (1):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setCost(Double.parseDouble(value.toString()));
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update name
                case (2):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setName(value.toString());
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update perishable
                case (3):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setPerishable(Boolean.parseBoolean(value.toString()));
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update sell_price
                case (4):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setSell_price(Double.parseDouble(value.toString()));
                    session.update(I);
                    session.getTransaction().commit();
                    break;
                //update stock
                case (5):
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    I.setStock(Integer.parseInt(value.toString()));
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

    /**
     * Reads a csv file of the Table and adds it to the table
     * @param fileName the name of the file, with extension, to be read from
     */
    public static void readFile(String fileName){
        String line;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] item = line.split(",");
                Item i = new Item(item[1],item[2], Boolean.parseBoolean(item[3]), Double.parseDouble(item[4]),
                        Integer.parseInt(item[5]), Double.parseDouble(item[6]));
                insertEntity(i);
            }
        }
        catch(IOException e){
            System.out.println("Failed to read file, incorrect file path or name.");
        }
    }
}
