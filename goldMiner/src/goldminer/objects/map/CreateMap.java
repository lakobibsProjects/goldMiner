/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.map;

import goldminer.game.enums.GameObjectType;
import static goldminer.game.enums.GameObjectType.EXIT;
import goldminer.objects.Coordinates;
import goldminer.objects.common.AbstractGameMap;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.creator.GameObjectCreator;
import goldminer.objects.interfaces.collections.GameCollection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lakobib
 */
public class CreateMap extends AbstractGameMap {

    public CreateMap(GameCollection gameCollection) {
        super(gameCollection);
    }

    @Override
    public int hight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int wight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveGame(Object source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadGame(Object source) {
        File file = new File(source.toString());
        if (!file.exists()) {
            throw new IllegalArgumentException("filename must not be empty");
        }
        
        try{
            setIsExitExist(false);
            setIsGoldminerExist(false);
            
            setHeight(getLineCount(file));
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String strLine = br.readLine().trim();

            setName(strLine.split(",")[0]);
            
            
            setTimeLimit(Integer.valueOf(strLine.split(",")[1]).intValue());
            setWidth(Integer.valueOf(strLine.split(",")[2]).intValue()); //[2]
            
            int x = 0;
            int y = 0;
            
            while((strLine = br.readLine())!=null){
                x = 0;
                for (String str : strLine.split(",")) {
                    createGameObject(str, new Coordinates (x,y));
                    x++;
                }
                y++;
            }
            
            if (!isMapValid()) {
                throw new Exception ("Map is not valid");
            }
            
        }catch (Exception e){
             e.printStackTrace();
        }
        return true;        
    } 
    private void createGameObject(String str, Coordinates coordinate){
        GameObjectType type = GameObjectType.valueOf(str.toUpperCase());
        
        AbstractGameObject newObject = GameObjectCreator.getInstance().createObject(type, coordinate);
        
        getGameCollection().addGameObject(newObject);
        
        if (newObject.getObjectType() == GameObjectType.EXIT) {
            setIsExitExist(true);
        } else{
            if (newObject.getObjectType() == GameObjectType.GOLDMAN) {
                setIsGoldminerExist(true);
            }
        }
    }

    @Override
    public int timeLimit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int getLineCount(File file) throws FileNotFoundException {
        BufferedReader reader = null;
        int lineCount = 0;
        
        try{
            reader = new BufferedReader(new FileReader(file));
            
            while (reader.readLine()!=null){
                lineCount++;
            }
            lineCount--;
        } catch (IOException ex) {
            Logger.getLogger(CreateMap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lineCount;
    }
    
}
