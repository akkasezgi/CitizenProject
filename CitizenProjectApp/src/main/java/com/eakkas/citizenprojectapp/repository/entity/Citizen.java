package com.eakkas.citizenprojectapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblcitizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_citizen")
    private boolean isCitizen;

    @Column(name = "name",length = 50)
    private String name;

    @OneToMany
    @JoinColumn(name = "childrenId", referencedColumnName = "id")
    List<Citizen> children;

    private boolean hasDrivingLicence;
}
