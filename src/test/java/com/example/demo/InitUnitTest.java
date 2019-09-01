/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.example.demo.model.Person;

import com.example.demo.repository.PersonRepository;

import org.junit.Before;
import org.junit.Test;
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
public class InitUnitTest {
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    PersonRepository personRepository;

    @Before
    public void setup() throws Exception {

        System.err.println("before");

        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);

        Table table = dynamoDB.getTable("test");

        try {
            System.out.println("Attempting to delete table; please wait...");
            table.delete();
            table.waitForDelete();
            System.out.print("Success.");

        } catch (Exception e) {
            System.err.println("Unable to delete table: ");
            System.err.println(e.getMessage());
        }
        try {

            if (TableUtils.createTableIfNotExists(amazonDynamoDB, new DynamoDBMapper(amazonDynamoDB).generateCreateTableRequest(com.example.demo.model.Test.class)
                    .withProvisionedThroughput(new ProvisionedThroughput(1L, 1L)))) {
                System.out.println("create table");
                TableUtils.waitUntilActive(amazonDynamoDB, "Test");
            } else {
                System.out.println("exist table test");
            }
        } catch (Exception e) {
            System.err.println("error: " + e);
        }

        try {
            if (TableUtils.createTableIfNotExists(amazonDynamoDB, new DynamoDBMapper(amazonDynamoDB).generateCreateTableRequest(Person.class)
                    .withProvisionedThroughput(new ProvisionedThroughput(1L, 1L)))) {
                System.out.println("create table peroson");
                TableUtils.waitUntilActive(amazonDynamoDB, "Person");
            } else {
                System.out.println("exist table Person");
            }
        } catch (Exception e) {
            System.err.println("error: " + e);
        }

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Person. For example:
    //
    @Test
    public void hello() {
        System.out.println("hello");
    }
}
