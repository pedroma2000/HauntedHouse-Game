package HauntedHouse.RoomTests;

import HauntedHouse.MapDefinitions.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for numberOfDoors method
 *
 * @author Pedro Machado "pedroma2000"
 */
 */
public class numberOfDoorsTests {
    Room room1;
    Room room2;
    Room room3;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        room1 = new Room("kitchen", 15);
        room2 = new Room("Garage", 1);
        room3 = new Room("Living Room", 12);
    }

    /**
     * test if the number of doors
     * equals to the number rooms
     * connected to a specific room
     */
    @Test
    public void testNumberOfDoorsOfARoom() {
        room1.addConnection(room2);
        room1.addConnection(room3);
        Assertions.assertEquals(2,room1.numberOfDoors());
    }

}
