package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTests {

    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeEach
    void setUp() {
        cart = new Cart("Test Cart");
        realItem = new RealItem();
        realItem.setName("Test Real Item");
        realItem.setPrice(10.0);
        realItem.setWeight(0.5);

        virtualItem = new VirtualItem();
        virtualItem.setName("Test Virtual Item");
        virtualItem.setPrice(5.0);
        virtualItem.setSizeOnDisk(1024.0);
    }

    @AfterEach
    void tearDown() {
        cart = null;
        realItem = null;
        virtualItem = null;
    }

    @Test
    void testAddAndDeleteRealItem() {
        cart.addRealItem(realItem);
        assertTrue(cart.getRealItems().contains(realItem), "Item should be in cart");

        cart.deleteRealItem(realItem);
        assertAll("Cart state after deleting item",
                () -> assertFalse(cart.getRealItems().contains(realItem), "Item should not be in cart"),
                () -> assertEquals(0.0, cart.getTotalPrice(), "Total price should be 0.0")
        );
    }

    @Test
    void testGetTotalPrice() {
        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);
        assertEquals(18.0, cart.getTotalPrice()); // Total price with tax
    }
}
