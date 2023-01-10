package com.eakkas.citizenprojectapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenAddChildrenResponse {

    private Long id;
    private Long childrenId;
    private String name;
}
