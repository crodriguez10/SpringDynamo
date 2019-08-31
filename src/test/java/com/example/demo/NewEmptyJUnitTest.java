/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TestCustomRepository;
import com.example.demo.repository.TestRepository;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author cesar.rodriguez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NewEmptyJUnitTest {
    
    @Autowired
    PersonRepository personRepository;
    //@Autowired
    //TestRepository testRepository;
    @Autowired
    TestCustomRepository testCustomRepository;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        System.out.println("test scann");
        List<Person> person = personRepository.findPersonByCellphoneCustom("3205974842");
        person.forEach(System.out::println);
    }
    
     @Test
    public void getByCellphone() {
        System.err.println("test");
        List<Person> person = personRepository.findByCellphone("320597484");
        /*assertTrue("Not empty", person.size() > 0);
        assertTrue("Contains item with expected cellphone",
                person.get(0).getCellphone().equals(EXPECTED_TEST));*/
        person.forEach(System.out::println);
    }
    
    @Test
    public void searchCustom() {
        System.out.println("search custom");
        List<Person> person = personRepository.scanPersonByOcupationNameCustom("Desarrollador");
        person.forEach(System.out::println);
    }
    
    
    @Test
    public void saveTest(){
        //testRepository.save(new com.example.demo.model.Test("test", "unitTest", "prueba 1", 1));
    }
    
    @Test
    public void searchTestQueryIndexByName(){
        System.out.println("searchTestQueryIndexByName");
        List<com.example.demo.model.Test> testResults = testCustomRepository.findByMyIdAndName("test", "prueba");
        testResults.forEach(System.out::println);
    }
    
    @Test
    public void searchTestQueryIndexByDesc(){
        System.out.println("searchTestQueryIndexByDesc");
        //List<com.example.demo.model.Test> testResults = testCustomRepository.findByMyIdAndDesc("test", "prueba", "desc");
        //testResults.forEach(System.out::println);
    }
    
    @Test
    public void searchTestById(){
        System.out.println("searchTestById");
        //Optional<com.example.demo.model.Test> test = testRepository.findById("1");
        //System.out.println("test: "+test);
    }
}
