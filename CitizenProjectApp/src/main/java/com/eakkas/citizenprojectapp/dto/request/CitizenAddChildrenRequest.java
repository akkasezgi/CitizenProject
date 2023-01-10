package com.eakkas.citizenprojectapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenAddChildrenRequest {

        private Long id;
        private Long childrenId;
        private String name;
}
