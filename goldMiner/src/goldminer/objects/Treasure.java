/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects;

import goldminer.game.enums.GameObjectType;
import goldminer.objects.common.AbstractGameObject;

/**
 *
 * @author lakobib
 */
public class Treasure extends AbstractGameObject{
    
    private int score = 5;
    
    public Treasure (Coordinates coordinate){
        super.setType(GameObjectType.TREASURE);
        super.setIcon(getImageIcon("/goldminer/images/gold.png"));
        super.setCoordinates(coordinate);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
