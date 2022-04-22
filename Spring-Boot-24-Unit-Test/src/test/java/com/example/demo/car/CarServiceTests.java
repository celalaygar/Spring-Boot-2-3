package com.example.demo.car;

import com.example.demo.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CarServiceTests {

    @Autowired
    CarService carService;

    @DisplayName("Cabrio Correct Test by Spring @Autowired Integration")
    @Test
    void cabrioCorrectTest() {
        Assertions.assertEquals("Cabrio Car has produced.", carService.getCarType("cabrio"));
    }

    @DisplayName("Cabrio Incorrect Test by Spring @Autowired Integration")
    @Test
    void cabrioIncorrectTest() {
        Assertions.assertNotEquals("Cabrio Car has produced. 1", carService.getCarType("cabrio"));
    }

    @DisplayName("Sedan Correct Test by Spring @Autowired Integration")
    @Test
    void sedanCorrectTest() {
        Assertions.assertEquals("Sedan Car has produced.", carService.getCarType("sedan"));
    }

    @DisplayName("Sedan Incorrect Test by Spring @Autowired Integration")
    @Test
    void sedanIncorrectTest() {
        Assertions.assertNotEquals("Sedan Car has produced. 1", carService.getCarType("sedan"));
    }

    @DisplayName("Hatchback Correct Test by Spring @Autowired Integration")
    @Test
    void hatchbackCorrectTest() {
        Assertions.assertEquals("Hatchback Car has produced.", carService.getCarType("hatchback"));
    }

    @DisplayName("Hatchback Incorrect Test by Spring @Autowired Integration")
    @Test
    void hatchbackIncorrectTest() {
        Assertions.assertNotEquals("Hatchback Car has produced. 1", carService.getCarType("hatchback"));
    }

    @DisplayName("Incorrect Test by Spring @Autowired Integration")
    @Test
    void incorrectTest() {
        Assertions.assertNotEquals("Incorrect Car has produced.", carService.getCarType("Incorrect"));
    }

    @DisplayName("Correct Test by Spring @Autowired Integration")
    @Test
    void correctTest() {
        Assertions.assertEquals(null, carService.getCarType("Correct"));
    }
}
