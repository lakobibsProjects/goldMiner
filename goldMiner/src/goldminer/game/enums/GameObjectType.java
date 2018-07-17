/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.game.enums;

import java.io.Serializable;

/**
 *
 * @author lakobib
 */
public enum GameObjectType implements Serializable {
    
    NOTHING(-1),
    GOLDMAN(1),
    WALL(2),
    EXIT(3),
    TREASURE(4),
    MONSTER(5);
    
    private int indexOfPriority;
    
    private GameObjectType(int indexOfPriority){
        this.indexOfPriority = indexOfPriority;
    }
    
    public int getIndexOfPriority(){
        return indexOfPriority;
    }
    
    
    
}
