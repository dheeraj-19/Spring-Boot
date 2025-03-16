// Table structure of questions

package com.eform.portal.entities;

import java.util.List;

import com.eform.portal.dto.QuestionDto;
import com.eform.portal.enums.QuestionType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option")
    private List<String> options;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    public QuestionDto getDto() {
        QuestionDto dto = new QuestionDto();
        dto.setId(id);
        dto.setQuestionText(questionText);
        dto.setQuestionType(questionType);
        dto.setOptions(options);
        return dto;
    }

}
