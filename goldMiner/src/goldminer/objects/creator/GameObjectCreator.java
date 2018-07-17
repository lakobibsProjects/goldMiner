/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.creator;

import goldminer.game.enums.GameObjectType;
import goldminer.objects.Monster;
import goldminer.objects.Coordinates;
import goldminer.objects.Exit;
import goldminer.objects.Miner;
import goldminer.objects.Nothing;
import goldminer.objects.Treasure;
import goldminer.objects.Wall;
import goldminer.objects.common.AbstractGameObject;

/**
 *
 * @author lakobib
 */
public class GameObjectCreator {
    private static GameObjectCreator instance;
    
    public static GameObjectCreator getInstance(){
        if (instance == null) {
            instance = new GameObjectCreator();
        }
        return instance;
    }
    
    public AbstractGameObject createObject (GameObjectType type, Coordinates coordinate){
        AbstractGameObject object = null;
        
        switch(type){
            case NOTHING:{
                object = new Nothing(coordinate);
                break;
            }
            case GOLDMAN:{
                object = new Miner(coordinate);
                break;
            }
            case WALL:{
                object = new Wall(coordinate);
                break;
            }
            case EXIT:{
                object = new Exit(coordinate);
                break;
            }
            case TREASURE:{
                object = new Treasure(coordinate);
                break;
            }
            case MONSTER:{
                object = new Monster(coordinate);
                break;
            }
            
            default:
                throw new IllegalArgumentException ("Can`t create object type: " + type);

        }
        
        return object;
    }
}
