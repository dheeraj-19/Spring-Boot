// Interface of all the methods for all the actions on Users

package com.eform.portal.service.user;

import com.eform.portal.entities.User;

public interface UserService {

    // Method to register a new user
    User creatUser(User user);

    // Method to check if a user already exists
    Boolean hasUserWithEmail(String email);

    // Method to login a user
    User login(User user);

}
