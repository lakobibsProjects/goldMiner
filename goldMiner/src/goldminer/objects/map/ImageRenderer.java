/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldminer.objects.map;

import goldminer.objects.common.AbstractGameObject;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author lakobib
 */
public class ImageRenderer extends DefaultTableCellRenderer{
    
    private JLabel lb = new JLabel();
    
    @Override  // позволяет переопределить содержимое ячейки в jTable
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        
         lb.setText(null);
        lb.setIcon(((AbstractGameObject) value).getIcon());
        
         return lb;
     }
}
