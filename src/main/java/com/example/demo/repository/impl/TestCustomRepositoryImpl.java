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
import com.example.demo.model.Test;
import com.example.demo.repository.TestCustomRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cesar.rodriguez
 */
@Component
public class TestCustomRepositoryImpl implements TestCustomRepository{

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
    
    @Override
    public List<Test> findByMyIdAndName(String myId, String nameTest) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":v_myId", new AttributeValue().withS(myId));
        valueMap.put(":v_name", new AttributeValue().withS(nameTest));
        DynamoDBQueryExpression<Test> queryExpression = new DynamoDBQueryExpression<Test>()
                .withKeyConditionExpression("myId = :v_myId and begins_with(nameTest, :v_name)")
                .withExpressionAttributeValues(valueMap);
        try{
            return new DynamoDBMapper(amazonDynamoDB).query(Test.class, queryExpression);
        }catch(Exception e){
            System.out.println("Error: "+e);
            return null;
        }
    }
    
    @Override
    public List<Test> findByMyIdAndDesc(String myId, String nameTest, String descTest) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":v_myId", new AttributeValue().withS(myId));
        valueMap.put(":v_name", new AttributeValue().withS(nameTest));
        valueMap.put(":v_desc", new AttributeValue().withS(descTest));
        DynamoDBQueryExpression<Test> queryExpression = new DynamoDBQueryExpression<Test>()
                .withKeyConditionExpression("myId = :v_myId and begins_with(nameTest, :v_name)")
                .withFilterExpression("descTest = :v_desc")
                .withExpressionAttributeValues(valueMap);
        try{
            return new DynamoDBMapper(amazonDynamoDB).query(Test.class, queryExpression);
        }catch(Exception e){
            System.out.println("Error: "+e);
            return null;
        }
    }

    @Override
    public void saveCustom(Test test) {
        new DynamoDBMapper(amazonDynamoDB).save(test);
    }
    
    @Override
    public List<Test> findAllCustom(){
        return new DynamoDBMapper(amazonDynamoDB).scan(Test.class, new DynamoDBScanExpression());
    }
    
}
