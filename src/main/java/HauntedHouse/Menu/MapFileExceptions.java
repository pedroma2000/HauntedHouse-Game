package HauntedHouse.Menu;

import HauntedHouse.Generated;

/**
 * Class with exceptions to be used on Menu
 *
 * @author Pedro Machado "pedroma2000"
 */
public class MapFileExceptions extends Exception {

    /**
     * message for non loaded map
     */
    public static final String MAP_NOT_LOADED = "O mapa não foi carregado.";

    @Generated
    public MapFileExceptions() {
    }

    @Generated
    public MapFileExceptions(String message) {
        super(message);
    }
}
