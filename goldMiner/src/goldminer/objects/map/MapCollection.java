package goldminer.objects.map;

import goldminer.game.enums.ActionResult;
import goldminer.game.enums.GameObjectType;
import goldminer.game.enums.MovingDirection;
import goldminer.game.movestreategies.MoveStrategy;
import goldminer.objects.Coordinates;
import goldminer.objects.Miner;
import goldminer.objects.Nothing;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.common.AbstractMovingObject;
import goldminer.objects.listeners.MapListenersRegistrator;
import goldminer.objects.listeners.MoveResultListener;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class MapCollection extends MapListenersRegistrator {
    
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
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        doMoveAction(direction,gameObjectType,null);

    }
      
    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null,gameObjectType,moveStrategy);
    }
    
    private void doMoveAction(MovingDirection direction, GameObjectType objectType, MoveStrategy movingStrategy){
        Miner miner  = (Miner)  getObjectsByType(GameObjectType.GOLDMAN).get(0);
        
        ActionResult actionResult = null;
        
        for (AbstractGameObject gameObject : this.getObjectsByType(objectType)) {
            if (gameObject instanceof AbstractMovingObject) {
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;
                
                if (movingStrategy != null) {
                    direction = movingStrategy.getDirection(movingObject, miner, this);
                }
                
                Coordinates newCoordinates = movingObject.getNewCoordinates(direction);
                
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
                    case WIN:{
                        
                    }
                    case DIE:{
                        break;
                    }
                }
            }
            notifyListeners(actionResult, miner);
        }
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
    
/*    private Coordinates getNewCoordinates(MovingDirection direction, AbstractMovingObject movingObject){
        
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

    @Override
    public void moveObjectRandom(GameObjectType gameObjectType) {
        moveObject(null, gameObjectType);
    }*/

    @Override
    public void notifyListeners(ActionResult result, Miner miner) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifiActionResult(result, miner);
        }
    }

/*    private MovingDirection getRandomMoveDirection(AbstractMovingObject movingObject) {
        
        Miner miner = (Miner) getObjectsByType(GameObjectType.GOLDMAN).get(0);
       
        MovingDirection direction = null;
        
        int characterX = miner.getCoordinates().getX();
        int characterY = miner.getCoordinates().getY();
        int monsterX = movingObject.getCoordinates().getX();
        int monsterY = movingObject.getCoordinates().getY();
        int number = getRandomInt(2);
        
        if (number == 1) {
            number = getRandomInt(2);
            switch (number){
                case 1:{
                    if (monsterX>characterX) {
                        direction = MovingDirection.LEFT;
                    }else{
                        direction = MovingDirection.RIGHT;
                    }
                }
                case 2:{
                    if (monsterY>characterY) {
                        direction = MovingDirection.UP;
                    }else{
                        direction = MovingDirection.DOWN;
                    }
                }
            }
        }else{
            number = getRandomInt(2);
            switch (number){
                case 1:{
                    if (monsterX>characterX) {
                        direction = MovingDirection.RIGHT;
                    }else{
                        direction = MovingDirection.LEFT;
                    }
                }
                case 2:{
                    if (monsterY>characterY) {
                        direction = MovingDirection.DOWN;
                    }else{
                        direction = MovingDirection.UP;
                    }
                }
            }
        }
        
        return direction;
    }

    private int getRandomInt(int i) {
        Random r = new Random();
        return r.nextInt(i)+1;
    }*/



}
