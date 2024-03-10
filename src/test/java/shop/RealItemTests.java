package shop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RealItemTests {

    @Test
    void testSetAndGetWeight() {
        RealItem item = new RealItem();
        double expectedWeight = 50.0;
        item.setWeight(expectedWeight);
        double actualWeight = item.getWeight();
        assertEquals(expectedWeight, actualWeight);
    }
}
