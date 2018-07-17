/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.gui.map;


import goldminer.game.enums.GameObjectType;
import goldminer.game.enums.LocationType;
import goldminer.objects.Coordinates;
import goldminer.objects.Nothing;
import goldminer.objects.Wall;
import goldminer.objects.common.AbstractGameMap;
import goldminer.objects.common.AbstractGameObject;
import goldminer.objects.creator.MapCreator;
import goldminer.objects.interfaces.collections.GameCollection;
import goldminer.objects.interfaces.gameMap.DrawableMap;
import goldminer.objects.map.ImageRenderer;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


/**
 *
 * @author lakobib
 */
public class JTableGameMap implements DrawableMap{
    
    private JTable jTableMap = new JTable();
    
    private AbstractGameMap gameMap;
    
    private String[] columnNames;
    
    private AbstractGameObject[][] mapObject;
    
    public JTableGameMap (LocationType type, Object source, GameCollection gameCollection){
        jTableMap.setEnabled(false);
        jTableMap.setSize(300, 300);
        jTableMap.setRowHeight(28);
        jTableMap.setRowSelectionAllowed(false);
        jTableMap.setShowHorizontalLines(false);
        jTableMap.setShowVerticalLines(false);
        jTableMap.setTableHeader(null);
        jTableMap.setUpdateSelectionOnSort(false);
        jTableMap.setVerifyInputWhenFocusTarget(false);
        
        gameMap = MapCreator.getInstance().CreateMap(type, gameCollection);
        gameMap.loadGame(source);
        
        updateObjectArray();
    }
    
    private void fillEmptyMap(int width, int height){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                mapObject[i][j] = new Nothing(new Coordinates(i,j));
            }
        }
    }
    
    





    private void updateObjectArray() {
        mapObject = new AbstractGameObject[gameMap.getHeight()][gameMap.getWidth()];
        
        fillEmptyMap ((gameMap.getHeight()),(gameMap.getWidth()));
        
        for (AbstractGameObject gameObject : gameMap.getGameCollection().getAllGameObjects()) {
            if (!gameObject.getObjectType().equals(GameObjectType.NOTHING)) {
                int y = gameObject.getCoordinates().getY();
                int x = gameObject.getCoordinates().getX();
                if (!(mapObject[y][x]instanceof Nothing) & !(mapObject[y][x]instanceof Wall)) {
                    AbstractGameObject tempObject = mapObject[y][x];
                    mapObject[y][x] = gameMap.getPriorityObject(tempObject, gameObject);
                }else{
                    mapObject [y][x] = gameObject;
                }                
            }
        }                                
    }
    
    @Override
    public boolean drawMap() {
        
        updateObjectArray();
        try{
        
            columnNames = new String[gameMap.getWidth()];

            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = "";
            }

            jTableMap.setModel(new DefaultTableModel(mapObject, columnNames));

            for (int i = 0; i < jTableMap.getColumnCount(); i++) {
                jTableMap.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
                TableColumn a = jTableMap.getColumnModel().getColumn(i);
                a.setPreferredWidth(15);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public AbstractGameMap getMap() {
        return gameMap;
    }

    @Override
    public Component getMapComponent() {
         return jTableMap;
    }
}
