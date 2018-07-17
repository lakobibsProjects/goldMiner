/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects;

import goldminer.game.enums.GameObjectType;
import goldminer.game.enums.MovingDirection;
import goldminer.objects.Coordinates;
import javax.swing.ImageIcon;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.common.AbstractMovingObject;

/**
 *
 * @author lakobib
 */
public class Monster extends AbstractMovingObject {
    
    public Monster (Coordinates coordinate){
        super.setCoordinates(coordinate);
        super.setType(GameObjectType.MONSTER);
             
        super.setIcon(getImageIcon("/goldminer/images/monster_left.jpg"));
        
    }
    

    @Override
    public void GameMoveResult(AbstractGameObject objectInNewCoordinate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction){
            case UP:{
                super.setIcon(getImageIcon("/goldminer/images/monster_up.jpg"));
                break;
            }
            case DOWN:{
                super.setIcon(getImageIcon("/goldminer/images/monster_down.jpg"));
                break;
            }
            case LEFT:{
                super.setIcon(getImageIcon("/goldminer/images/monster_left.jpg"));
                break;
            }     
            case RIGHT:{
                super.setIcon(getImageIcon("/goldminer/images/monster_right.jpg"));
                break;
            }      
        }
    }

}
