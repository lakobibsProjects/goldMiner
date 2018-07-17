/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.common;

import goldminer.objects.Coordinates;
import goldminer.objects.interfaces.gameObject.StaticObject;
import goldminer.game.enums.GameObjectType;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author lakobib
 */
public abstract class AbstractGameObject implements StaticObject{
    
    private GameObjectType type;
    private Coordinates coordinate;
    private ImageIcon icon = getImageIcon("/goldminer/images/noicon.png");
    
    protected AbstractGameObject(){
    }
    
    protected ImageIcon getImageIcon(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
    public void setIcon (ImageIcon currentIcon){
        this.icon = currentIcon;
    }    
    @Override
    public ImageIcon getIcon(){
        return icon;
    }
    
    public void setType(GameObjectType type){
        this.type = type;
    }
    
    @Override
    public GameObjectType getObjectType() {
        return type;
    }
    
    public void setCoordinates (Coordinates coordinate){
        this.coordinate = coordinate;
    }
    
    @Override
    public Coordinates getCoordinates(){
        return coordinate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.type);
        hash = 47 * hash + Objects.hashCode(this.coordinate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractGameObject other = (AbstractGameObject) obj;
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.coordinate, other.coordinate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


    
}
