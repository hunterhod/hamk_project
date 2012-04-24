/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hamkproject.HAMKAppFrame;
import hamkproject.entities.HAMKUser;
import views.LoginUserInterface;

/**
 *
 * @author astahlman
 */
public class LoginController extends AbstractController implements ILoginController {
    
    public LoginController(HAMKAppFrame frame)
    {
        super(frame);
        this.view = new LoginUserInterface(this);
    }
    
    @Override
    public void authenticateUser(String userId, String password)
    {
        HAMKUser theUser = appFrame.getDatabaseAPI().authenticateUser(userId, password);
        if (theUser != null)
        {
            this.appFrame.setAuthenticatedUser(theUser);
            this.goToMainHub();
        }
        else
        {
            this.view.showAlert(appFrame, "Invalid userId/password.");
        }
    }
    
    private void goToMainHub()
    {
        appFrame.popViewController();
        MainHubController controller = new MainHubController(appFrame);
        appFrame.pushViewController(controller);
    }
}
