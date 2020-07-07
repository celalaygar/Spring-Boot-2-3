package com.example.demo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Kullanici;
import com.example.demo.repo.KullaniciRepository;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {

	@Autowired
	private KullaniciRepository kullaniciRepository;
	
	@PostConstruct
	void init () {
		Kullanici kullanici = new Kullanici();
		kullanici.setAdi("Celal");
		kullanici.setSoyadi("Aygar");
		System.out.println("-------------");
		kullaniciRepository.save(kullanici);
		System.out.println("-------------");
	}
	
	@PostMapping
	public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici) {
		return ResponseEntity.ok(kullaniciRepository.save(kullanici));
	}
	
	@GetMapping
	public ResponseEntity<List<Kullanici>> listele( ) {
		return ResponseEntity.ok(kullaniciRepository.findAll());
	}
}
