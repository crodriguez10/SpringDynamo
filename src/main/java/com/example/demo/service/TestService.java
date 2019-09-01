/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Test;
import com.example.demo.repository.TestCustomRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar.rodriguez
 */
@Service
public class TestService {
    
    @Autowired
    private TestCustomRepository testCustomRepository;
    
    public List<Test> findAllTest(){
        return testCustomRepository.findAllCustom();
    }
    
    public void saveTest(Test test){
        testCustomRepository.saveCustom(test);
    }
}
