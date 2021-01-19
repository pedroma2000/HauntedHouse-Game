package HauntedHouse.MapFileTests;

import HauntedHouse.Menu.MapFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests class for method isMapLoaded
 *
 * @author Pedro Machado "pedroma2000"
 */
public class isMapLoadedTests {

    MapFile mapFile;
    String fileLocation;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        mapFile = new MapFile();
    }

    /**
     * Test if the method isMapLoaded returns false
     * when trying to load a valid map file
     * in a invalid location
     */
    @Test
    public void IsMapLoadedWhenInvalid() {
        fileLocation = "maps/x.json";
        mapFile.loadMapFile(fileLocation);
        Assertions.assertFalse(mapFile.isMapLoaded());
    }

    /**
     * Test if the method isMapLoaded returns true
     * when trying to load a valid map file
     * in a valid location
     */
    @Test
    public void IsMapLoadedWhenValid() {
        fileLocation = "maps/mapa.json";
       mapFile.loadMapFile(fileLocation);
        Assertions.assertTrue(mapFile.isMapLoaded());
    }
}