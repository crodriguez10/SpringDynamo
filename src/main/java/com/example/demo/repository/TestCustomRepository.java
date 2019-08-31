/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Test;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cesar.rodriguez
 */
public interface TestCustomRepository {
    
    List<Test> findByMyIdAndName(String myId, String nameTest );
    List<Test> findByMyIdAndDesc(String myId, String nameTest, String descTest );
    void save(Test test);
    List<Test> findAll();
}
