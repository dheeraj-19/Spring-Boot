// Table structure of form submissions

package com.eform.portal.entities;

import com.eform.portal.dto.FormSubmissionDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FormSubmissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public FormSubmissionDto getDto() {
        FormSubmissionDto dto = new FormSubmissionDto();
        dto.setId(id);
        dto.setAnswer(answer);
        dto.setFormId(form.getId());
        dto.setFormTitle(form.getTitle());
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        dto.setQuestionId(question.getId());
        dto.setQuestionText(question.getQuestionText());

        return dto;
    }

}
