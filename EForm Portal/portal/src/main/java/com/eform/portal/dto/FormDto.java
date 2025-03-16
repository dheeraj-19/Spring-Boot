// Object to store details of a form

package com.eform.portal.dto;

import lombok.Data;

@Data
public class FormDto {
    private Long id;
    private String title;
    private String description;
}
