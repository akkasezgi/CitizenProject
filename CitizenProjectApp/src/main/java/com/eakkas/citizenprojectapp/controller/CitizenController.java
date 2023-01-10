package com.eakkas.citizenprojectapp.controller;

import com.eakkas.citizenprojectapp.dto.request.CitizenAddChildrenRequest;
import com.eakkas.citizenprojectapp.dto.request.CitizenAddRequest;
import com.eakkas.citizenprojectapp.dto.response.FindAllResponse;
import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import com.eakkas.citizenprojectapp.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.eakkas.citizenprojectapp.constants.RestApi.*;
@RestController
@RequestMapping(CITIZEN)
@RequiredArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @PostMapping(SAVE)
    public ResponseEntity<Citizen> save(@RequestBody @Valid CitizenAddRequest dto) {
        return ResponseEntity.ok(citizenService.save(dto));

    }

    @PostMapping(ADDCHILDREN)
    public ResponseEntity<Citizen> addChildren(@RequestBody @Valid CitizenAddChildrenRequest dto){
        return ResponseEntity.ok(citizenService.addChildren(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Citizen> update(@RequestBody @Valid Citizen citizen){
        return ResponseEntity.ok(citizenService.update(citizen));
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<Void> deleteById(Long id) {
        citizenService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<FindAllResponse>> findAll() {
        return ResponseEntity.ok(citizenService.findAllResponse());
    }

    @GetMapping(FINDBYID+"/{id}")
    public ResponseEntity<Citizen> findById(@PathVariable Long id) {
        return ResponseEntity.ok(citizenService.findById(id).get());
    }

}
