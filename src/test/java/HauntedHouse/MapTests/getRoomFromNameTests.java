package HauntedHouse.MapTests;

import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import HauntedHouse.MapDefinitions.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

/**
 * Test class for getRoomFromName method
 *
 * @author Pedro Machado "pedroma2000"
 */
public class getRoomFromNameTests {

    Map map;
    String roomName = "hall";

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        map = new Map("test map", 100);
    }

    @Test
    public void getRoomFromNameWhenRoomIsInlist() throws MapExceptions {
        map.addRoomToMap(roomName, 10);
        Iterator<Room> itr = map.getAddedRoomsIterator();
        Room excpeted = null;
        while (itr.hasNext()) {
            excpeted = itr.next();
        }
        Assertions.assertEquals(excpeted, map.getRoomFromName(roomName));
    }

    @Test
    public void getRoomFromNameWhenRoomIsNotInlist() {
        Assertions.assertThrows(MapExceptions.class, () -> {
            map.getRoomFromName(roomName);
        });
    }
}
