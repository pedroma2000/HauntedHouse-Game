package HauntedHouse.Game;

import HauntedHouse.Generated;

/**
 * Class with exceptions to use on Player
 * class
 *
 * @author Pedro Machado "pedroma2000"
 */
@Generated
public class PlayerExceptions extends Exception {

    /**
     * message for when flash cannot be used
     */
    public static final String FLASHBACK_CANNOT_BE_USED = "Não pode usar o flashback porque se encontra na entrada.";
    /**
     * message for when number of flashback is zero
     */
    public static final String NUMBER_OF_FLASHBACK_IS_ZERO = "Já esgotou os flashback disponíveis.";

    public PlayerExceptions() {
    }

    public PlayerExceptions(String message) {
        super(message);
    }

}
