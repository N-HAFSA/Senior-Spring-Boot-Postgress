package com.senior.test.senior.controller;

import java.util.List;

import com.senior.test.senior.model.CheckIn;
import com.senior.test.senior.service.CheckInService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CheckInController {
    
    @Autowired
    private CheckInService checkinService;

    @PostMapping("savecheckin")
	public boolean saveCheckin(@RequestBody CheckIn checkin) {
		 return checkinService.saveCheckIn(checkin);
		
	}
    @GetMapping("/checkin")
    public List<CheckIn> allUsers() {

        return checkinService.findAll();
    }

    @GetMapping("/checkin/count")
    public Long count() {

        return checkinService.count();
    }

    @DeleteMapping("/checkin/{id}")
    public void delete(@PathVariable String id) {

        Long checkinId = Long.parseLong(id);
        checkinService.deleteById(checkinId);
    }
}
