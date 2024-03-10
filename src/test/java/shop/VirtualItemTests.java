package shop;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualItemTests {

    private VirtualItem item;

    @BeforeEach
    void setUp() {
        item = new VirtualItem();
    }

    @AfterEach
    void tearDown() {
        item = null;
    }

    @Test
    @DisplayName("Testing inheritance")
    void testInheritance() {
        item.setName("Test Item");
        item.setPrice(10.0);
        assertEquals("Test Item", item.getName());
        assertEquals(10.0, item.getPrice());
    }
}
