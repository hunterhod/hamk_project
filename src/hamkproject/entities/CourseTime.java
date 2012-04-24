/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

/**
 *
 * @author astahlman
 */
public class CourseTime extends HAMKEntity {

    /**
     * @return the days
     */
    public Days[] getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Days[] days) {
        this.days = days;
    }
    public enum Days { M, T, W, H, F }
    private Days[] days;
    private String startTime;
    private String endTime;
    


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

    @Override
    public String toString() {
        return startTime + " - " + endTime;
    }
    
    public CourseTime(Days[] days, String startTime, String endTime)
    {
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
