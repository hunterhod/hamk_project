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
public class EnrollmentSummary extends HAMKEntity {

    private String id;

    private Student student;

    private ArrayList<Course> completedCourses;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "hamkproject.entities.EnrollmentSummary[ id=" + id + " ]";
    }
    
}
