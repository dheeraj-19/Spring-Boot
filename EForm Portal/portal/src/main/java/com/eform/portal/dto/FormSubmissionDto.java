// Object to store forms submitted by users

package com.eform.portal.dto;

import lombok.Data;

@Data
public class FormSubmissionDto {

    private Long id;

    private String answer;

    private Long formId;
    private String formTitle;

    private Long userId;
    private String userName;

    private Long questionId;
    private String questionText;
}
