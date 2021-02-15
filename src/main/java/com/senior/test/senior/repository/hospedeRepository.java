package com.senior.test.senior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senior.test.senior.model.hospede;

@Repository
public interface hospedeRepository extends JpaRepository<hospede, Long> {
    
}