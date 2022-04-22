package com.example.demo.car;

import com.example.demo.model.dto.CarDto;
import com.example.demo.util.ApiUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarApiTests {
    @LocalServerPort
    private int port;

    private static final String BASE_LINK = "http://localhost:";

    @Autowired
    private TestRestTemplate restTemplate;


    @DisplayName("Cabrio Correct Test by Car API")
    @Test
    public void cabrioCorrectTestByCarAPI() throws Exception {
        CarDto dto = new CarDto();
        dto.setType("Cabrio");
        Assertions.assertEquals("Cabrio Car has produced.",  this.getResponseBody(dto));
    }

    @DisplayName("Cabrio Incorrect Test by Car API")
    @Test
    public void cabrioIncorrectTestByCarAPI() throws Exception {
        CarDto dto = new CarDto();
        dto.setType("Cabrio 1");
        Assertions.assertNotEquals("Cabrio Car has produced.",  this.getResponseBody(dto));
    }

    @DisplayName("Sedan Correct Test by Car API")
    @Test
    public void sedanCorrectTestByCarAPI() throws Exception {
        CarDto dto = new CarDto();
        dto.setType("sedan");
        Assertions.assertEquals("Sedan Car has produced.",  this.getResponseBody(dto));
    }

    @DisplayName("Sedan Incorrect Test by Car API")
    @Test
    public void sedanIncorrectTestByCarAPI() throws Exception {
        CarDto dto = new CarDto();
        dto.setType("sedan 1");
        Assertions.assertNotEquals("Cabrio Car has produced.",  this.getResponseBody(dto));
    }
    @DisplayName("Incorrect Test by Car API")
    @Test
    public void incorrectTestByCarAPI() throws Exception {
        CarDto dto = new CarDto();
        dto.setType("Incorrect");
        Assertions.assertNotEquals("Cabrio Car has produced.",  this.getResponseBody(dto));
    }
    @DisplayName("Correct Test by Car API For result Null")
    @Test
    public void correctTestByCarAPIForResultNull() throws Exception {
        CarDto dto = new CarDto();
        Assertions.assertEquals(null,  this.getResponseBody(dto));
    }
    @DisplayName("Incorrect Test by Car API For Request Null")
    @Test
    public void incorrectTestByCarAPIForRequestNull() throws Exception {
        CarDto dto = new CarDto();
        Assertions.assertNotEquals("not null", this.getResponseBody(dto));
    }

    private String getResponseBody(CarDto dto )throws Exception {
        ResponseEntity<String> response = restTemplate.postForEntity(
                new URL(BASE_LINK + port + "/"+ ApiUtil.CarCtrl.CTRL).toString(),dto, String.class);
        return response.getBody();
    }
}
