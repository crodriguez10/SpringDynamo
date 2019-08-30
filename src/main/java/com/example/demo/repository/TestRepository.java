/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Test;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cesar.rodriguez
 */
//@EnableScan
public interface TestRepository {//extends CrudRepository<Test, String>, TestCustomRepository {
    
}
