package HauntedHouse.ResultTests;

import HauntedHouse.MapDefinitions.MapExceptions;
import HauntedHouse.Menu.MapFile;
import HauntedHouse.Menu.MapFileExceptions;
import HauntedHouse.Menu.Result;
import Structures.Graph.GraphExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for compareTo method
 *
 * @author Pedro Machado "pedroma2000"
 */
public class compareToTests {

    private Result r1;
    private Result r2;
    private int excepted;


    /**
     * This tests checks if is returned 1
     * when the second result is bigger than the first
     */
    @Test
    public void compareToWhenFirstIsSmallerThanSecond() {
        r1 = new Result("Test", 100);
        r2 = new Result("Test2", 120);
        excepted = 1;
        Assertions.assertEquals(excepted, r1.compareTo(r2));
    }

    /**
     * This tests checks if is returned -1
     * when the second result is smaller than the first
     */
    @Test
    public void compareToWhenFirstIsBiggerThanSecond() {
        r1 = new Result("Test", 120);
        r2 = new Result("Test2", 100);
        excepted = -1;
        Assertions.assertEquals(excepted, r1.compareTo(r2));
    }

    /**
     * This tests checks if is returned 0
     * when the second result is equal to the first
     */
    @Test
    public void compareToWhenFirstIsEqualToTheSecond() {
        r1 = new Result("Test", 120);
        excepted = 0;
        Assertions.assertEquals(excepted, r1.compareTo(r1));
    }
}
