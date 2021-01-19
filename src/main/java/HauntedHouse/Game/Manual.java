package HauntedHouse.Game;

import HauntedHouse.ConsoleCommands;
import HauntedHouse.Generated;
import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import HauntedHouse.MapDefinitions.Room;
import HauntedHouse.Menu.Ratings;
import HauntedHouse.Menu.Result;
import Structures.Lists.ListExceptions;
import Structures.Stack.EmptyCollectionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Manual Gamemode class
 *
 * @author Pedro Machado "pedroma2000"
 */
@Generated
public class Manual implements Game {

    private Map map;
    private int diff;
    private Player player;

    /**
     * Manual Gamemode constructor
     *
     * @param mp      the game map
     * @param tmpDiff the game difficulty
     * @throws IOException IOException
     */
    public Manual(Map mp, Difficulty tmpDiff) throws IOException {
        map = mp;
        diff = Difficulty.getDifficultyFactor(tmpDiff);
        System.out.println("Introduza o nome do jogador: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Room entrance = map.getEntrance();
        player = new Player(input, map.getPoints(), entrance);
    }

    @Override
    public void startGame() throws EmptyCollectionException, IOException, MapExceptions, ListExceptions {
        ConsoleCommands.clearConsole();
        System.out.println("------------------------------------------------");
        System.out.println("Começo do Jogo : \n");
        while (true) {
            map.printMapFromRoom(player.getCurrentRoom().toString(), true);
            System.out.println();
            this.showPlayerPoints();
            System.out.println("------------------------------------------------");
            if (player.getCurrentRoom().getRoomName().equalsIgnoreCase(Map.ENTRANCE) == false) {
                this.askFlashback();
            }
            this.nextMove();
            if (player.getCurrentRoom().getRoomName().equalsIgnoreCase(Map.EXIT) || player.getPlayerPoints() <= 0) {
                this.endGame();
                break;
            }
            System.out.println("------------------------------------------------");
            ConsoleCommands.clearConsole();
        }

        Result result = new Result(player.getName(), player.getPlayerPoints());
        Ratings.addResult(result);
        Ratings.writeToRatingsFile(map.getTitle(), diff);
    }

    /**
     * Method to ask the player for their next move and execute the move
     *
     * @throws IOException
     * @throws EmptyCollectionException
     */
    private void nextMove() throws IOException, EmptyCollectionException {
        System.out.println("Introduza o nome da sala onde deseja ir: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Iterator<Room> connectedRoomsItr = player.getCurrentRoom().getConnectionsIterator();
        Room selectedRoom = null;
        boolean found = false;

        while (connectedRoomsItr.hasNext() && !found) {
            Room tmpRoom = connectedRoomsItr.next();
            if (tmpRoom.getRoomName().equalsIgnoreCase(input)) {
                selectedRoom = tmpRoom;
                found = true;
            }
        }

        if (found) {
            player.makeMove(selectedRoom);
            player.setPlayerPoints(player.getPlayerPoints() - (diff * selectedRoom.getGhostCost()));
        } else {
            System.out.println("Escolha inválida.");
        }
    }


    private void askFlashback() throws IOException {
        System.out.println("Deseja usar um flashback?(S/N)");
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            System.out.println("Flashbacks Disponívies : " + player.getNumberOfFlashBacks());
            System.out.println("------------------------------------------------");

            if (input.equalsIgnoreCase("S")) {
                try {
                    player.useFlashBack(diff);
                    ConsoleCommands.clearConsole();
                    System.out.println("Posição Atual: " + player.getCurrentRoom().toString(true));
                    this.showPlayerPoints();
                    System.out.println("Flashbacks Disponívies : " + player.getNumberOfFlashBacks());
                    System.out.println("------------------------------------------------");
                    System.out.println("Deseja usar um flashback?(S/N) outra vez");
                    continue;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("------------------------------------------------");
                    break;
                }
            } else if (input.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("Input Inválido.");
        }
    }

    /**
     * Method to print the end message of the game depending on the result
     *
     * @throws EmptyCollectionException
     */
    private void endGame() throws EmptyCollectionException {
        ConsoleCommands.clearConsole();
        if (player.getPlayerPoints() <= 0) {
            System.out.println("\nFinal do jogo. Perdeu todos os pontos de vida. \n");
            player.setPlayerPoints(0);
        } else if (player.getCurrentRoom().getRoomName().equalsIgnoreCase(Map.EXIT)) {
            System.out.println("\nFinal do jogo. Pontuação Final : " + this.player.getPlayerPoints() + "\n");
        }
    }

    /**
     * Method used to show the current player
     * points
     */
    private void showPlayerPoints() {
        System.out.println("Pontuação Atual: " + player.getPlayerPoints());
    }
}
