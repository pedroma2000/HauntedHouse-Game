package HauntedHouse.RoomTests;

import HauntedHouse.MapDefinitions.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests class for hasGhost method
 *
 * @author Pedro Machado "pedroma2000"
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class hasGhostTests {
    Room room;
    
    /**
     * test if the method returns true
     * if the room has ghostCost, meaning it has
     * a ghost
     */
    @Test
    public void testIfRoomHasGhost(){
        room = new Room("Kitchen",15);
        Assertions.assertTrue(room.hasGhost());
    }

    /**
     * test if the method returns false
     * if the room has ghostCost equals to zero,
     * meaning it has not a ghost
     */
    @Test
    public void testIfRoomHasNoGhost(){
        room = new Room("Kitchen",0);
        Assertions.assertFalse(room.hasGhost());
    }
}
