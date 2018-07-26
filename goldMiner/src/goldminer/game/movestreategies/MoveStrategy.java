/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.game.movestreategies;

import goldminer.game.enums.MovingDirection;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.common.AbstractMovingObject;
import goldminer.objects.interfaces.collections.GameCollection;

/**
 *
 * @author lakobib
 */
public interface MoveStrategy {
    MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection);
}
