package HauntedHouse.Menu;

import HauntedHouse.ConsoleCommands;
import HauntedHouse.Game.Difficulty;
import HauntedHouse.Game.Game;
import HauntedHouse.Game.Manual;
import HauntedHouse.Game.Simulation;
import HauntedHouse.Generated;
import HauntedHouse.MapDefinitions.Map;

import java.io.*;
import java.util.Scanner;

/**
 * Class with menu operations
 *
 * @author Pedro Machado "pedroma2000"
 */
@Generated
public class Menu {

    private Scanner keyboard = new Scanner(System.in);
    private String opt = "";
    private Game game;
    private Map map;

    /**
     * Game main menu
     *
     * @throws IOException IOException
     */
    public void mainMenu() throws IOException {
        boolean exit = false;

        while (!exit) {
            System.out.println("------------------------------------------------");
            System.out.println("1 - Jogar");
            System.out.println("2 - Consultar Classificações");
            System.out.println("3 - Sair");
            System.out.println("------------------------------------------------");
            System.out.println("Opção: ");
            opt = keyboard.nextLine();

            switch (opt) {
                case "1":
                    map = askMapPath();
                    if (map != null) {
                        chooseGameMenu();
                    }
                    break;
                case "2":
                    chooseDifficultyRatings(askMapRatings());
                    break;
                case "3":
                    exit = true;
                    ConsoleCommands.clearConsole();
                    break;
                default:
                    System.out.println("opção inválida");
                    break;
            }
        }
    }

    /**
     * Asks the user the game map path
     *
     * @return the game map
     */
    private Map askMapPath() {
        try {
            System.out.println("Introduza o caminho do mapa: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            MapFile mapFile = new MapFile();
            mapFile.loadMapFile(input);
            return mapFile.createMapStructure();
        } catch (Exception e) {
            System.out.println("Mapa Inválido");
            return null;
        }
    }

    /**
     * Asks the user what game type
     * he/she wants
     */
    private void chooseGameMenu() {
        boolean exit = false;
        ConsoleCommands.clearConsole();
        try {
            while (!exit) {
                System.out.println("------------------------------------------------");
                System.out.println("1 - Jogo Manual");
                System.out.println("2 - Simulação");
                System.out.println("3 - Voltar");
                System.out.println("------------------------------------------------");
                System.out.println("Opção: ");
                opt = keyboard.nextLine();

                switch (opt) {
                    case "1":
                        difficultyManual();
                        break;
                    case "2":
                        difficultySimulation();
                        break;
                    case "3":
                        exit = true;
                        ConsoleCommands.clearConsole();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * Asks the user the difficulty of
     * the game in manual and starts
     */
    private void difficultyManual() {
        boolean exit = false;
        ConsoleCommands.clearConsole();
        try {
            while (!exit) {
                System.out.println("------------------------------------------------");
                System.out.println("Escolha dificuldade: ");
                System.out.println("1 - Fácil");
                System.out.println("2 - Médio");
                System.out.println("3 - Difícil");
                System.out.println("4 - Voltar");
                System.out.println("------------------------------------------------");
                System.out.println("Opção: ");
                opt = keyboard.nextLine();

                switch (opt) {
                    case "1":
                        game = new Manual(map, Difficulty.EASY);
                        game.startGame();
                        break;
                    case "2":
                        game = new Manual(map, Difficulty.MEDIUM);
                        game.startGame();
                        break;
                    case "3":
                        game = new Manual(map, Difficulty.HARD);
                        game.startGame();
                        break;
                    case "4":
                        exit = true;
                        ConsoleCommands.clearConsole();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Asks the user the difficulty of
     * the game in simulation and starts
     */
    private void difficultySimulation() {
        boolean exit = false;
        ConsoleCommands.clearConsole();
        try {
            while (!exit) {
                System.out.println("------------------------------------------------");
                System.out.println("Escolha dificuldade: ");
                System.out.println("1 - Fácil");
                System.out.println("2 - Médio");
                System.out.println("3 - Difícil");
                System.out.println("4 - Voltar");
                System.out.println("------------------------------------------------");
                System.out.println("Opção: ");
                opt = keyboard.nextLine();

                switch (opt) {
                    case "1":
                        game = new Simulation(map, Difficulty.EASY);
                        game.startGame();
                        break;
                    case "2":
                        game = new Simulation(map, Difficulty.MEDIUM);
                        game.startGame();
                        break;
                    case "3":
                        game = new Simulation(map, Difficulty.HARD);
                        game.startGame();
                        break;
                    case "4":
                        exit = true;
                        ConsoleCommands.clearConsole();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Asks the map name which will be used to check ratings
     */
    private String askMapRatings() throws IOException {
        System.out.println("Introduza o nome do mapa: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        return input;
    }

    /**
     * Asks the user the ratings from various game
     * difficulties of the map
     */
    private void chooseDifficultyRatings(String name) {
        String path = "ratings/" + name;
        boolean exit = false;
      
        ConsoleCommands.clearConsole();
        while (!exit) {
            System.out.println("------------------------------------------------");
            System.out.println("Escolha a tabela de resultados da dificuldade que deseja: ");
            System.out.println("1 - Fácil");
            System.out.println("2 - Médio");
            System.out.println("3 - Difícil");
            System.out.println("4 - Voltar");
            System.out.println("------------------------------------------------");
            System.out.println("Opção: ");
            opt = keyboard.nextLine();

            switch (opt) {
                case "1":
                    Ratings.PrintRatingFile(path, 1);
                    break;
                case "2":
                    Ratings.PrintRatingFile(path, 2);
                    break;
                case "3":
                    Ratings.PrintRatingFile(path, 3);
                    break;
                case "4":
                    exit = true;
                    ConsoleCommands.clearConsole();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

}
