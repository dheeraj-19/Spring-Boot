// Interaction with Question table in the database

package com.eform.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eform.portal.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
