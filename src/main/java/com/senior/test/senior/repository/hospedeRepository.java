package com.senior.test.senior.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.senior.test.senior.model.hospede;

@Repository
public interface hospedeRepository extends CrudRepository<hospede, Long> {

}