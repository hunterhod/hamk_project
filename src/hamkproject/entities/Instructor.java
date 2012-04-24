/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.*;
import javax.persistence.*;
/**
 *
 * @author astahlman
 */

public class Instructor extends HAMKUser {

    
    private ArrayList<Course> courses;
    
    public Instructor(String firstName, String lastName)
    {
        super(firstName, lastName);
        viewPermissions = PermissionEnum.InstructorPermissions;
        modifyPermissions = PermissionEnum.InstructorPermissions;
        courses = new ArrayList<Course>();
    }
    
    public void addCourse(Course course)
    {
        if (course != null)
        {
            courses.add(course);
        }
    }
    
}
