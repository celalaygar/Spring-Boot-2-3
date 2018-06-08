package com.javaegitimleri.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaegitimleri.app.exception.OwnerNotFoundException;
import com.javaegitimleri.app.model.Personel;
import com.javaegitimleri.app.service.AppService;

@RestController
@RequestMapping("/rest")
public class PersonelClinicRestController {

	@Autowired
	private AppService appService;
	
	//http://localhost:8182/rest/personels
	@GetMapping("/personels")
	public ResponseEntity<List<Personel>> getPersonels(){
		List<Personel> personels=appService.findPersonels();
		return ResponseEntity.ok(personels);
	}
	
	//http://localhost:8182/rest/personel?fn=Celal
	@GetMapping("/personel")
	@RequestMapping(value="/personel",produces= {"application/json"})
	public ResponseEntity<List<Personel>> getPersonels(@RequestParam("fn") String firstname){
		List<Personel> personels=appService.findPersonel(firstname);
		return ResponseEntity.ok(personels);
		
	}
	//http://localhost:8182/rest/personel/5
	//@RequestMapping(value="/personel/{id}",produces= {"application/xml"})
	@RequestMapping(value="/personel/{id}")
	public ResponseEntity<Personel> getPersonel(@PathVariable("id") Long id){
		try {
			Personel personels=appService.findPersonel(id);
			return ResponseEntity.ok(personels);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete personel
	@RequestMapping(method=RequestMethod.DELETE,value="/personel/{id}")
	public ResponseEntity<?> deletePersonel(@PathVariable("id") Long id){
		
		try {
			appService.delete(id);
			
			return ResponseEntity.ok().build();
			
		} catch (OwnerNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	} 
	
	
	
	// update personel
	@RequestMapping(method=RequestMethod.PUT,value="/personel/{id}")
	public ResponseEntity<List<Personel>> updatePersonels(@PathVariable("id") Long id, @RequestBody Personel personel){
		try {
			Personel p=appService.findPersonel(id);
			p.setFirstname(personel.getFirstname());
			p.setLastname(personel.getLastname());
			appService.update(p);
			return ResponseEntity.ok().build();
		} catch (OwnerNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
