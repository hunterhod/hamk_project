/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hamkproject;

import hamkproject.entities.HAMKUser;

/**
 *
 * @author astahlman
 */
public class Session {
    private HAMKUser authenticatedUser;

    /**
     * @return the authenticatedUser
     */
    public HAMKUser getAuthenticatedUser() {
        return authenticatedUser;
    }

    /**
     * @param authenticatedUser the authenticatedUser to set
     */
    public void setAuthenticatedUser(HAMKUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }
    
}
