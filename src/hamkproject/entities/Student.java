/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

/**
 *
 * @author astahlman
 */

public class Student extends HAMKUser {
    
    private Boolean hasHold;
    private String major;
    private EnrollmentSummary enrollmentSummary;
    private Schedule schedule;
    private Boolean fullTime;

    /**
     * @return the fullTime
     */
    public Boolean getFullTime() {
        return fullTime;
    }

    /**
     * @param fullTime the fullTime to set
     */
    public void setFullTime(Boolean fullTime) {
        this.fullTime = fullTime;
    }

    /**
     * @return the hasHold
     */
    public Boolean getHasHold() {
        return hasHold;
    }

    /**
     * @param hasHold the hasHold to set
     */
    public void setHasHold(Boolean hasHold) {
        this.hasHold = hasHold;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the enrollmentSummary
     */
    public EnrollmentSummary getEnrollmentSummary() {
        return enrollmentSummary;
    }

    /**
     * @param enrollmentSummary the enrollmentSummary to set
     */
    public void setEnrollmentSummary(EnrollmentSummary enrollmentSummary) {
        this.enrollmentSummary = enrollmentSummary;
    }

    /**
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public Student(String firstName, String lastName, String currentSemester)
    {
        super(firstName, lastName);
        this.viewPermissions = PermissionEnum.StudentPermissions;
        this.modifyPermissions = PermissionEnum.StudentPermissions;
        this.schedule = new Schedule(this, currentSemester);
        this.enrollmentSummary = new EnrollmentSummary();
    }
    
}
