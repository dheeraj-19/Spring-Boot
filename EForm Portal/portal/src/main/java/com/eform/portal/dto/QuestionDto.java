// Object to store deatils of a question

package com.eform.portal.dto;

import java.util.List;

import com.eform.portal.entities.Form;
import com.eform.portal.enums.QuestionType;

import lombok.Data;

@Data
public class QuestionDto {
    private Long id;
    private String questionText;
    private QuestionType questionType;
    private List<String> options;
    private Form form;
}
