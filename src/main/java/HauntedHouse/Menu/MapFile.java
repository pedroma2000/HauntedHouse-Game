package HauntedHouse.Menu;

import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import Structures.Graph.GraphExceptions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

/**
 * Class with MapFile Operations
 *
 * @author Pedro Machado "pedroma2000"
 */
public class MapFile {

    private String name;
    private int points;
    private JSONArray map;
    private boolean mapLoaded;

    /**
     * Default Constructor
     */
    public MapFile() {
        mapLoaded = false;
    }

    /**
     * method that loads the map information
     * from a json file given a
     *
     * @param fileLocation file location
     * @return true if the map is loaded,
     * or false if it is invalid
     */
    public boolean loadMapFile(String fileLocation) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileLocation));
            JSONObject jsonObject = (JSONObject) obj;

            name = (String) jsonObject.get("nome");
            long pointLong = (long) jsonObject.get("pontos");
            points = Math.toIntExact(pointLong);

            map = (JSONArray) jsonObject.get("mapa");
            this.mapLoaded = true;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to know if the map has already been loaded
     *
     * @return boolean
     */
    public boolean isMapLoaded() {
        return mapLoaded;
    }

    /**
     * Method to create the network graph of the map
     *
     * @return Map
     * @throws MapFileExceptions MapFileExceptions
     * @throws GraphExceptions GraphExceptions
     * @throws MapExceptions MapExceptions
     */
    public Map createMapStructure() throws MapFileExceptions,
            GraphExceptions, MapExceptions {

        if (isMapLoaded() == false) {
            throw new MapFileExceptions(MapFileExceptions.MAP_NOT_LOADED);
        }
        Map chosenMap = new Map(name, points);
        Iterator<JSONObject> itrJSon = map.iterator();

        while (itrJSon.hasNext()) {
            JSONObject tmpObject = itrJSon.next();

            String roomName = (String) tmpObject.get("aposento");
            long ghostCostLong = (long) tmpObject.get("fantasma");
            int ghostCost = Math.toIntExact(ghostCostLong);

            chosenMap.addRoomToMap(roomName, ghostCost);
        }

        itrJSon = map.iterator();

        while (itrJSon.hasNext()) {
            JSONObject tmpObject = itrJSon.next();
            String source = (String) tmpObject.get("aposento");
            JSONArray destArray = (JSONArray) tmpObject.get("ligacoes");
            Iterator<String> itrDest = destArray.iterator();

            while (itrDest.hasNext()) {
                String dest = itrDest.next();
                chosenMap.addConnectionsBetweenRooms(source, dest);
            }
        }

        return chosenMap;
    }
}
