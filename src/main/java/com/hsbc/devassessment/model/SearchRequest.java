package com.hsbc.devassessment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class SearchRequest {
    private String id;
    @Size(max=250)
    private String firstname;
    @Size(max=250)
    private String surname;
}
