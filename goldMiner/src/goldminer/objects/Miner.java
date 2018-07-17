/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects;

import goldminer.game.enums.GameObjectType;
import static goldminer.game.enums.GameObjectType.NOTHING;
import goldminer.game.enums.MovingDirection;
import goldminer.objects.common.AbstractGameMap;
import javax.swing.ImageIcon;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.common.AbstractMovingObject;

/**
 *
 * @author lakobib
 */
public class Miner extends AbstractMovingObject {
    
    private int totalScore = 0;
  
    private int turnNumber = 0;
    
    public Miner (Coordinates coordinate){
        super.setCoordinates(coordinate);
        super.setType(GameObjectType.GOLDMAN);
                
        super.setIcon(getImageIcon("/goldminer/images/goldman_left.png"));
    }
    
      public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
    

    @Override
    public void GameMoveResult(AbstractGameObject objectInNewCoordinate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction){
            case UP:{
                super.setIcon(getImageIcon("/goldminer/images/goldman_up.png"));
                break;
            }
            case DOWN:{
                super.setIcon(getImageIcon("/goldminer/images/goldman_down.png"));
                break;
            }
            case LEFT:{
                super.setIcon(getImageIcon("/goldminer/images/goldman_left.png"));
                break;
            }     
            case RIGHT:{
                super.setIcon(getImageIcon("/goldminer/images/goldman_right.png"));
                break;
            }
                    
        
        }
    }
    
    @Override
    public void move(MovingDirection direction, AbstractGameMap gameMap) {

        Coordinates newCoordinate = getNewCoordinates(direction);
        

        AbstractGameObject objectInNewCoordinate = gameMap.getGameCollection().getObjectByCoordinate(newCoordinate);

        switch (objectInNewCoordinate.getObjectType()) {

            case NOTHING: {
                changeIcon(direction);
                setCoordinates(newCoordinate);
            }
            case GOLDMAN:{
                changeIcon(direction);
                setCoordinates(newCoordinate);
            }

            default: {
            }

        }

    }

}
