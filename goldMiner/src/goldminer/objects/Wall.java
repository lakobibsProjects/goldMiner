/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects;

import goldminer.game.enums.GameObjectType;
import goldminer.objects.Coordinates;
import goldminer.objects.interfaces.gameObject.StaticObject;
import goldminer.objects.common.AbstractGameObject;

/**
 *
 * @author lakobib
 */
public class Wall extends AbstractGameObject {
    
    public Wall (Coordinates coordinate){
        super.setType(GameObjectType.WALL);
        super.setIcon(getImageIcon("/goldminer/images/wall.png"));
        super.setCoordinates(coordinate);
    } 

}
