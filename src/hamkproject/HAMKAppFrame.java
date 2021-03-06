/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject;
import controllers.AbstractController;
import controllers.LoginController;
import controllers.MainHubController;
import hamkproject.entities.HAMKUser;
import java.awt.CardLayout;
import java.awt.Container;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import views.AbstractUserInterface;
import views.LoginUserInterface;
import views.MainHubUserInterface;

/**
 *
 * @author astahlman
 */
public class HAMKAppFrame extends javax.swing.JFrame {

    private Stack<AbstractController> viewControllers;
    private CardLayout viewCards;
    private Session session;
    private DatabaseFacade dbAPI;
    
    private static final HashMap<Class, Class> VIEW_CONTROLLER_MAP = createViewControllerMap();
    
    private static final HashMap<Class, Class> createViewControllerMap()
    {
        HashMap<Class, Class> map = new HashMap<Class, Class>();
        map.put(LoginController.class, LoginUserInterface.class);
        map.put(MainHubController.class, MainHubUserInterface.class);
        return map;
    }
    /**
     * Creates new form HAMKAppFrame
     */
    public HAMKAppFrame() {
        initComponents();
        viewCards = new CardLayout();
        this.getContentPane().setLayout(viewCards);
        viewControllers = new Stack<AbstractController>();
        session = new Session();
        dbAPI = new DatabaseFacade(new DatabaseDemoAPI());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HAMKAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HAMKAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HAMKAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HAMKAppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                HAMKAppFrame theApp = new HAMKAppFrame();
                theApp.setVisible(true);
                theApp.launch();
            }
        });
    }
    
    public void pushViewController(AbstractController controller)
    {
        Container pane = this.getContentPane();
        
        viewControllers.push(controller);
        
        if (!(Arrays.asList(pane.getComponents()).contains(controller.getView())))
        {
            pane.add(controller.getView(), controller.getClass().getName());
        }
        viewCards.show(pane, controller.getClass().getName());
    }
    
    public void popViewController()
    {
        if (viewControllers.size() > 0)
        {
            viewControllers.pop();
            
            if (viewControllers.size() > 0)
            {
                AbstractController nextController = viewControllers.peek();
                viewCards.show(this.getContentPane(), nextController.getClass().toString());
            }
        }
    }
    
    // GRASP: "Don't talk to strangers"
    // allows AbstractControllers to set the user responsibly
    public void setAuthenticatedUser(HAMKUser user)
    {
        session.setAuthenticatedUser(user);
    }
    
    public HAMKUser getAuthenticatedUser()
    {
        return session.getAuthenticatedUser();
    }
    
    public void launch()
    {
        /*
        MainHubUserInterface ui = new MainHubUserInterface();
        MainHubController controller = new MainHubController(ui, this);
        ui.setController(controller);
        pushViewController(controller);
        * 
        */
        LoginController controller = new LoginController(this);
        pushViewController(controller);
    }
    
    public DatabaseFacade getDatabaseAPI()
    {
        return dbAPI;
    }
    /*
    public static Class viewForController(Class controllerClass)
    {
        Class viewClass = VIEW_CONTROLLER_MAP.get(controllerClass);
        return viewClass;
    }
*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
