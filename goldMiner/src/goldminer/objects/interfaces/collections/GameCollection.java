package goldminer.objects.interfaces.collections;

import goldminer.game.enums.GameObjectType;
import goldminer.game.enums.MovingDirection;
import goldminer.game.movestreategies.MoveStrategy;
import goldminer.objects.Coordinates;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.listeners.MoveResultNotifier;
import java.util.List;

public interface GameCollection extends MoveResultNotifier{
    
    AbstractGameObject getObjectByCoordinate(Coordinates coordinate);
    
    AbstractGameObject getObjectByCoordinate(int x, int y);
    
    void addGameObject(AbstractGameObject gameObject);
    
    List<AbstractGameObject> getAllGameObjects();
    
    List<AbstractGameObject> getObjectsByType(GameObjectType type);
    
    void moveObject(MovingDirection direction, GameObjectType gameObjectType);
    
    void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType);
}
