/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hamkproject.entities.Course;
import hamkproject.entities.Schedule;

/**
 *
 * @author astahlman
 */
public interface IScheduleController {
    void dropCourse(Course course);
    Schedule getSchedule();
}
