package com.eakkas.citizenprojectapp.dto.response;

import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenUpdateResponse {

    private Long id;
    private boolean isCitizen;
    private String name;
    List<Citizen> children;
    private boolean hasDrivingLicence;
}
