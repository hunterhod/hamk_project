/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

/**
 *
 * @author astahlman
 */
public class UserDepartmentAssociation {
    
    private HAMKUser user;
    private Department dept;
    
    public UserDepartmentAssociation(HAMKUser user, Department dept)
    {
        this.user = user;
        this.dept = dept;
    }

    /**
     * @return the user
     */
    public HAMKUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(HAMKUser user) {
        this.user = user;
    }

    /**
     * @return the dept
     */
    public Department getDept() {
        return dept;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(Department dept) {
        this.dept = dept;
    }
}
