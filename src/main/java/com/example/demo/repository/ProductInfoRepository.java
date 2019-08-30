package com.example.demo.repository;

import com.example.demo.model.ProductInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@EnableScan
public interface ProductInfoRepository extends CrudRepository<ProductInfo, String> {

}
