/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.map;

import goldminer.game.enums.ActionResult;
import goldminer.game.enums.GameObjectType;
import goldminer.game.enums.MovingDirection;
import goldminer.objects.Coordinates;
import goldminer.objects.Nothing;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.common.AbstractMovingObject;
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

    @Override
    public ActionResult moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        
        ActionResult actionResult = null;
        
        for (AbstractGameObject gameObject : this.getObjectsByType(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;
                
                Coordinates newCoordinates = getNewCoordinates(direction, movingObject);
                
                AbstractGameObject objectInNewCoordinates = getObjectByCoordinate(newCoordinates);
                
                actionResult = movingObject.moveToObject(direction, objectInNewCoordinates);
                
                switch (actionResult){
                    case MOVE:{
                        swapObjects(movingObject, objectInNewCoordinates);
                        break;
                    }
                    case COLLECT_TREASURE:{
                        swapObjects(movingObject, new Nothing(newCoordinates));
                        break;
                    }
                }
            }
        }
        
        return actionResult;
    }
    
    private void swapObjects(AbstractGameObject object1, AbstractGameObject object2){
        swapCoordinates(object1, object2);
        
        gameObjects.put(object1.getCoordinates(), object1);
        gameObjects.put(object2.getCoordinates(), object2);
    }
    
    private void swapCoordinates(AbstractGameObject object1, AbstractGameObject object2){
        Coordinates tempCoordinates = object1.getCoordinates();
        object1.setCoordinates(object2.getCoordinates());
        object2.setCoordinates(tempCoordinates);
    }
    
    private Coordinates getNewCoordinates(MovingDirection direction, AbstractMovingObject movingObject){
        
        int x = movingObject.getCoordinates().getX();
        int y = movingObject.getCoordinates().getY();
        
        Coordinates newCoordinate = new Coordinates(x,y);
        
        switch(direction){
            case UP:{
                newCoordinate.setY(y-movingObject.getStep());
                break;
            }
        
            case DOWN:{
                newCoordinate.setY(y+movingObject.getStep());
                break;
            }
            case LEFT:{
                newCoordinate.setX(x-movingObject.getStep());
                break;
            }
            case RIGHT:{
                newCoordinate.setX(x+movingObject.getStep());
                break;
            }
        }
        return newCoordinate;
    }
}
