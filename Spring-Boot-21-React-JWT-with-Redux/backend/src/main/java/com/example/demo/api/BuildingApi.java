package com.example.demo.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BuildingDto;
import com.example.demo.service.BuildingService;
import com.example.demo.util.ApiPaths;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.BuildingCtrl.CTRL)
@CrossOrigin
public class BuildingApi {

	private final BuildingService buildingService;
	
	@GetMapping
	public ResponseEntity<List<BuildingDto>> getAll() throws Exception{
		return ResponseEntity.ok(buildingService.getAll());
	}
	@PostMapping
	public ResponseEntity<BuildingDto> save(@RequestBody BuildingDto dto) throws Exception{
		return ResponseEntity.ok(buildingService.save(dto));
	}
}
