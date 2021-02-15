package com.senior.test.senior.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.senior.test.senior.exception.ResourceNotFoundException;
import com.senior.test.senior.model.hospede;
import com.senior.test.senior.repository.hospedeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 
@RestController
@RequestMapping("/api")
public class hospedeController{

	@Autowired
	private hospedeRepository hospedeRepository;

	@GetMapping("/hospedes")
	public List<hospede> getAllhospedes() {
		return hospedeRepository.findAll();
	}

	@GetMapping("/hospedes/{id}")
	public ResponseEntity<hospede> gethospedeById(@PathVariable(value = "id") Long hospedeId)
			throws ResourceNotFoundException {
		hospede hospede = hospedeRepository.findById(hospedeId)
				.orElseThrow(() -> new ResourceNotFoundException("hospede not found for this id :: " + hospedeId));
		return ResponseEntity.ok().body(hospede);
	}

	@PostMapping("/hospedes")
	public hospede createhospede(@Valid @RequestBody hospede hospede) {
		return hospedeRepository.save(hospede);
	}

	@PutMapping("/hospedes/{id}")
	public ResponseEntity<hospede> updatehospede(@PathVariable(value = "id") Long hospedeId,
			@Valid @RequestBody hospede hospedeDetails) throws ResourceNotFoundException {
		hospede hospede = hospedeRepository.findById(hospedeId)
				.orElseThrow(() -> new ResourceNotFoundException("hospede not found for this id :: " + hospedeId));

		hospede.setNome(hospedeDetails.getNome());
		hospede.setDocumento(hospedeDetails.getDocumento());
		hospede.setTelefone(hospedeDetails.getTelefone());
		final hospede updatedhospede = hospedeRepository.save(hospede);
		return ResponseEntity.ok(updatedhospede);
	}

	@DeleteMapping("/hospedes/{id}")
	public Map<String, Boolean> deletehospede(@PathVariable(value = "id") Long hospedeId)
			throws ResourceNotFoundException {
		hospede hospede = hospedeRepository.findById(hospedeId)
				.orElseThrow(() -> new ResourceNotFoundException("hospede not found for this id :: " + hospedeId));

		hospedeRepository.delete(hospede);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}