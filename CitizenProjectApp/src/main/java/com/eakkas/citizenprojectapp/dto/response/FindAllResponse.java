package com.eakkas.citizenprojectapp.dto.response;

import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindAllResponse {


    private Long id;
    private boolean isCitizen;
    private String name;
    @Builder.Default
    Map<String,Long> children = new HashMap<>();
    private boolean hasDrivingLicence;


}
