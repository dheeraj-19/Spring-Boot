// Interface of all the methods for all the actions on Forms

package com.eform.portal.service.form;

import java.util.List;

import com.eform.portal.dto.FormDetailsDto;
import com.eform.portal.dto.FormDto;
import com.eform.portal.dto.FormSubmissionDto;
import com.eform.portal.dto.QuestionDto;

public interface FormService {

    // Method to create a new Form
    FormDto createForm(FormDto dto);

    // Method to add a new question to a form
    QuestionDto addQuestion(QuestionDto dto);

    // Method to get all the forms
    List<FormDto> getAllForms();

    // Method to get all the questions for a particular form
    FormDetailsDto getAllQuestionsByForm(Long id);

    // Method to handle submission of a form
    void submitForm(List<FormSubmissionDto> response);

    // Method to get all the submitted forms
    List<FormSubmissionDto> getAllFormSubmissions();

    // Method to get all the forms submitted by a particular user
    List<FormSubmissionDto> getUserFormSubmissions(Long userId);

}
