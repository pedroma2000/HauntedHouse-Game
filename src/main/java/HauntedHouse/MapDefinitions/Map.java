package HauntedHouse.MapDefinitions;

import HauntedHouse.Generated;
import Structures.BinaryTree.BinaryTreeExceptions;
import Structures.Graph.GraphExceptions;
import Structures.Lists.ListExceptions;
import Structures.Lists.UnorderedArray;
import Structures.Lists.UnorderedListADT;
import Structures.Network.NetworkADT;
import Structures.Network.NetworkInList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Map definition class
 *
 * @author Pedro Machado "pedroma2000"
 */
public class Map {

    public static final String ENTRANCE = "entrada";
    public static final String EXIT = "exterior";
    private String title;
    private int points;
    private NetworkADT<Room> networkMap;
    private UnorderedListADT<Room> addedRooms;
    private Room entrance;
    private Room exit;

    /**
     * Default Construtor
     *
     * @param title  name of map
     * @param points Points
     */
    public Map(String title, int points) {
        this.title = title;
        this.points = points;
        this.networkMap = new NetworkInList<>();
        this.addedRooms = new UnorderedArray<>();
        this.entrance = new Room(ENTRANCE, 0);
        this.exit = new Room(EXIT, 0);
        this.networkMap.addVertex(entrance);
        this.networkMap.addVertex(exit);
        this.addedRooms.addToRear(entrance);
        this.addedRooms.addToRear(exit);
    }

    /**
     * Method to obtain the name of the map
     *
     * @return title
     */
    @Generated
    public String getTitle() {
        return title;
    }

    /**
     * Method to obtain the aumount of points of the map
     *
     * @return points
     */
    @Generated
    public int getPoints() {
        return points;
    }

    /**
     * @return the entrance of the map
     */
    @Generated
    public Room getEntrance() {
        return entrance;
    }

    /**
     * Method for adding rooms to the map
     * @param roomName the room name
     * @param ghostCost the ghost cost
     */
    public void addRoomToMap(String roomName, int ghostCost) {
        Room room = new Room(roomName, ghostCost);
        networkMap.addVertex(room);
        addedRooms.addToRear(room);
    }

    /**
     * Method for adding connections between rooms
     *
     * @param source      connection starting point
     * @param destination connection arrival point
     * @throws MapExceptions MapExceptions
     * @throws GraphExceptions GraphExceptions
     */
    public void addConnectionsBetweenRooms(String source, String destination) throws MapExceptions, GraphExceptions {
        Room sourceRoom = getRoomFromName(source);
        Room destRoom = getRoomFromName(destination);

        sourceRoom.addConnection(destRoom);
        networkMap.addEdge(sourceRoom, destRoom, destRoom.getGhostCost());

        if (destRoom.getRoomName().equals(ENTRANCE) && destRoom.numberOfDoors() == 0) {
            destRoom.addConnection(sourceRoom);
            networkMap.addEdge(destRoom, sourceRoom, sourceRoom.getGhostCost());
        } else if (destRoom.getRoomName().equals(EXIT)) {
            destRoom.addConnection(sourceRoom);
            networkMap.addEdge(destRoom, sourceRoom, sourceRoom.getGhostCost());
        }
    }

    /**
     * Method to find the room by name
     *
     * @param roomName room name
     * @return Room room
     * @throws MapExceptions MapExceptions if room not loaded
     */
    public Room getRoomFromName(String roomName) throws MapExceptions {
        boolean found = false;
        Room room = null;
        Iterator<Room> searchItr = addedRooms.iterator();

        while (!found && searchItr.hasNext()) {
            Room tmp = searchItr.next();
            if (tmp.getRoomName().equals(roomName)) {
                room = tmp;
                found = true;
                break;
            }
        }

        if (found == false) {
            throw new MapExceptions(MapExceptions.ROOM_NOT_LOADED);
        }

        return room;
    }

    /**
     * Method to obtain the list of rooms of the map
     *
     * @return List of Rooms In Map
     */
    @Generated
    public Iterator<Room> getAddedRoomsIterator() {
        return addedRooms.iterator();
    }

    /**
     * Method to print the map form a certain Room
     *
     * @param room      room
     * @param viewGhost boolean to view ghosts
     * @throws MapExceptions MapExceptions
     * @throws IOException IOException
     */
    @Generated
    public void printMapFromRoom(String room, boolean viewGhost) throws MapExceptions, IOException {
        Room startRoom = getRoomFromName(room);
        Iterator<Room> path = networkMap.iteratorBFS(startRoom);

        Room currentRoom = path.next();
        System.out.println("Sala Atual : " + currentRoom.toString(viewGhost));

        while (true) {
            System.out.println("------------------------------------------------\n");
            System.out.println("Deseja ver o resto do mapa ?(S/N)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            System.out.println("------------------------------------------------");

            if (input.equalsIgnoreCase("S")) {
                while (path.hasNext()) {
                    System.out.println("\n------------------------------------------------");
                    currentRoom = path.next();
                    System.out.println("Sala : " + currentRoom.toString(viewGhost));
                    System.out.println("------------------------------------------------");
                }
                break;
            } else if (input.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("Input Inválido.");
        }
    }

    /**
     * Method to show the path with least cost
     *
     * @return Iterador
     * @throws BinaryTreeExceptions BinaryTreeExceptions
     * @throws GraphExceptions GraphExceptions
     * @throws ListExceptions ListExceptions
     */
    @Generated
    public Iterator<Room> bestPathForMapIterator() throws BinaryTreeExceptions, GraphExceptions, ListExceptions {
        return networkMap.iteratorShortestPath(entrance, exit);
    }
}
