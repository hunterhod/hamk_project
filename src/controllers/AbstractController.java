/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hamkproject.HAMKAppFrame;
import views.AbstractUserInterface;

/**
 *
 * @author astahlman
 */
public abstract class AbstractController {
    
    protected AbstractUserInterface view;
    protected HAMKAppFrame appFrame;

    /**
     * @return the view
     */
    public AbstractUserInterface getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(AbstractUserInterface view) {
        this.view = view;
    }

    /**
     * @return the appFrame
     */
    public HAMKAppFrame getAppFrame() {
        return appFrame;
    }

    /**
     * @param appFrame the appFrame to set
     */
    public void setAppFrame(HAMKAppFrame appFrame) {
        this.appFrame = appFrame;
    }
    
    public AbstractController(HAMKAppFrame frame)
    {
        this.appFrame = frame;
    }

}
