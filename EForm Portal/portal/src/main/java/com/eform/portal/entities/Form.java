// Table structure of a Form

package com.eform.portal.entities;

import java.util.List;

import com.eform.portal.dto.FormDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Question> questions;

    public FormDto getDto() {
        FormDto formDto = new FormDto();
        formDto.setId(id);
        formDto.setTitle(title);
        formDto.setDescription(description);

        return formDto;
    }
}
