/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.AbstractController;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author astahlman
 */
public abstract class AbstractUserInterface extends JPanel {
    
    public void showAlert(Component frame, String msg) 
    {
        // show alert dialog with default title and icon
        JOptionPane.showMessageDialog(frame, msg);
    }
    
    public Boolean showAlertWithYesNoPrompt(Component frame, String msg, String yesBtn, String noBtn)
    {
        // show alert dialog and return OK or cancel response
        //Custom button text
        Object[] options = {yesBtn, noBtn};
        int n = JOptionPane.showOptionDialog(frame,
                msg,
                "Question:",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        
        if (n==0)
        {
            return true;
        }
        return false;
    }
    
    public abstract void setController(AbstractController controller);
    public abstract AbstractController getController();
}
