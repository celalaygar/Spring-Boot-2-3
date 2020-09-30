package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "building")
public class Building {

	
	
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_building", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_building")
    private Long id;
    @Column(name = "building_name", unique = true,length = 5000)
    private String buildingName;
    @Column(name = "building_adress", length = 5000)
    private String buildingAdress;
    @Column(name = "createdAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Column(name = "start_date", unique = true)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "building")
    private BuildingAdress adress;
    
//    @Column(name = "alim_zamani", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date alimZamani;
}
