package com.senior.test.senior.service;

import java.util.ArrayList;
import java.util.List;

import com.senior.test.senior.model.hospede;
import com.senior.test.senior.repository.hospedeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class hospedeService {

    @Autowired
    private hospedeRepository hospedeRepository;

    public List<hospede> findAll() {

        var it = hospedeRepository.findAll();

        var hospede = new ArrayList<hospede>();
        it.forEach(e -> hospede.add(e));

        return hospede;
    }

    public Long count() {

        return hospedeRepository.count();
    }

    public void deleteById(Long hospedeId) {

        hospedeRepository.deleteById(hospedeId);
    }

    public boolean saveHospede(hospede hospede){
        boolean status=false;
		try {
			hospedeRepository.save(hospede);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
        
    }
}
