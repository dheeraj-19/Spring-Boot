// Implementation of all the methods for all the actions on Forms

package com.eform.portal.service.form;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eform.portal.dto.FormDetailsDto;
import com.eform.portal.dto.FormDto;
import com.eform.portal.dto.FormSubmissionDto;
import com.eform.portal.dto.QuestionDto;
import com.eform.portal.entities.Form;
import com.eform.portal.entities.FormSubmissions;
import com.eform.portal.entities.Question;
import com.eform.portal.entities.User;
import com.eform.portal.enums.QuestionType;
import com.eform.portal.repository.FormRepository;
import com.eform.portal.repository.FormSubmissionRepository;
import com.eform.portal.repository.QuestionRepository;
import com.eform.portal.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private FormSubmissionRepository formSubmissionRepository;

    @Autowired
    private UserRepository userRepository;

    // Implementation of method to create a new Form
    public FormDto createForm(FormDto dto) {
        Form form = new Form();

        form.setTitle(dto.getTitle());
        form.setDescription(dto.getDescription());

        return formRepository.save(form).getDto();
    }

    // Implementation of method to add a new question to a form
    public QuestionDto addQuestion(QuestionDto dto) {
        Optional<Form> optionalForm = formRepository.findById(dto.getId());
        if (optionalForm.isPresent()) {
            Question question = new Question();
            question.setForm(optionalForm.get());
            question.setQuestionText(dto.getQuestionText());
            question.setQuestionType(dto.getQuestionType());

            if (dto.getQuestionType() == QuestionType.TEXT) {
                question.setOptions(null); // No options needed for TEXT input
            } else {
                if (dto.getOptions() != null && !dto.getOptions().isEmpty()) {
                    question.setOptions(dto.getOptions()); // To check it's not null
                } else {
                    throw new IllegalArgumentException("Options cannot be empty for non-text questions");
                }
            }

            return questionRepository.save(question).getDto();
        }
        throw new EntityNotFoundException("Form Not Found!");
    }

    // Implementation of method to get all the forms
    public List<FormDto> getAllForms() {
        return formRepository.findAll().stream().map(Form::getDto).collect(Collectors.toList());
    }

    // Implementation of method to get all the questions for a particular form
    public FormDetailsDto getAllQuestionsByForm(Long id) {
        Optional<Form> optionalForm = formRepository.findById(id);
        FormDetailsDto formDetailsDto = new FormDetailsDto();
        if (optionalForm.isPresent()) {
            FormDto formDto = optionalForm.get().getDto();
            formDetailsDto.setFormDto(formDto);
            formDetailsDto.setQuestions(optionalForm.get().getQuestions().stream().map(Question::getDto).toList());
            return formDetailsDto;
        }
        return formDetailsDto;
    }

    // Implementation of method to handle submission of a form
    public void submitForm(List<FormSubmissionDto> response) {
        List<FormSubmissions> submissions = response.stream().map(dto -> {
            Form form = formRepository.findById(dto.getFormId())
                    .orElseThrow(() -> new RuntimeException("Form not found"));

            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Question question = questionRepository.findById(dto.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            FormSubmissions submission = new FormSubmissions();
            submission.setForm(form);
            submission.setUser(user);
            submission.setQuestion(question);
            submission.setAnswer(dto.getAnswer());

            return submission;
        }).collect(Collectors.toList());

        formSubmissionRepository.saveAll(submissions);

    }

    // Implementation of method to get all the submitted forms
    public List<FormSubmissionDto> getAllFormSubmissions() {
        return formSubmissionRepository.findAll().stream().map(FormSubmissions::getDto).collect(Collectors.toList());
    }

    // Implementation of method to get all the forms submitted by a particular user
    public List<FormSubmissionDto> getUserFormSubmissions(Long userId) {
        return formSubmissionRepository.findAllByUserId(userId).stream()
                .map(FormSubmissions::getDto)
                .collect(Collectors.toList());
    }

}
