import csc1035.project3.*;
import org.junit.Test;

public class OutputTesting {

    /*
    All expected outcomes used are correct as of 11/03/2020 from the Item table
     */

    @Test
    public void testGetCategory() {
        String expected = "Jewellery";
        String actual = Output.getDBCategory("Gold Ring");
        assert expected.equals(actual);
    }

    @Test
    public void testGetStock() {
        int expected = 2;
        int actual = Output.getDBStock("Gold Ring");
        assert expected == actual;
    }

    @Test
    public void testGetCost() {
        double expected = 120;
        double actual = Output.getDBCost("Gold Ring");
        assert expected == actual;
    }

    @Test
    public void testGetSellPrice() {
        double expected = 180;
        double actual = Output.getDBSellPrice("Gold Ring");
        assert expected == actual;
    }

    @Test
    public void testGetDBId() {
        int expected = 1;
        int actual = Output.getDBId("Gold Ring");
        assert expected == actual;
    }
}

