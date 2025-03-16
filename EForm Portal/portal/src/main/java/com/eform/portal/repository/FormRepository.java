// Interaction with Form table in the database

package com.eform.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eform.portal.entities.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

}
