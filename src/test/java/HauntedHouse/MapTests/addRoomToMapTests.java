package HauntedHouse.MapTests;

import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

/**
 * Test class for addRoomToMap method
 * @author Pedro Machado "pedroma2000"
 */
public class addRoomToMapTests {
    Map map;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup(){
        map = new Map("test map",100);
    }

    /**
     * Test if a room is added to the map
     */
    @Test
    public void testIfARoomWasAddedToTheMap(){
        map.addRoomToMap("hall",10);
        Iterator<Room> itr = map.getAddedRoomsIterator();
        String name = "";
        while (itr.hasNext()){
            name = itr.next().getRoomName();
        }
        Assertions.assertEquals("hall", name);
    }
}
