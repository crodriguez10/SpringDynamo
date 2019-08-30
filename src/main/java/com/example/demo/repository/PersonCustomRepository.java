/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Person;
import java.util.List;

/**
 *
 * @author cesar.rodriguez
 */
public interface PersonCustomRepository {
    List<Person> findPersonByCellphoneCustom(String cellphone);
    List<Person> scanPersonByCellphoneCustom(String cellphone);
    List<Person> scanPersonByOcupationNameCustom(String nameOcupation);
}
