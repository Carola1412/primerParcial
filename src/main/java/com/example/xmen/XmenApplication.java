package com.example.xmen;

import com.example.xmen.repositories.AdnRepository;
import com.example.xmen.repositories.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com/example/xmen/entities")
@SpringBootApplication
public class XmenApplication {
	private static final Logger logger = LoggerFactory.getLogger(XmenApplication.class);

	/*Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private AdnRepository adnRepository;*/


	public static void main(String[] args) {
		SpringApplication.run(XmenApplication.class, args);

		System.out.println("funcionando");
	}

}




