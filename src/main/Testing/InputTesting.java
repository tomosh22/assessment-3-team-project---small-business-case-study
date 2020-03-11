import csc1035.project3.*;
import csc1035.project3.Item;
import org.junit.Test;

public class InputTesting {

    @Test
    public void testInsertEntity(){
        Item i = new Item("TestName", "TestCategory", false, 20.00, 15, 20.00);
        Input.insertEntity(i);
        assert Output.getDBSellPrice("TestName")==i.getSell_price();
        Input.removeEntity(Output.getDBId("TestName"));
    }
}
