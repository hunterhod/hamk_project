/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hamkproject.HAMKAppFrame;
import hamkproject.entities.Student;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import views.MainHubUserInterface;

/**
 *
 * @author astahlman
 */
public class MainHubController extends AbstractController implements IMainHubController {
    
    private static final HashMap<String, Class> CONTROLLER_MAP = createControllerMap(); 
    
    private static HashMap<String, Class> createControllerMap()
    {
        HashMap map = new HashMap<String, Class>();
        map.put(LOGIN, LoginController.class);
        map.put(VIEW_SCHEDULE, ScheduleController.class);
        return map;
    }
    
    public static final String LOGIN = "Login";
    public static final String VIEW_CATALOG = "View Catalog";
    public static final String VIEW_SCHEDULE = "View Schedule";
    public static final String VIEW_ENROLLMENT_SUMMARY = "View Enrollment Summary";
    
    public MainHubController(HAMKAppFrame frame)
    {
        super(frame);
        this.view = new MainHubUserInterface(this);
    }
    
    @Override
    public void logout()
    {
        appFrame.setAuthenticatedUser(null);
    }
    
    @Override
    public void launchController(String controllerName) 
    {
        Class controllerClass = CONTROLLER_MAP.get(controllerName);

        this.doLaunchController(controllerClass);



    }
    
    private void doLaunchController(Class controllerClass) 
    {
        AbstractController controller = null;
        
        if (controllerClass.equals(ScheduleController.class))
        {
            Student student = (Student) this.appFrame.getAuthenticatedUser();
            controller = new ScheduleController(appFrame, student.getSchedule());
            
        }
        else if (controllerClass.equals(CourseCatalogController.class))
        {
            controller = new CourseCatalogController(appFrame);
        }
        else 
        {
            /*
            Class[] params = {HAMKAppFrame.class};
            Constructor ctor;
            ctor = controllerClass.getConstructor(params);
            controller = (AbstractController) ctor.newInstance(new Object[] { this });
            
            */
        }
        
        if (controller != null)
        {
            appFrame.pushViewController(controller);
        }
    }
}
