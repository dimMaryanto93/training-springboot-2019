/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeladata.training.demospringboot.controller;

import com.tabeladata.training.demospringboot.dto.AgamaDto;
import com.tabeladata.training.demospringboot.entity.Agama;
import com.tabeladata.training.demospringboot.repository.AgamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dimasm93
 */
@RestController
@RequestMapping("/api/contoh")
public class RestControllerApi {
    
    @Autowired
    private AgamaRepository repository;
    
    @GetMapping("/{id}")
    public ResponseEntity<Agama> get(@PathVariable("id")Integer id){
        Agama agama = repository.findById(id);
        return ResponseEntity.ok(agama);             
    }
    
    @PostMapping("/")
    public ResponseEntity<Agama> create(@RequestBody Agama agama){        
        return ResponseEntity.ok(agama);
    }
    
}
