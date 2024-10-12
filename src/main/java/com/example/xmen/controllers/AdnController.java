package com.example.xmen.controllers;


import com.example.xmen.dtos.AdnRequest;
import com.example.xmen.entities.Adn;
import com.example.xmen.services.AdnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/adn/")
public class AdnController extends BaseControllerImpl<Adn, AdnServiceImpl>{
    private AdnServiceImpl adnService;
    @Autowired
    public AdnController(AdnServiceImpl adnService){
        this.adnService= adnService;
    }

    @PostMapping("/mutant/")
    public ResponseEntity<String> isMutant(@RequestBody AdnRequest adnRequest) {
        try {
            String[] adn = adnRequest.getAdn();
            // Verificamos si la secuencia es valida
            if (adn==null || adn.length == 0) {
                return new ResponseEntity<>("Secuencia de ADN invalida", HttpStatus.BAD_REQUEST);
            }
            //Si es mutante, HTTP 200
            if(adnService.isMutant(adn)){
                return new ResponseEntity<>("Es mutante", HttpStatus.OK);
            }else {
                //Si no es mutante, HTTP 403
                return new ResponseEntity<>("No es mutante", HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            // Si hay ADN inválido, HTTP 400
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/mutantSave")
    public ResponseEntity<?> saveDNA(@RequestBody AdnRequest adnRequest) {
        try {
            //Recupero el adn que viene del post
            String[] adn = adnRequest.getAdn();
            //Verifico si es mutante
            boolean esMutante = adnService.isMutant(adn);
            //Creo un adn y lo asigno
            Adn entity = new Adn();
            entity.setMutante(esMutante);
            entity.setAdn(adn);
            //Guardo el adn
            Adn entidad = servicio.save(entity);
            if (entidad.isMutante()) {
                return ResponseEntity.status(HttpStatus.OK).body("Es mutante");
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es mutante");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        Map<String, Object> stats = adnService.getStats();
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }

}


