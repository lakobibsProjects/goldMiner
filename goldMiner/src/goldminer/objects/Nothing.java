/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects;

import goldminer.game.enums.GameObjectType;
import goldminer.objects.Coordinates;
import goldminer.objects.common.AbstractGameObject;

/**
 *
 * @author lakobib
 */
public class Nothing extends AbstractGameObject{
        
    public Nothing(Coordinates coordinate){
        super.setType(GameObjectType.NOTHING);
        super.setIcon(getImageIcon("/goldminer/images/nothing.bmp"));
        super.setCoordinates(coordinate);
    }    
}
