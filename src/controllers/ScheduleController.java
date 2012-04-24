/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hamkproject.HAMKAppFrame;
import hamkproject.entities.Course;
import hamkproject.entities.Schedule;
import views.ScheduleUserInterface;

/**
 *
 * @author astahlman
 */
public class ScheduleController extends AbstractController implements IScheduleController {
    
    private Schedule schedule;
    
    public ScheduleController(HAMKAppFrame frame, Schedule schedule)
    {
        super(frame);
        this.schedule = schedule;
        this.view = new ScheduleUserInterface(this);
        
    }
    
    @Override
    public void dropCourse(Course course)
    {
        // drop the course
        if(!this.schedule.dropCourse(course))
        {
            view.showAlert(view, "Could not drop the course.");
        }
    }
    
    @Override
    public Schedule getSchedule()
    {
        return schedule;
    }
}
