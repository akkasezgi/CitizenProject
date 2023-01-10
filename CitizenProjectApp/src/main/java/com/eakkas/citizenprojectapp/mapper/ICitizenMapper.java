package com.eakkas.citizenprojectapp.mapper;

import com.eakkas.citizenprojectapp.dto.request.CitizenAddRequest;
import com.eakkas.citizenprojectapp.dto.request.CitizenUpdateRequest;
import com.eakkas.citizenprojectapp.dto.response.CitizenUpdateResponse;
import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICitizenMapper {

    ICitizenMapper INSTANCE = Mappers.getMapper(ICitizenMapper.class);

    Citizen toCitizen(final CitizenAddRequest dto);

    CitizenUpdateResponse toUpdateResponseDto(final CitizenUpdateRequest dto);

}
