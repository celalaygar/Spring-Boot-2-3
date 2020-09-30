package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "building_adress")
public class BuildingAdress {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_building_adress", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_building_adress")
    private Long id;
    private String city;
    private String district;
    private String quarter;
    private String street;
    private String doorNo;
    private String image;
    //private String buildingId;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
}
