/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import boundaries.CourseBoundary;
import boundaries.CourseQueryParams;
import hamkproject.HAMKAppFrame;
import hamkproject.entities.Course;
import hamkproject.entities.CourseTime;
import java.util.ArrayList;
import views.CourseCatalogUserInterface;

/**
 *
 * @author astahlman
 */
public class CourseCatalogController extends AbstractController implements ICourseCatalogController {

    /*
     *     public Course(String name, String room, String semester, 
            CourseTime time, int capacity, ArrayList<Course> prereqs, 
            Instructor instructor, Department department)
     */
    public CourseCatalogController(HAMKAppFrame frame)
    {
        super(frame);
        this.view = new CourseCatalogUserInterface(this);
    }
    
    @Override
    public void addCourse(CourseBoundary boundary) {
        
        CourseTime courseTime = new CourseTime(boundary.getDays(), boundary.getStartTime(), boundary.getEndTime());
        Course course = new Course(boundary.getName(), null, boundary.getSemester(), courseTime,
                boundary.getCapacity(), boundary.getPrereqs(), boundary.getInstructor(), boundary.getDepartment());
       if (!appFrame.getDatabaseAPI().addCourseToCatalog(course))
       {
           this.view.showAlert(this.view, "Course is invalid, could not add to catalog.");
       }
    }

    @Override
    public ArrayList<Course> doQuery(CourseQueryParams query) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeCourse(Course course) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
