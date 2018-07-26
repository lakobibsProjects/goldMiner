/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.common;

import goldminer.game.enums.ActionResult;
import goldminer.game.enums.GameObjectType;
import goldminer.game.enums.MovingDirection;
import goldminer.objects.Coordinates;
import goldminer.objects.interfaces.collections.GameCollection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import goldminer.objects.interfaces.gameMap.GameMap;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lakobib
 */
public abstract class AbstractGameMap implements GameMap, Serializable{
    
    private static final long SERIALVERSIONID = 1L;
    
    private int width;
    private int height;
    private int timeLimit;
    
    private String Name;
    
    private boolean isExitExist;
    private boolean isGoldminerExist;
    
    private GameCollection gameCollection;
    
   // private HashMap<Coordinates, AbstractGameObject> gameObjects = new HashMap<>();
   // private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);
    
    /*public void addGameObject(AbstractGameObject object){
        ArrayList<AbstractGameObject> tempList = typeObjects.get(object);
        
        if (tempList == null) {
            tempList = new ArrayList<>();
        }
        
        tempList.add(object);
        
        gameObjects.put(object.getCoordinates(), object);
        typeObjects.put(object.getObjectType(), tempList);        
    }
*/
    
    public AbstractGameMap(GameCollection gameCollection){
        this.gameCollection = gameCollection;
    }

    public GameCollection getGameCollection() {
        if (gameCollection == null) {
            try {
                new Exception ("Collection is not initialized");
            } catch (Exception ex){
                Logger.getLogger(AbstractGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gameCollection;
    }

    public void setGameCollection(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isIsExitExist() {
        return isExitExist;
    }

    public void setIsExitExist(boolean isExitExist) {
        this.isExitExist = isExitExist;
    }

    public boolean isGoldminerExist() {
        return isGoldminerExist;
    }

    public void setIsGoldminerExist(boolean isGoldminerExist) {
        this.isGoldminerExist = isGoldminerExist;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject){
        return (firstObject.getObjectType().getIndexOfPriority() > secondObject.getObjectType().getIndexOfPriority()) ? firstObject : secondObject;
    }
    
    public boolean isMapValid(){
        return isExitExist && isGoldminerExist;
    }
    
    
    
 /*   public ArrayList <AbstractGameObject>  getObjectsByType(GameObjectType type){
        return typeObjects.get(type);
    }
    
    
    public AbstractGameObject getObjectByCoordinate (Coordinates coordinate){
        return gameObjects.get(coordinate);
    }
    
    public AbstractGameObject getObjectByCoordinate (int x, int y){
        return gameObjects.get(new Coordinates (x, y));
    }
    
    public Collection <AbstractGameObject> getAllGameObject(){
        return gameObjects.values();
  }
*/

/*    public ActionResult move(MovingDirection movingDirection, GameObjectType gameObjectType) {
        for (AbstractGameObject gameObject : getGameCollection().getObjectsByType(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) { //need fix
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;
                movingObject.move(movingDirection, this);
            }
        }
        return getGameCollection().moveObject(movingDirection, gameObjectType);
    }*/
}
