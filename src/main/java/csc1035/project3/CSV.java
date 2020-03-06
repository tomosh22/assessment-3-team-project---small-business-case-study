package csc1035.project3;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.Iterator;
import java.util.List;

public class CSV {
    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query query = s.createQuery("from Item ");
            List results = query.getResultList();
            Iterator iter = results.iterator();
            PrintWriter writer = new PrintWriter(new FileWriter("output.csv"));
            for(Object item:results){
                writer.write(((Item) item).getId());
                writer.write(((Item) item).getName());
                writer.write(((Item) item).getCategory());
                writer.write(Boolean.toString(((Item) item).isPerishable()));
                writer.write(Double.toString(((Item) item).getCost()));
                writer.write(((Item) item).getStock());
                writer.write(Double.toString(((Item) item).getSell_price()));
                writer.write("\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            s.close();
        }
    }
}
