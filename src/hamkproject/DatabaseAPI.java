/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject;

import boundaries.CourseQueryParams;
import hamkproject.entities.*;
import java.util.ArrayList;

/**
 *
 * @author astahlman
 */
public interface DatabaseAPI {
    HAMKUser getUserByID(String id);
    Course getCourseByID(String id);
    Schedule getScheduleForStudent(Student student);
    ArrayList<Course> getCoursesForInstructor(Instructor instructor);
    HAMKUser authenticateUser(String userID, String password);
    boolean addCourseToCatalog(Course course);
    ArrayList<Course> doCourseQuery(CourseQueryParams query);
}
