/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hamkproject.entities.HAMKUser;

/**
 *
 * @author astahlman
 */
public interface ILoginController {
    void authenticateUser(String userId, String password);
}
