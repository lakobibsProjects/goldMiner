/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.creator;

import goldminer.game.enums.LocationType;
import goldminer.objects.common.AbstractGameMap;
import goldminer.objects.interfaces.collections.GameCollection;
import goldminer.objects.map.CreateMap;

/**
 *
 * @author lakobib
 */
public class MapCreator {
    
    private static MapCreator instance;
    
    public static MapCreator getInstance(){
        if (instance == null) {
            instance = new MapCreator();
        }
        return instance;
    }
    
    public AbstractGameMap CreateMap (LocationType type, GameCollection collection){
        AbstractGameMap object = null;
        switch(type){
            case DATABASE:
                
                break;
            case FILESYSTEM:
                object = new CreateMap(collection);
                break;
            default:
                throw new IllegalArgumentException ("Can`t create map type: " + type);
        }
        return object;
    }
    
}
