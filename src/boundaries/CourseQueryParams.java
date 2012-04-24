/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

/**
 *
 * @author astahlman
 */
public class CourseQueryParams {
    private String CRN;
    private String name;
    private String department;

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
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    
}
