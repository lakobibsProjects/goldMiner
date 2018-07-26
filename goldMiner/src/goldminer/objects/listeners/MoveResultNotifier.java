package goldminer.objects.listeners;

import goldminer.game.enums.ActionResult;
import goldminer.objects.Miner;
import java.util.List;

public interface MoveResultNotifier {
    
    List<MoveResultListener> getMoveListeners();
    
    void AddMoveListener(MoveResultListener listener);
    
    public void removeMoveListener (MoveResultListener listener);;
    
    public void removeAllListeners();
    
    public void notifyListeners(ActionResult result, Miner miner);
    
}
