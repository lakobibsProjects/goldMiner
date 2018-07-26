/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.listeners;

import goldminer.objects.interfaces.collections.GameCollection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lakobib
 */
public abstract class MapListenersRegistrator implements GameCollection{
    
    private ArrayList <MoveResultListener> listeners = new ArrayList<>();
    
    @Override
    public List<MoveResultListener> getMoveListeners(){
        return listeners;
    }
    
    @Override
    public void AddMoveListener(MoveResultListener listener){
        listeners.add(listener);
    }
    
    @Override
    public void removeMoveListener(MoveResultListener listener){
        listeners.remove(listener);
    }
    
    @Override
    public void removeAllListeners(){
        listeners.clear();
    }
}
