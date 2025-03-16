// Interaction with User table in the database

package com.eform.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eform.portal.entities.User;
import com.eform.portal.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Will fetch a user based on the role from the database
    User findByRole(UserRole role);

    // Will fetch the first row which matches the email in the Users table
    User findFirstByEmail(String email);

    // Will fetch the rows with the email from the Users table
    Optional<User> findByEmail(String email);

}
