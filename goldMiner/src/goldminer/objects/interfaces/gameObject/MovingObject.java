/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.interfaces.gameObject;

import goldminer.objects.interfaces.gameObject.StaticObject;
import goldminer.game.enums.MovingDirection;
import goldminer.objects.common.AbstractGameMap;
import javax.swing.ImageIcon;
import goldminer.objects.common.AbstractGameObject;
/**
 *
 * @author lakobib
 */
public interface MovingObject extends StaticObject{
    
    void move (MovingDirection direction, AbstractGameMap abstractGameMap);
    
    void GameMoveResult (AbstractGameObject objectInNewCoordinate);
    
    
}
