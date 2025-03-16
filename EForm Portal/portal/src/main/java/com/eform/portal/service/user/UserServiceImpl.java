// Implementation of all the methods for all the actions on Users

package com.eform.portal.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eform.portal.entities.User;
import com.eform.portal.enums.UserRole;
import com.eform.portal.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Implementation of method to create an ADMIN user
    @PostConstruct
    private void createAdminUser() {
        User optionalUser = userRepository.findByRole(UserRole.ADMIN);
        if (optionalUser == null) {
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@gmail.com");
            user.setRole(UserRole.ADMIN);
            user.setPassword("admin");

            userRepository.save(user);
        }
    }

    // Implementation of method to register a new user
    public User creatUser(User user) {
        user.setRole(UserRole.USER);

        return userRepository.save(user);
    }

    // Implementation of method to check if a user already exists
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    // Implementation of method to login a user
    public User login(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent() && user.getPassword().equals(optionalUser.get().getPassword())) {
            return optionalUser.get();
        }

        return null;
    }

}
