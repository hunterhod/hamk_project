/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import hamkproject.entities.Course;
import hamkproject.entities.Schedule;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author astahlman
 */
public class ScheduleTableModel extends AbstractTableModel
{
    private String columnNames[];
    private Schedule schedule;
    private Object[][] data;
    
    private static final short MAX_ROWS = 18;
    
    public ScheduleTableModel(Schedule schedule)
    {
        this.schedule = schedule;
        columnNames = new String[] {"Course", "Time", "Credit Hours", "Instructor", "Drop"};
        data = new Object[MAX_ROWS][columnNames.length];
        loadTableData();
    }
    
    private void loadTableData()
    {
        short row = 0;
        for (Course c : schedule.getCourses())
        {
            data[row][0] = c.getName();
            data[row][1] = c.getTimeMet().toString();
            data[row][2] = c.getCreditHours();
            data[row][3] = c.getInstructor().toString();
            data[row][4] = "Drop Course";
            row++;
        }
        
    }
    
    @Override
    public Object getValueAt(int row, int col)
    {
        return data[row][col];
    }
    
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    @Override
    public int getRowCount()
    {
        return schedule.getCourses().size();
    }
    
    @Override
    public Class getColumnClass(int c) {
        
        if (c == (getColumnCount() - 1))
        {
            return ButtonCellEditor.class;
        }
        
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public boolean isCellEditable(int row, int col)
    {
        if (col == (getColumnCount() - 1))
        {
            return true;
        }
        return false;
    }
    
    public Course getCourseForRow(int row)
    {
        return schedule.getCourses().get(row);
    }
    
    public void onScheduleChanged()
    {
        loadTableData();
        this.fireTableDataChanged();
    }
}
