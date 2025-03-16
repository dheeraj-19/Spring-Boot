// Object to store questions of a Form

package com.eform.portal.dto;

import java.util.List;

import lombok.Data;

@Data
public class FormDetailsDto {
    private FormDto formDto;
    private List<QuestionDto> questions;
}
