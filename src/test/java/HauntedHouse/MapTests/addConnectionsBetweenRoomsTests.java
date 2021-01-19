package HauntedHouse.MapTests;

import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import HauntedHouse.Menu.MapFile;
import HauntedHouse.Menu.MapFileExceptions;
import Structures.Graph.GraphExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for addConnectionsBetweenRooms
 * method
 *
 * @author Pedro Machado "pedroma2000"
 */
public class addConnectionsBetweenRoomsTests {
    MapFile mapFile;
    Map map;

    /**
     * test cases setup
     *
     * @throws GraphExceptions   GraphExceptions
     * @throws MapFileExceptions MapFileExceptions
     * @throws MapExceptions     MapExceptions
     */
    @BeforeEach
    public void testSetup() throws GraphExceptions, MapFileExceptions, MapExceptions {
        mapFile = new MapFile();
        mapFile.loadMapFile("maps/mapa.json");
        map = mapFile.createMapStructure();
    }

    /**
     * Test if addConnectionsBetweenRooms throws
     * an exception when a room is invalid
     */
    @Test
    public void testIfAnExceptionIsThrownWhenARoomIsInvalid() {
        Assertions.assertThrows(MapExceptions.class, () -> {
            map.addConnectionsBetweenRooms("hall", "x");
        });
    }

}
