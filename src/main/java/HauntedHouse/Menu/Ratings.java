package HauntedHouse.Menu;

import HauntedHouse.Generated;
import Structures.Lists.ListExceptions;
import Structures.Lists.OrderedList;
import Structures.Lists.OrderedListADT;

import java.io.*;
import java.util.Iterator;

/**
 * ratings class
 *
 * @author Pedro Machado "pedroma2000"
 */
@Generated
public class Ratings {

    /**
     * result list of a game
     */
    private static OrderedListADT<Result> resultList = new OrderedList();

    /**
     * add a player result to the result list
     *
     * @param res the player results
     * @throws ListExceptions ListExceptions
     */
    public static void addResult(Result res) throws ListExceptions {
        resultList.add(res);
    }

    /**
     * Writes Ratings to files,
     * if the file doesnt exist, create a new one
     *
     * @param mapTitle   map title
     * @param difficulty game difficulty
     */
    public static void writeToRatingsFile(String mapTitle, int difficulty) {
        try {
            String filename = "";

            String difficultyID = "";

            if (difficulty == 1) {
                filename = mapTitle + "Easy.txt";
                difficultyID = "Easy";
            } else if (difficulty == 2) {
                filename = mapTitle + "Medium.txt";
                difficultyID = "Medium";
            } else if (difficulty == 3) {
                filename = mapTitle + "Hard.txt";
                difficultyID = "Hard";
            }

            // Create new file
            String path = "ratings/" + filename;
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(mapTitle);
            bw.write(" - ");
            bw.write(difficultyID);
            bw.newLine();

            Iterator<Result> resultListItr = resultList.iterator();

            while (resultListItr.hasNext()) {

                Result tmpRes = resultListItr.next();

                bw.append(tmpRes.playerName + " - Points :"
                        + tmpRes.playerPoints);
                bw.newLine();
            }


            bw.close();

        } catch (Exception e) {
            System.out.println("Operação inválida");
        }
    }

    /**
     * prints the ratings of a map to the screen
     * @param mapTitle the map title
     * @param difficulty the game difficulty
     */
    public static void PrintRatingFile(String mapTitle, int difficulty) {
        try {

            String filename = mapTitle;

            if (difficulty == 1) {
                filename += "Easy.txt";
            } else if (difficulty == 2) {
                filename += "Medium.txt";
            } else if (difficulty == 3) {
                filename += "Hard.txt";
            }

            BufferedReader br = new BufferedReader(new FileReader(filename));
            for (String line; (line = br.readLine()) != null; ) {
                System.out.println(line);

            }

            br.close();

        } catch (Exception e) {
            System.out.println("ficheiro não encontrado");
        }
    }
}
