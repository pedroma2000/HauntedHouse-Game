package HauntedHouse.RoomTests;

import HauntedHouse.MapDefinitions.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for hasConnections method
 *
 * @author Pedro Machado "pedroma2000"
 */
 */
public class hasConnectionsTests {

    Room room1;
    Room room2;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        room1 = new Room("kitchen", 15);
        room2 = new Room("Garage", 1);
    }

    /**
     * test to check if a room is connected
     * to another when adding a connection
     * in 1 direction
     */
    @Test
    public void testIfARoomHasAConnection() {
        room1.addConnection(room2);
        Assertions.assertTrue(room1.hasConnection(room2));
    }

    /**
     * test to check if a room doesnt
     * have a connection in 1 direction
     * when added a connection
     * in the opposite direction
     */
    @Test
    public void testIfARoomHasNotAConnection() {
        room1.addConnection(room2);
        Assertions.assertFalse(room2.hasConnection(room1));
    }

}