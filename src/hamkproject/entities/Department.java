/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

import java.util.ArrayList;

/**
 *
 * @author astahlman
 */
public class Department {
    private String name;
    private University university;
    private ArrayList<UserDepartmentAssociation> users = new ArrayList<UserDepartmentAssociation>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    
    public Department(University univ, String name)
    {
        this.university = univ;
        this.name = name;
    }
    
    public void addCourse(Course c)
    {
        if (c != null)
        {
            getCourses().add(c);
        }
    }
    
    public void addUser(HAMKUser user)
    {
        UserDepartmentAssociation assn = new UserDepartmentAssociation(user, this);
        getUsers().add(assn);
        user.addToDepartment(assn);
    }

    /**
     * @return the university
     */
    public University getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(University university) {
        this.university = university;
    }

    /**
     * @return the users
     */
    public ArrayList<UserDepartmentAssociation> getUsers() {
        return users;
    }

    /**
     * @return the courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    public String getCurrentSemester()
    {
        return university.getSemester();
    }
    
}
