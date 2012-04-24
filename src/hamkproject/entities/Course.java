/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

import java.util.*;

/**
 *
 * @author astahlman
 */

public class Course extends HAMKEntity {

    private String name;
    private String id;
    private CourseTime timeMet;
    private String room;
    private int creditHours;
    private String CRN;
    private int capacity;
    private int currentSize;
    private ArrayList<Course> prereqs;
    private Instructor instructor;
    private String semester;
    private Department department;

    @Override
    public String toString() {
        return name;
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
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
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
     * @return the CRN
     */
    public String getCRN() {
        return CRN;
    }

    /**
     * @param CRN the CRN to set
     */
    public void setCRN(String CRN) {
        this.CRN = CRN;
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
     * @return the currentSize
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * @param currentSize the currentSize to set
     */
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
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
     * @return the timeMet
     */
    public CourseTime getTimeMet() {
        return timeMet;
    }

    /**
     * @param timeMet the timeMet to set
     */
    public void setTimeMet(CourseTime timeMet) {
        this.timeMet = timeMet;
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
    
    public Course(String name, String room, String semester, 
            CourseTime time, int capacity, ArrayList<Course> prereqs, 
            Instructor instructor, Department department)
    {
        this.name = name;
        this.room = room;
        this.semester = semester;
        this.timeMet = time;
        this.capacity = capacity;
        this.currentSize = 0;
        this.instructor = instructor;
        this.department = department;
        if (prereqs == null)
        {
            this.prereqs = new ArrayList<Course>();
        }
        else
        {
            this.prereqs = prereqs;
        }
    }
}
