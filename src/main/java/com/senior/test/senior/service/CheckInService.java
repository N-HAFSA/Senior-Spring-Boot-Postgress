package com.senior.test.senior.service;

import java.util.ArrayList;
import java.util.List;

import com.senior.test.senior.model.CheckIn;
import com.senior.test.senior.repository.CheckInRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {
    @Autowired
    private CheckInRepository checkinRepository;

    public List<CheckIn> findAll() {

        var it = checkinRepository.findAll();

        var checkin = new ArrayList<CheckIn>();
        it.forEach(e -> checkin.add(e));

        return checkin;
    }

    public Long count() {

        return checkinRepository.count();
    }

    public void deleteById(Long checkinId) {

        checkinRepository.deleteById(checkinId);
    }

    public boolean saveCheckIn(CheckIn checkin){
        boolean status=false;
		try {
			checkinRepository.save(checkin);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
        
    }
	
}
