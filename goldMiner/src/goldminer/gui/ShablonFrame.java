/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author lakobib
 */
public abstract class ShablonFrame extends JFrame {
    
    public ShablonFrame(){
        setCloseOperation();
    }
    
    private JFrame actualFrame;
    
    public JFrame getActualFrame(){
        return actualFrame;
    }
    
    protected void showFrame(JFrame actual){
        this.actualFrame = actual;
        actual.setVisible(false);
        super.setVisible(true);
    }
    
    protected void closeFrame (){
        if (actualFrame == null) {
             throw new IllegalArgumentException("actual frame must not be null!");
        }
        super.setVisible(false);
        actualFrame.setVisible(true);
    }
    
    protected void setCloseOperation(){
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        super.addWindowListener(new WindowAdapter(){
            public void windowClosing (WindowEvent e){
                closeFrame();
            }
        });
    }
    
    
}
