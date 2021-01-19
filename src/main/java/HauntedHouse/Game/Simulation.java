package HauntedHouse.Game;

import HauntedHouse.ConsoleCommands;
import HauntedHouse.Generated;
import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import HauntedHouse.MapDefinitions.Room;
import Structures.BinaryTree.BinaryTreeExceptions;
import Structures.Graph.GraphExceptions;
import Structures.Lists.ListExceptions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class of Simulation Mode of Game
 *
 * @author Pedro Machado "pedroma2000"
 */
@Generated
public class Simulation implements Game {

    private Map map;
    private int diff;
    private int points;

    /**
     * Default Simulation Contructor
     *
     * @param mp the game map
     * @param tmpDiff the game difficulty
     */
    public Simulation(Map mp, Difficulty tmpDiff) {
        map = mp;
        diff = Difficulty.getDifficultyFactor(tmpDiff);
        this.points = map.getPoints();
    }

    @Override
    public void startGame() throws BinaryTreeExceptions, GraphExceptions, ListExceptions, IOException, MapExceptions {
        Iterator<Room> path = map.bestPathForMapIterator();
        int steps = 1;

        ConsoleCommands.clearConsole();
        Room currentRoom = path.next();
        System.out.println("------------------------------------------------");
        System.out.println("Começo do Jogo : \n");
        while (path.hasNext() && !currentRoom.getRoomName().equals(Map.EXIT)) {
            System.out.println("Sala Atual: " + currentRoom.toString(false));
            this.points = this.points - (diff * currentRoom.getGhostCost());
            this.showPlayerPoints();
            System.out.println("------------------------------------------------");
            System.out.println("Passo " + steps + " :");
            currentRoom = path.next();
            System.out.println("-> Proxima sala : " + currentRoom.getRoomName());
            System.out.println("------------------------------------------------");
            System.out.println("\nPressione \"ENTER\" para continuar...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            System.out.println("------------------------------------------------");
            steps++;
        }

        ConsoleCommands.clearConsole();
        System.out.println("\nFinal do jogo. Pontuação Final : " + this.points + "\n");
    }

    /**
     * Method used to show the current player
     * points
     */
    private void showPlayerPoints() {
        System.out.println("Pontuação Atual: " + points);
    }
}
