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
public class DatabaseFacade implements DatabaseAPI {

    
    // dbsession variable here
    DatabaseAPI dbAPI;
    
    public DatabaseFacade(DatabaseAPI apiInstance)
    {
        dbAPI = apiInstance;
    }

    @Override
    public HAMKUser authenticateUser(String userID, String password) {
        return dbAPI.authenticateUser(userID, password);
    }

    @Override
    public Course getCourseByID(String id) {
        return dbAPI.getCourseByID(id);
    }

    @Override
    public ArrayList<Course> getCoursesForInstructor(Instructor instructor) {
        return dbAPI.getCoursesForInstructor(instructor);
    }

    @Override
    public Schedule getScheduleForStudent(Student student) {
        return dbAPI.getScheduleForStudent(student);
    }

    @Override
    public HAMKUser getUserByID(String id) {
        return dbAPI.getUserByID(id);
    }
    
    @Override
    public boolean addCourseToCatalog(Course course) {
        return dbAPI.addCourseToCatalog(course);
    }

    @Override
    public ArrayList<Course> doCourseQuery(CourseQueryParams query) {
        return dbAPI.doCourseQuery(query);
    }
    
}
