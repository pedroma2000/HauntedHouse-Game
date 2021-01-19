package HauntedHouse.RoomTests;

import HauntedHouse.MapDefinitions.Room;
import Structures.Lists.ListExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test class for removeConnection method
 *
 * @author Pedro Machado "pedroma2000"
 */
public class removeConnectionTests {

    Room room1;
    Room room2;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        room1 = new Room("kitchen", 15);
        room2 = new Room("Garage", 1);
        room1.addConnection(room2);
    }

    /**
     * test if a connection to a room is removed
     *
     * @throws ListExceptions ListExceptions
     */
    @Test
    public void testIfTheConnectionToARoomWasRemoved() throws ListExceptions {
        room1.removeConnection(room2);
        Assertions.assertFalse(room1.hasConnection(room2));
    }
}
