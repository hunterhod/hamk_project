/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author astahlman
 * This class is based on Ilya Volodarsky's TableButton class.
 * http://web.archive.org/web/20100623105810/http://ivolo.mit.edu/post/A-Simple-Pattern-for-Embedding-Components-into-a-Swing-JTable.aspx
 */
public class ButtonCellEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    public interface ButtonCellPressedHandler 
    {
        void onButtonPress(int row, int column);
    }
    
    private ArrayList<ButtonCellPressedHandler> handlers;
    private HashMap<Integer, JButton> buttonMap;
    
    public ButtonCellEditor()
    {
        handlers = new ArrayList<ButtonCellPressedHandler>();
        buttonMap = new HashMap<Integer, JButton>();
    }
    
    public void addHandler(ButtonCellPressedHandler handler)
    {
        if (handlers != null)
        {
            handlers.add(handler);
        }
    }
    
    public void removeHandler(ButtonCellPressedHandler handler)
    {
        if (handlers != null)
        {
            handlers.remove(handler);
        }
    }
    
    public void removeRow(int row)
    {
    	if(buttonMap.containsKey(row))
        {
            buttonMap.remove(row);
        }
    }


    public void moveRow(int oldRow, int newRow)
    {
    	if(buttonMap.containsKey(oldRow))
        {
            JButton button = buttonMap.remove(oldRow);
            buttonMap.put(newRow, button);
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focus, final int row, final int column)
    {
        JButton button = null;
        if(buttonMap.containsKey(row))
        {
            button = buttonMap.get(row);
        }
        else
        {
            button = new JButton();
            if(value != null && value instanceof String)
            {
                button.setText((String)value);
            }
            button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(handlers != null)
                    {
                        for(ButtonCellPressedHandler handler : handlers)
                        {
                            handler.onButtonPress(row, column);
                        }
                    }
                }
            });
            buttonMap.put(row, button);
        }

        return button;
    }

    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean selected, int row, int column)
    {
        JButton button = null;
        if(buttonMap.containsKey(row))
        {
            button = buttonMap.get(row);
        }
        else
        {
            button = new JButton();
            if(value != null && value instanceof String)
            {
                button.setText((String)value);
            }

            buttonMap.put(row, button);
        }

        return button;
    }
    
    public void setButtonText(int row, String text)
    {
        if(buttonMap.containsKey(row))
        {
            JButton button = buttonMap.get(row);
            button.setText(text);
        }
    }

    @Override
    public Object getCellEditorValue()
    {
        return null;
    }
    
    public void dispose()
    {
        if (handlers != null)
        {
            handlers.clear();
        }
    }

}
