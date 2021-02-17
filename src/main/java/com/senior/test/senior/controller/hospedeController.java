package com.senior.test.senior.controller;

import java.util.List;

import com.senior.test.senior.model.hospede;
import com.senior.test.senior.service.hospedeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class hospedeController{


	@Autowired
    private hospedeService hospedeService;

    @GetMapping("/hospedes")
    public List<hospede> allUsers() {

        return hospedeService.findAll();
    }

    @GetMapping("/hospedes/count")
    public Long count() {

        return hospedeService.count();
    }

    @DeleteMapping("/hospedes/{id}")
    public void delete(@PathVariable String id) {

        Long hospedeId = Long.parseLong(id);
        hospedeService.deleteById(hospedeId);
    }
}