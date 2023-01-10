package com.eakkas.citizenprojectapp.mapper;

import com.eakkas.citizenprojectapp.dto.request.CitizenAddRequest;
import com.eakkas.citizenprojectapp.dto.request.CitizenUpdateRequest;
import com.eakkas.citizenprojectapp.dto.response.CitizenUpdateResponse;
import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T21:57:08+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ICitizenMapperImpl implements ICitizenMapper {

    @Override
    public Citizen toCitizen(CitizenAddRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Citizen.CitizenBuilder citizen = Citizen.builder();

        citizen.name( dto.getName() );
        citizen.hasDrivingLicence( dto.isHasDrivingLicence() );

        return citizen.build();
    }

    @Override
    public CitizenUpdateResponse toUpdateResponseDto(CitizenUpdateRequest dto) {
        if ( dto == null ) {
            return null;
        }

        CitizenUpdateResponse.CitizenUpdateResponseBuilder citizenUpdateResponse = CitizenUpdateResponse.builder();

        citizenUpdateResponse.id( dto.getId() );
        citizenUpdateResponse.name( dto.getName() );
        List<Citizen> list = dto.getChildren();
        if ( list != null ) {
            citizenUpdateResponse.children( new ArrayList<Citizen>( list ) );
        }
        citizenUpdateResponse.hasDrivingLicence( dto.isHasDrivingLicence() );

        return citizenUpdateResponse.build();
    }
}
