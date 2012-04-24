/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;
import hamkproject.entities.Course;
import hamkproject.entities.CourseTime;
import hamkproject.entities.Department;
import hamkproject.entities.Instructor;
import java.util.ArrayList;
/**
 *
 * @author astahlman
 */
public class CourseBoundary {
    private String name;
    private CourseTime.Days[] days;
    private String startTime;
    private String endTime;
    private int creditHours;
    private int capacity;
    private ArrayList<Course> prereqs;
    private String semester;
    private Instructor instructor;
    private Department department;
    
    public CourseBoundary(String name, CourseTime.Days[] days, String start, String end, 
            int hours, int cap, ArrayList<Course> prereqs, String sem, Instructor instructor,
            Department dept)
    {
        this.name = name;
        this.days = days;
        this.startTime = start;
        this.endTime = end;
        this.creditHours = hours;
        this.capacity = cap;
        this.prereqs = prereqs;
        this.semester = sem;
        this.instructor = instructor;
        this.department = dept;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the days
     */
    public CourseTime.Days[] getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(CourseTime.Days[] days) {
        this.days = days;
    }

    /**
     * @return the creditHours
     */
    public int getCreditHours() {
        return creditHours;
    }

    /**
     * @param creditHours the creditHours to set
     */
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the prereqs
     */
    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }

    /**
     * @param prereqs the prereqs to set
     */
    public void setPrereqs(ArrayList<Course> prereqs) {
        this.prereqs = prereqs;
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

    /**
     * @return the instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
}
