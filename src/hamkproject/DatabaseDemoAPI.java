/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject;

import boundaries.CourseQueryParams;
import hamkproject.entities.CourseTime.Days;
import hamkproject.entities.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author astahlman
 */
public class DatabaseDemoAPI implements DatabaseAPI
{
    
    private University university = new University("HAMK U.", "Fall 2012");

    private ArrayList<HAMKUser> userDatabase = new ArrayList<HAMKUser>();
    private ArrayList<Course> courseCatalog = new ArrayList<Course>();
    private ArrayList<Schedule> schedules = new ArrayList<Schedule>();
    private ArrayList<Department> departments = new ArrayList<Department>();
    
    
    
    public static final String STUDENT_ID = "Test_Student";
    public static final String ADMIN_ID = "Test_Admin";
    public static final String INSTRUCTOR_ID = "Test_Instructor";
    

    
    public static final int DEFAULT_CAPACITY = 50;
            
    public DatabaseDemoAPI()
    {
        Department swenDept = new Department(university, "SWEN");
        Department englDept = new Department(university, "ENGL");
        
        // Create users: student, admin and instructor
        Student testStudent = new Student("Test", "Student", university.getSemester());
        testStudent.setUserID(STUDENT_ID);
        testStudent.setPassword("");
            
        Administrator testAdmin = new Administrator("Test", "Admin");
        testAdmin.setUserID(ADMIN_ID);
        testAdmin.setPassword("");
        
        Instructor testInstructor = new Instructor("Test", "Instructor");
        testInstructor.setUserID(INSTRUCTOR_ID);
        testInstructor.setPassword("");
        
        swenDept.addUser(testInstructor);
        swenDept.addUser(testStudent);
        
        userDatabase.add(testStudent);
        userDatabase.add(testAdmin);
        userDatabase.add(testInstructor);
                
        CourseTime testTime = new CourseTime(new Days[] {Days.M, Days.W, Days.F}, "13:00", "13:50");
        
        // create an old test course
        Course oldCourse = new Course("Bob the Builder and the Human Odyssey", "Shelby 3.14",
                "Fall 2011", testTime, DEFAULT_CAPACITY, null, testInstructor, englDept);
        
        ArrayList<Course> prereqs = new ArrayList<Course>();
        prereqs.add(oldCourse);
        
        Course testCourse = new Course("Underwater Basket Weaving", 
                "Shelby 5 and 3/4", university.getSemester(), testTime, DEFAULT_CAPACITY, 
                prereqs, testInstructor, swenDept);

        englDept.addCourse(oldCourse);
        swenDept.addCourse(testCourse);
        
        this.addCourseToCatalog(oldCourse);
        this.addCourseToCatalog(testCourse);
        
        
        // enroll the student in the test course taught by the test instructor
        Schedule studentSchedule = testStudent.getSchedule();
        studentSchedule.addCourse(testCourse);
        
        // add an old schedule
        Schedule oldSchedule = new Schedule(testStudent, "Fall 2011");
        oldSchedule.addCourse(oldCourse);
        
        this.schedules.add(studentSchedule);
        this.schedules.add(oldSchedule);
        
        testInstructor.addCourse(testCourse);
        testInstructor.addCourse(oldCourse);
        
    }
    
    private String generateUUID()
    {
        UUID id = UUID.randomUUID();
        return id.toString();
    }
    
    @Override
    public HAMKUser authenticateUser(String userID, String password)
    {
        HAMKUser user = getUserByID(userID);
        if (user != null && user.getPassword().equals(password))
        {
            return user;
        }
        
        return null;
    }
    
    @Override
    public HAMKUser getUserByID(String userID)
    {
        for (HAMKUser user : userDatabase)
        {
            if (user.getUserID().equals(userID))
            {
                return user;
            }
        }

        return null;
    }
    
    @Override
    public Course getCourseByID(String courseID)
    {
        for (Course course : courseCatalog)
        {
            if (course.getId().equals(courseID))
            {
                return course;
            }
        }
        
        return null;
    }
    
    @Override
    public Schedule getScheduleForStudent(Student student)
    {
        return student.getSchedule();
    }
    
    @Override
    public ArrayList<Course> getCoursesForInstructor(Instructor instructor)
    {
        ArrayList<Course> courses = new ArrayList<Course>();
        for (Course course : courseCatalog)
        {
            if (course.getInstructor().equals(instructor))
            {
                courses.add(course);
            }
        }
        
        return courses;
    }
    
    @Override
    public boolean addCourseToCatalog(Course course)
    {
        String CRN = generateCRN();
        course.setCRN(CRN);
        courseCatalog.add(course);
        return true;
    }
    
    private String generateCRN()
    {
        boolean isUnique = false;
        Random ran = new Random();
        short LENGTH = 6;
        String CRN = null;
        while (!isUnique)
        {
            CRN = "";
            for (short i = 0; i < LENGTH; i++)
            {
                int r = ran.nextInt(9);
                CRN += Integer.toString(r);
            }

            isUnique = isCRNUnique(CRN);
        }
        
        return CRN;
    }
    
    private boolean isCRNUnique(String CRN)
    {
        for (Course c : courseCatalog)
        {
            if (CRN.equals(c.getCRN()))
            {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public ArrayList<Course> doCourseQuery(CourseQueryParams query) {
        ArrayList<Course> results = new ArrayList<Course>();
        for (Course c : courseCatalog)
        {
            if (c.getCRN().equals(query.getCRN()))
            {
                results.add(c);
            }
            else if (c.getDepartment().equals(query.getDepartment()))
            {
                results.add(c);
            }
            else if (c.getName().equals(query.getName()))
            {
                results.add(c);
            }
        }
        return results;
    }
    
}
