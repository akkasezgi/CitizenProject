package com.eakkas.citizenprojectapp.dto.request;

import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitizenAddRequest {

    @NotBlank
    private String name;

    private boolean isCitizen;
    private boolean hasDrivingLicence;
}
