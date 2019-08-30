/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;

import com.example.demo.model.Person;
import com.example.demo.model.Test;
import static com.example.demo.rest.PersonRestController.LOGGER;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar.rodriguez
 */
@RestController
@RequestMapping("/tests")
public class TestRestController {
    
    
    @Autowired
    private TestService testService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity findAllTest() {
        try {
            return ResponseEntity.ok(testService.findAllTest());
        } catch (Exception e) {
            LOGGER.info("error findAllTest: " + e);
            return ResponseEntity.badRequest().build();
        }

    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createPerson(@RequestBody Test test) {
        try {
            testService.saveTest(test);
            return ResponseEntity.ok(this);
        } catch (Exception e) {
            LOGGER.info("error saveTest: " + e);
            return ResponseEntity.badRequest().build();
        }
    }
    
}
