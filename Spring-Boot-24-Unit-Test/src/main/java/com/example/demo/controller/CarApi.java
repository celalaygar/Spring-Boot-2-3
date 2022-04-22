package com.example.demo.controller;


import com.example.demo.model.dto.CarDto;
import com.example.demo.service.CarService;
import com.example.demo.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiUtil.CarCtrl.CTRL)
public class CarApi {
    public final CarService carService;

    @PostMapping
    public ResponseEntity<String> getCarType(@RequestBody CarDto dto) {
        return ResponseEntity.ok(carService.getCarType(dto.getType()));
    }
}
