package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.BuildingDto;
import com.example.demo.model.Building;
import com.example.demo.repo.BuildingRepository;
import com.example.demo.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingService {
	private final BuildingRepository buildingRepository;
	private final ModelMapper mapper;
	private final Logger logger;
	
	public List<BuildingDto> getAll() throws Exception{
		List<Building> entityList = buildingRepository.findAll();
		BuildingDto [] dtoArrays = mapper.map(entityList, BuildingDto[].class);
		return Arrays.asList(dtoArrays);
	}
	
	@Transactional
	public BuildingDto save(BuildingDto dto) throws Exception{
		Building building = mapper.map(dto, Building.class);
		building = buildingRepository.save(building);
		dto.setId(building.getId());
		return dto;
	}
}
