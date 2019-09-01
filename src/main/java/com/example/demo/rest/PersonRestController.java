/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar.rodriguez
 */
@RestController
@RequestMapping("/persons")

public class PersonRestController {

    public static final Log LOGGER = LogFactory.getLog(PersonRestController.class);

    @Autowired
    private PersonService personService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity findAllPerson() {
        try {
            return ResponseEntity.ok(personService.findPersons());
        } catch (Exception e) {
            LOGGER.info("error findAll: " + e);
            return ResponseEntity.badRequest().build();
        }

    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createPerson(@RequestBody Person person) {
        try {
            personService.savePerson(person);
            return ResponseEntity.ok(this);
        } catch (Exception e) {
            LOGGER.info("error savePerson: " + e);
            return ResponseEntity.badRequest().build();
        }
    }
    
    @RequestMapping(value = "/findByEdad/{edad}", method = RequestMethod.GET)
    public ResponseEntity findByEdad(@RequestParam int edad) {
        try {
            personService.findByEdad(edad);
            return ResponseEntity.ok(this);
        } catch (Exception e) {
            LOGGER.info("error findByEdad: " + e);
            return ResponseEntity.badRequest().build();
        }
    }
    
    @RequestMapping(value = "/findByCellphone/{cellphone}", method = RequestMethod.GET)
    public ResponseEntity findByCellphone(@RequestParam String cellphone) {
        try {
            return ResponseEntity.ok(personService.findByCellphone(cellphone));
        } catch (Exception e) {
            LOGGER.info("error findByCelphone: " + e);
            return ResponseEntity.badRequest().build();
        }
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePerson(@RequestParam String id){
        try{
            personService.deleteById(id);
            return ResponseEntity.ok(this);
        }catch(Exception e){
            LOGGER.info("error eliminando registro persona: "+e);
            return ResponseEntity.badRequest().build();
        }
    }
    

}
