import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator c = new Calculator();
        int result = c.add(1,2);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void mul() {
    }
}