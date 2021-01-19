package HauntedHouse.MapDefinitions;

import HauntedHouse.Generated;

/**
 * Class with exceptions to use on Map
 * class
 * @author Pedro Machado "pedroma2000"
 */
public class MapExceptions extends Exception {

    /**
     * message for non existent room
     */
    public static final String ROOM_NOT_LOADED = "O quarto não existe.";

    @Generated
    public MapExceptions() {
    }

    @Generated
    public MapExceptions(String message) {
        super(message);
    }

}
