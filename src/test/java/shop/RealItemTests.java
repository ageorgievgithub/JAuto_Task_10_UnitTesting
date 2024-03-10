package shop;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class RealItemTests {

    private RealItem item;

    @BeforeEach
    void setUp() {
        item = new RealItem();
    }

    @AfterEach
    void tearDown() {
        item = null;
    }

    @Test
    @DisplayName("Testing set and get weight")
    void testSetAndGetWeight() {
        double expectedWeight = 50.0;
        item.setWeight(expectedWeight);
        double actualWeight = item.getWeight();
        assertEquals(expectedWeight, actualWeight);
    }
}
