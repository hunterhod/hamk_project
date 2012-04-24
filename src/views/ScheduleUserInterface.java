/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.AbstractController;
import controllers.IScheduleController;
import hamkproject.entities.Course;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author astahlman
 */
public class ScheduleUserInterface extends AbstractUserInterface {

    private IScheduleController controller;
    private JTable table;
    
    @Override
    public void setController(AbstractController controller)
    {
        this.controller = (IScheduleController) controller;
    }
    
    @Override
    public AbstractController getController()
    {
        return (AbstractController) this.controller;
    }
    
    /**
     * Creates new form ScheduleUserInterface
     */
    public ScheduleUserInterface(IScheduleController controller) 
    {
        this.controller = controller;
        createTable();
        initComponents();
    }
    
    private void createTable()
    {
        this.table = new JTable(new ScheduleTableModel(controller.getSchedule()));
        table.setRowHeight(50);
        int buttonCol = this.table.getModel().getColumnCount() - 1;
        TableColumn buttonColumn = this.table.getColumnModel().getColumn(buttonCol);
        ButtonCellEditor buttons = new ButtonCellEditor();
        buttonColumn.setCellRenderer(buttons);
        buttonColumn.setCellEditor(buttons);
        for (int i = 0; i < this.table.getModel().getRowCount(); i++)
        {
            buttons.setButtonText(i, "Drop Course");
        }
        buttons.addHandler(new ButtonCellEditor.ButtonCellPressedHandler() {

            @Override
            public void onButtonPress(int row, int column) {
                handleDropCourse(row);
            }
        });
    }

    private void handleDropCourse(int row)
    {
        ScheduleTableModel model = (ScheduleTableModel) table.getModel();
        Course c = model.getCourseForRow(row);
        controller.dropCourse(c);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane(table);
        semesterBox = new javax.swing.JComboBox();

        semesterBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Current Semester" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(scrollPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(semesterBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(scrollPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(semesterBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JComboBox semesterBox;
    // End of variables declaration//GEN-END:variables
}