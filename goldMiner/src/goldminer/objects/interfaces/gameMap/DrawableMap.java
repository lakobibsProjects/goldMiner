/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.interfaces.gameMap;

import goldminer.objects.common.AbstractGameMap;
import java.awt.Component;

/**
 *
 * @author lakobib
 */
public interface DrawableMap {
    
    Component getMapComponent();
    
    AbstractGameMap getMap();
    
    boolean drawMap();

}
