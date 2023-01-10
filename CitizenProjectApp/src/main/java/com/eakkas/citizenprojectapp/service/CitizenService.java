package com.eakkas.citizenprojectapp.service;

import com.eakkas.citizenprojectapp.dto.request.CitizenAddChildrenRequest;
import com.eakkas.citizenprojectapp.dto.request.CitizenAddRequest;
import com.eakkas.citizenprojectapp.dto.request.CitizenUpdateRequest;
import com.eakkas.citizenprojectapp.dto.response.CitizenUpdateResponse;
import com.eakkas.citizenprojectapp.dto.response.FindAllResponse;
import com.eakkas.citizenprojectapp.exception.CitizenProjectException;
import com.eakkas.citizenprojectapp.exception.ErrorType;
import com.eakkas.citizenprojectapp.mapper.ICitizenMapper;
import com.eakkas.citizenprojectapp.repository.ICitizenRepository;
import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import com.eakkas.citizenprojectapp.utility.ServiceManager;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService extends ServiceManager<Citizen,Long> {

    private final ICitizenRepository repository;

    public CitizenService( ICitizenRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Citizen save(CitizenAddRequest dto) {
        try {
            return repository.save(ICitizenMapper.INSTANCE.toCitizen(dto));


        }catch (Exception e){
            throw new CitizenProjectException(ErrorType.CITIZEN_NOT_CREATED);
        }
    }

    public void saveAll(List<Citizen> citizens) {
        try {
            repository.saveAll(citizens);

        }catch (Exception e){
            throw new CitizenProjectException(ErrorType.CITIZEN_NOT_CREATED);
        }

    }

    public CitizenUpdateResponse update(CitizenUpdateRequest dto) {

        Optional<Citizen> citizen = repository.findById(dto.getId());
        if (citizen.isEmpty()) {
            throw new CitizenProjectException(ErrorType.CITIZEN_NOT_FOUND);
        }
        citizen.get().setName(dto.getName());
        citizen.get().setChildren(dto.getChildren());
        save(citizen.get());

        return ICitizenMapper.INSTANCE.toUpdateResponseDto(dto);

    }


    public void deleteById(Long id) {
        Optional<Citizen> citizen = repository.findById(id);
        if (citizen.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new CitizenProjectException(ErrorType.CITIZEN_NOT_FOUND);
        }
    }

    public List<FindAllResponse> findAllResponse() {
        List<Citizen>citizens = repository.findAll();
        List<FindAllResponse> responses =  new ArrayList<>();
        for (Citizen citizen:citizens) {
            FindAllResponse response = FindAllResponse.builder()
                    .name(citizen.getName())
                    .id(citizen.getId())
                    .isCitizen(citizen.isCitizen())
                    .hasDrivingLicence(citizen.isHasDrivingLicence())
                    .build();
            citizen.getChildren().forEach(x -> response.getChildren().put(x.getName(),x.getId()));
            responses.add(response);
        }

        return responses;
    }

    public Optional<Citizen> findById(Long id) {

        Optional<Citizen> citizen = repository.findById(id);

        if (citizen.isPresent()) {
            return citizen;
        } else {
            throw new CitizenProjectException(ErrorType.VALUE_NOT_FOUND_IN_CITIZEN);
        }
    }

    public Citizen addChildren(CitizenAddChildrenRequest dto) {

        Optional<Citizen> children = findById(dto.getChildrenId());
        Optional<Citizen> citizen = findById(dto.getId());
        if(children.isEmpty()){
            throw new CitizenProjectException(ErrorType.CHILDREN_NOT_FOUND);
        }
        if (citizen.isEmpty()){
            throw new CitizenProjectException(ErrorType.CITIZEN_NOT_FOUND);
        }
        citizen.get().getChildren().add(children.get());
        save(citizen.get());
        return children.get();
    }
}
