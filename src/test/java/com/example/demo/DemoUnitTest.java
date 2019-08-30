/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.example.demo.model.Person;
import com.example.demo.model.ProductInfo;
import com.example.demo.repository.PersonRepository;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author cesar.rodriguez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoUnitTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    PersonRepository personRepository;
    
    private static boolean testTableExist = false;
    private static boolean personTableExist = false;


    @Before
    public void setup() throws Exception {

        System.err.println("before");
        
        if (!testTableExist) {
            if (TableUtils.createTableIfNotExists(amazonDynamoDB, new DynamoDBMapper(amazonDynamoDB).generateCreateTableRequest(com.example.demo.model.Test.class)
                    .withProvisionedThroughput(new ProvisionedThroughput(1L, 1L)))) {
                System.out.println("create table");
                TableUtils.waitUntilActive(amazonDynamoDB, "Tasks");
            } else {
                System.out.println("exist table");
            }
            testTableExist = true;
        }    
        
        /*if (!personTableExist) {
            if (TableUtils.createTableIfNotExists(amazonDynamoDB, new DynamoDBMapper(amazonDynamoDB).generateCreateTableRequest(Person.class)
                    .withProvisionedThroughput(new ProvisionedThroughput(1L, 1L)))) {
                System.out.println("create table");
                TableUtils.waitUntilActive(amazonDynamoDB, "Person");
            } else {
                System.out.println("exist table");
            }
            personTableExist = true;
        } */   
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Person. For example:
    //
    @Test
    public void hello() {
        System.err.println("hello");
    }
}
