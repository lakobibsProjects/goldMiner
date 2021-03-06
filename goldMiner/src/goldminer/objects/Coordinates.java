/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects;

/**
 *
 * @author lakobib
 */
public class Coordinates {
    
    private int x;
    private int y;
    
    public Coordinates (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setXY(int x, int y){
                this.x = x;
        this.y = y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getX(){
        return x;
    }
    public void setY (int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    
    @Override
    public String toString(){
        return "x=" + x + ", y=" + y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
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
        final Coordinates other = (Coordinates) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
     
}
