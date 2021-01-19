package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.MapExceptions;
import Structures.BinaryTree.BinaryTreeExceptions;
import Structures.Graph.GraphExceptions;
import Structures.Lists.ListExceptions;
import Structures.Stack.EmptyCollectionException;

import java.io.IOException;

/**
 * interface with methods that are used in both
 * Manual and Simulation
 *
 * @author Pedro Machado "pedroma2000"
 */
public interface Game {

    /**
     * Method used to start the game
     * @throws BinaryTreeExceptions BinaryTreeExceptions
     * @throws GraphExceptions GraphExceptions
     * @throws ListExceptions ListExceptions
     * @throws IOException IOException
     * @throws MapExceptions MapExceptions
     * @throws EmptyCollectionException EmptyCollectionException
     */
    public void startGame() throws BinaryTreeExceptions, GraphExceptions, ListExceptions, IOException, MapExceptions, EmptyCollectionException;

}
