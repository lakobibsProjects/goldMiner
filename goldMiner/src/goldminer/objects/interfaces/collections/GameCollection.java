/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.interfaces.collections;

import goldminer.game.enums.GameObjectType;
import goldminer.objects.Coordinates;
import goldminer.objects.common.AbstractGameObject;
import java.util.List;

/**
 *
 * @author lakobib
 */
public interface GameCollection {
    
    AbstractGameObject getObjectByCoordinate(Coordinates coordinate);
    
    AbstractGameObject getObjectByCoordinate(int x, int y);
    
    void addGameObject(AbstractGameObject gameObject);
    
    List<AbstractGameObject> getAllGameObjects();
    
    List<AbstractGameObject> getObjectsByType(GameObjectType type);
    
}
