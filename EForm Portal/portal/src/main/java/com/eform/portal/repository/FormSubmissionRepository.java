// Interaction with Form Submission table in the database

package com.eform.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eform.portal.entities.FormSubmissions;

@Repository
public interface FormSubmissionRepository extends JpaRepository<FormSubmissions, Long> {

    // Will fetch all the form submissions for a particular user based on the id
    // from the database
    List<FormSubmissions> findAllByUserId(Long userId);
}
