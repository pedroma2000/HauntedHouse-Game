package HauntedHouse.PlayerTests;

import HauntedHouse.Game.Player;
import HauntedHouse.Game.PlayerExceptions;
import HauntedHouse.MapDefinitions.Room;
import Structures.Stack.EmptyCollectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for useFlashBack
 * method
 *
 * @author Pedro Machado "pedroma2000"
 */
public class useFlashBackTests {

    Player player;
    Room oldRoom;
    Room newRoom;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        oldRoom = new Room("Entrada", 0);
        player = new Player("Mario", 100, oldRoom);
        newRoom = new Room("Hall", 0);
    }

    /**
     * Test to see if is returned an exception when stack size is 1
     * and the user calls the method useFlashBack
     */
    @Test
    public void useFlashWhenSizeOfStackIsOneTest() {
        Assertions.assertThrows(PlayerExceptions.class, () -> {
            player.useFlashBack(1);
        });
    }

    /**
     * Test to see if the work of the method useFlashBack is done correctly
     *
     * @throws EmptyCollectionException EmptyCollectionException
     * @throws PlayerExceptions PlayerExceptions
     */
    @Test
    public void useFlashWhenValidTest() throws EmptyCollectionException, PlayerExceptions {
        player.makeMove(newRoom);
        player.useFlashBack(1);
        Assertions.assertEquals(player.getCurrentRoom(), oldRoom);
    }

    /**
     * Test to see if is returned an exception when numberOfFlashes is zero
     * and the user calls the method useFlashBack
     *
     * @throws EmptyCollectionException EmptyCollectionException
     * @throws PlayerExceptions PlayerExceptions
     */
    @Test
    public void useFlashWhenNumberOfFlashIsZeroTest() throws EmptyCollectionException, PlayerExceptions {
        player.makeMove(newRoom);
        player.useFlashBack(1);
        player.makeMove(newRoom);
        player.useFlashBack(1);
        player.makeMove(newRoom);
        player.useFlashBack(1);
        player.makeMove(newRoom);
        Assertions.assertThrows(PlayerExceptions.class, () -> {
            player.useFlashBack(1);
        });
    }
}
