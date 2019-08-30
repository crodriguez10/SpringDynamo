/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Person;
import java.io.Serializable;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesar.rodriguez
 */
@EnableScan
public interface PersonRepository extends CrudRepository<Person, String>, PersonCustomRepository{
    
    List<Person> findByAge(int age);
    List<Person> findByCellphone(String cellphone);
    
}
