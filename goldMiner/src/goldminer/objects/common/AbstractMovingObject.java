/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.common;

import static goldminer.game.enums.GameObjectType.NOTHING;
import goldminer.game.enums.MovingDirection;
import static goldminer.game.enums.MovingDirection.UP;
import goldminer.objects.Coordinates;
import javax.swing.ImageIcon;
import goldminer.objects.interfaces.gameObject.MovingObject;

/**
 *
 * @author lakobib
 */
public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {
    
    public abstract void changeIcon (MovingDirection direction);
    
    
/*    @Override
    public void move (MovingDirection direction){
         int x = this.getCoordinates().getX();
         int y = this.getCoordinates().getY();
         
         Coordinates newCoordinates = new Coordinates (x,y);
         
         switch (direction){
             case UP:{
                 super.setIcon(getUpIcon());
                 newCoordinates.setXY(x, y-1);
                 break;        
             }
             case DOWN:{
                 super.setIcon(getDownIcon());
                 newCoordinates.setXY(x, y+1);
                 break;        
             }
             case LEFT:{
                 super.setIcon(getLeftIcon());
                 newCoordinates.setXY(x-1, y);
                 break;        
             }
             case RIGHT:{
                 super.setIcon(getRightIcon());
                 newCoordinates.setXY(x+1, y);
                 break;        
             }
                 
         }
         
         setCoordinates(newCoordinates);
    }*/

    public void move(MovingDirection movingDirection, AbstractGameMap gameMap) {
        Coordinates newCoordinate  = getNewCoordinates(movingDirection);
        
        AbstractGameObject objectInNewCoordinates = gameMap.getGameCollection().getObjectByCoordinate(newCoordinate);
        
        switch  (objectInNewCoordinates.getObjectType()){
            case NOTHING:{
                changeIcon(movingDirection);
                setCoordinates(newCoordinate);
                
            }
            
            default :{
                
            }
        }
    }
    
    public Coordinates getNewCoordinates(MovingDirection direction){
        int x = this.getCoordinates().getX();
         int y = this.getCoordinates().getY();
         
         Coordinates newCoordinates = new Coordinates (x,y);
         
         switch (direction){
             case UP:{
                 //super.setIcon(getUpIcon());
                 newCoordinates.setXY(x, y-1);
                 break;        
             }
             case DOWN:{
                 //super.setIcon(getDownIcon());
                 newCoordinates.setXY(x, y+1);
                 break;        
             }
             case LEFT:{
                 //super.setIcon(getLeftIcon());
                 newCoordinates.setXY(x-1, y);
                 break;        
             }
             case RIGHT:{
                 //super.setIcon(getRightIcon());
                 newCoordinates.setXY(x+1, y);
                 break;        
             }
                 
         }
         
         return newCoordinates;
    }
    
    
}
