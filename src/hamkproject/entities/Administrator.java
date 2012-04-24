/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject.entities;

/**
 *
 * @author astahlman
 */
public class Administrator extends HAMKUser {

    @Override
    public String toString() {
        return "Admin: " + super.toString();
    }
    
    public Administrator(String firstName, String lastName)
    {
        super(firstName, lastName);
        viewPermissions = PermissionEnum.AdminPermissions;
        modifyPermissions = PermissionEnum.AdminPermissions;
    }
    
}
