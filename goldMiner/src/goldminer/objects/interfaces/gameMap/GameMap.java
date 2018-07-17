/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.interfaces.gameMap;

/**
 *
 * @author lakobib
 */
public interface GameMap {
    
    int hight();
    
    int wight();
        
    boolean saveGame(Object source);
    
    boolean loadGame(Object source);
    
    int timeLimit();
}
