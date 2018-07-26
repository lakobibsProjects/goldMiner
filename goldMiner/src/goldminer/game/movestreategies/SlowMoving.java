
package goldminer.game.movestreategies;

import goldminer.game.enums.MovingDirection;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.common.AbstractMovingObject;
import goldminer.objects.interfaces.collections.GameCollection;
import java.util.Random;

/**
 *
 * @author lakobib
 */
public class SlowMoving implements MoveStrategy {

    @Override
    public MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection) {
        
         MovingDirection direction = null;
        
        int characterX = targetObject.getCoordinates().getX();
        int characterY = targetObject.getCoordinates().getY();
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
    }
    
}
