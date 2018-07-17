/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.map;

import goldminer.game.enums.GameObjectType;
import goldminer.objects.Coordinates;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.interfaces.collections.GameCollection;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lakobib
 */
public class MapCollection implements GameCollection {
    
    private HashMap<Coordinates, AbstractGameObject> gameObjects = new HashMap<>();
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);
    
    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinates coordinate) {
        return gameObjects.get(coordinate);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinates (x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {
         ArrayList<AbstractGameObject> tempList = typeObjects.get(gameObject);
        
        if (tempList == null) {
            tempList = new ArrayList<>();
        }
        
        tempList.add(gameObject);
        
        gameObjects.put(gameObject.getCoordinates(), gameObject);
        typeObjects.put(gameObject.getObjectType(), tempList);  
    }

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values()) ;
    }

    @Override
    public List<AbstractGameObject> getObjectsByType(GameObjectType type) {
        return typeObjects.get(type);
    }
    
}
