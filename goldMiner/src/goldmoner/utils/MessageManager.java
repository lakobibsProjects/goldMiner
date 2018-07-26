/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldmoner.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author lakobib
 */
public class MessageManager {
    
    public static void showInformMessage (Component comp, String message){
        JOptionPane.showMessageDialog(comp, message, "Messege Dialog", JOptionPane.PLAIN_MESSAGE);
    }
    
}
