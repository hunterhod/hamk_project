/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

import java.util.ArrayList;

/**
 *
 * @author astahlman
 */

public abstract class HAMKUser {

    protected String userID;
    protected String firstName;
    protected String lastName;
    protected ArrayList<UserDepartmentAssociation> departments = new ArrayList<UserDepartmentAssociation>();
    private String password;
    

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public enum PermissionEnum { StudentPermissions, AdminPermissions, InstructorPermissions }
    protected PermissionEnum viewPermissions;
    protected PermissionEnum modifyPermissions;
    //protected ArrayList<UserDepartmentAssociation> departments;
    
    
   
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the viewPermissions
     */
    public PermissionEnum getViewPermissions() {
        return viewPermissions;
    }

    /**
     * @param viewPermissions the viewPermissions to set
     */
    public void setViewPermissions(PermissionEnum viewPermissions) {
        this.viewPermissions = viewPermissions;
    }

    /**
     * @return the modifyPermissions
     */
    public PermissionEnum getModifyPermissions() {
        return modifyPermissions;
    }

    /**
     * @param modifyPermissions the modifyPermissions to set
     */
    public void setModifyPermissions(PermissionEnum modifyPermissions) {
        this.modifyPermissions = modifyPermissions;
    }
    
    public HAMKUser(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    public void addToDepartment(UserDepartmentAssociation assn)
    {
        if (assn != null)
        {
            departments.add(assn);
        }
    }
    
}
