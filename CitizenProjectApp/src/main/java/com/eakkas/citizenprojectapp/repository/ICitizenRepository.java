package com.eakkas.citizenprojectapp.repository;

import com.eakkas.citizenprojectapp.repository.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICitizenRepository extends JpaRepository<Citizen, Long> {


}
