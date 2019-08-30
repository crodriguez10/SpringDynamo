/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonCustomRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author cesar.rodriguez
 */
public class PersonCustomRepositoryImpl implements PersonCustomRepository{
   
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
    @Override
    public List<Person> findPersonByCellphoneCustom(String cellphone) {
       
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":v_id", new AttributeValue().withS("186dc3b0-832d-4c1b-be95-480522d18066"));
        valueMap.put(":v_cellphone", new AttributeValue().withS(cellphone));
        DynamoDBQueryExpression<Person> queryExpression = new DynamoDBQueryExpression<Person>()
                .withKeyConditionExpression("id = :v_id")
                .withFilterExpression("cellphone = :v_cellphone")
                .withExpressionAttributeValues(valueMap);
        
        return new DynamoDBMapper(amazonDynamoDB).query(Person.class, queryExpression);
    }

    @Override
    public List<Person> scanPersonByCellphoneCustom(String cellphone) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":v_cellphone", new AttributeValue().withS(cellphone));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("cellphone = :v_cellphone")
                .withExpressionAttributeValues(valueMap);
        return new DynamoDBMapper(amazonDynamoDB).scan(Person.class, scanExpression);
    }
    
    @Override
    public List<Person> scanPersonByOcupationNameCustom(String profesion) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":v_profesion", new AttributeValue().withS(profesion));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("ocupation.profesion = :v_profesion")
                .withExpressionAttributeValues(valueMap);
        return new DynamoDBMapper(amazonDynamoDB).scan(Person.class, scanExpression);
    }
    
    
}
