/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

/**
 *
 * @author astahlman
 */
public class University {
    private String name;
    private String semester;
    
    public University(String name, String sem)
    {
        this.name = name;
        this.semester = sem;
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
}
