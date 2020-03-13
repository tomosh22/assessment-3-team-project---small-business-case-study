import csc1035.project3.*;
import csc1035.project3.Item;
import org.hibernate.HibernateException;
import org.junit.Test;

public class InputTesting {

    @Test
    public void testInsertEntity(){
        Item i = new Item("TestName", "TestCategory", false, 20.00, 15, 20.00);
        Input.insertEntity(i);
        assert Output.getDBSellPrice("TestName")==i.getSell_price();
        Input.removeEntity(Output.getDBId("TestName"));
    }

    @Test
    public void testRemoveEntity(){
        try {
            Item i = new Item("TestName", "TestCategory", false, 20.00, 15, 20.00);
            Input.insertEntity(i);
            Input.removeEntity(Output.getDBId("TestName"));
            if (Output.getDBSellPrice("TestName") == i.getSell_price()) {
                assert false;
            } else {
                assert true;
            }
        }
        catch(IndexOutOfBoundsException e) {
            assert true;
        }
    }

    @Test
    public void testUpdateEntity(){
        Item i = new Item("TestName", "TestCategory", false, 15.00, 15, 20.00);
        Input.insertEntity(i);
        Input.updateEntity(1, Output.getDBId("TestName"), 20.00);
        assert Output.getDBCost("TestName")==20.00;
        Input.removeEntity(Output.getDBId("TestName"));
    }
}