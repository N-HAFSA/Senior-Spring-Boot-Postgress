package com.senior.test.senior.repository;

import com.senior.test.senior.model.CheckIn;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends CrudRepository<CheckIn, Long> {
    
}
