/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

import java.util.Date;

/**
 *
 * @author astahlman
 */
public class Registration extends HAMKEntity {
    
    private Date registrationTime;
    private EnrollmentSummary enrollmentSummary;
    private Course course;

    /**
     * @return the registrationTime
     */
    public Date getRegistrationTime() {
        return registrationTime;
    }

    /**
     * @param registrationTime the registrationTime to set
     */
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
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
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the gradeReceived
     */
    public GradeEnum getGradeReceived() {
        return gradeReceived;
    }

    /**
     * @param gradeReceived the gradeReceived to set
     */
    public void setGradeReceived(GradeEnum gradeReceived) {
        this.gradeReceived = gradeReceived;
    }
    public enum GradeEnum { A, B, C, D, F }
    private GradeEnum gradeReceived;
    

    @Override
    public String toString() {
        return "hamkproject.entities.Registration[ id=" + id + " ]";
    }
    
}
