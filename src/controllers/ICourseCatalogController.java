/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import boundaries.CourseBoundary;
import boundaries.CourseQueryParams;
import hamkproject.entities.Course;
import java.util.ArrayList;

/**
 *
 * @author astahlman
 */
public interface ICourseCatalogController {
    ArrayList<Course> doQuery(CourseQueryParams query);
    void addCourse(CourseBoundary boundary);
    void removeCourse(Course course);
}
