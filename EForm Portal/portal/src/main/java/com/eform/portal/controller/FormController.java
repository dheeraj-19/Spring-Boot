// Controller to handle all form related api requests

package com.eform.portal.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eform.portal.dto.FormDto;
import com.eform.portal.dto.FormSubmissionDto;
import com.eform.portal.dto.QuestionDto;
import com.eform.portal.service.form.FormService;

@RestController
@RequestMapping("api/form")
@CrossOrigin("*")
public class FormController {

    @Autowired
    private FormService formService;

    // API request to create a new Form
    @PostMapping()
    public ResponseEntity<?> createForm(@RequestBody FormDto dto) {
        try {

            return new ResponseEntity<>(formService.createForm(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // API request to add a new question to a form
    @PostMapping("/question")
    public ResponseEntity<?> addQuestionInForm(@RequestBody QuestionDto dto) {
        try {
            return new ResponseEntity<>(formService.addQuestion(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // API request to get all the forms
    @GetMapping()
    public ResponseEntity<?> getAllForms() {
        try {
            return new ResponseEntity<>(formService.getAllForms(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // API request to get all the questions for a particular form
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllQuestionsByForm(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(formService.getAllQuestionsByForm(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // API request to handle submission of a form
    @PostMapping("/submit-form")
    public ResponseEntity<?> submitForm(@RequestBody List<FormSubmissionDto> submissionDtos) {
        try {

            formService.submitForm(submissionDtos);
            return ResponseEntity.ok(Collections.singletonMap("message", "Form submitted successfully."));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // API request to get all the submitted forms
    @GetMapping("/form-submissions")
    public ResponseEntity<?> getAllFormSubmissions() {
        try {
            return new ResponseEntity<>(formService.getAllFormSubmissions(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // API request to get all the forms submitted by a particular user
    @GetMapping("/form-submissions/{id}")
    public ResponseEntity<?> getUserFormSubmissions(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(formService.getUserFormSubmissions(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
