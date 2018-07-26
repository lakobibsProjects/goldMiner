/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.game.movestreategies;

import goldminer.game.enums.ActionResult;
import goldminer.game.enums.MovingDirection;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.common.AbstractMovingObject;
import goldminer.objects.interfaces.collections.GameCollection;
import java.util.Random;

/**
 *
 * @author lakobib
 */
public class AgressiveMoving implements MoveStrategy  {
    
    private MovingDirection[] directions = MovingDirection.values();
    private AbstractMovingObject movingObject;
    private GameCollection gameCollection;

    @Override
    public MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection) {
        this.movingObject = movingObject;
        this.gameCollection = gameCollection;
        
        MovingDirection direction = searchAction(ActionResult.DIE, false);
        
        if (direction == null) {
            direction = searchAction(ActionResult.MOVE, true);
        }
        return direction;
    }

    private MovingDirection searchAction(ActionResult actionResult, boolean random) {
        MovingDirection direction = null;
        
        if (random) {
            do {
                direction = getRandomDirection();
            } while (!checkActionResult(actionResult, direction));   
        }else{
            for (MovingDirection movingDirection : directions) {
                if (checkActionResult(actionResult, movingDirection)) {
                    direction = movingDirection;
                    break;
                }
            }
        }
        return direction;
    }

    private MovingDirection getRandomDirection() {
        return directions[new Random().nextInt(directions.length)];
    }

    private boolean checkActionResult(ActionResult actionResult, MovingDirection direction) {
        AbstractGameObject ObjectInNewCoordinate = gameCollection.getObjectByCoordinate(movingObject.getNewCoordinates(direction));
        return movingObject.doAction(ObjectInNewCoordinate).equals(actionResult);
    }
    
}
