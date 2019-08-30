/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar.rodriguez
 */
@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public List<Person> findPersons(){
        return (List<Person>) personRepository.findAll();
    }
    
    public void savePerson(Person person){
        personRepository.save(person);
    }
    
    public List<Person> findByEdad(int edad){
        return personRepository.findByAge(edad);
    }
    
    public List<Person> findByCellphone(String cellphone){
        return personRepository.findByCellphone(cellphone);
        //return personRepository.findPersonByCellphoneCustom(cellphone);
    }
    
    public void deleteById(String id){
        personRepository.deleteById(id);
    }
    
}
