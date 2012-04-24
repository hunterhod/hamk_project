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

public class Schedule extends HAMKEntity {

    private ArrayList<Course> courses;
    private Student student;
    private String semester;
    public static final int MAX_HOURS = 18;


    @Override
    public String toString() {
        return student.getFirstName() + semester;
    }

    /**
     * @return the courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public Schedule(Student student, String sem)
    {
        this.student = student;
        this.semester = sem;
        this.courses = new ArrayList<Course>();
    }
    
    public Boolean addCourse(Course course)
    {
        short hours = 0;
        for (Course c : courses)
        {
            hours += c.getCreditHours();
        }
        
        if (hours + course.getCreditHours() <= MAX_HOURS)
        {
            courses.add(course);
            return true;
        }
        
        return false;
    }
    
    public Boolean dropCourse(Course course)
    {
        if (courses.contains(course))
        {
            courses.remove(course);
            return true;
        }
        
        return false;
    }

    
}
