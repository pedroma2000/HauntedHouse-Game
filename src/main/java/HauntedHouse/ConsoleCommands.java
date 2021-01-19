package HauntedHouse;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Commands for console application
 *
 * @author Pedro Machado "pedroma2000"
 */
@Generated
public class ConsoleCommands {

    /**
     * Command to clean console
     */
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            Robot robot = null;
            try {
                robot = new Robot();
                robot.keyPress(KeyEvent.VK_PAUSE);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }
    }

}
