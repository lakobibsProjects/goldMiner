/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.interfaces.gameObject;

import javax.swing.ImageIcon;
import goldminer.objects.Coordinates;
import goldminer.game.enums.GameObjectType;

/**
 *
 * @author lakobib
 */
public interface StaticObject {
    
    ImageIcon getIcon();
    
    Coordinates getCoordinates();
    
    GameObjectType getObjectType();
    
    
    
}
