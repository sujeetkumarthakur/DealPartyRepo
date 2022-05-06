package com.bs.party;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController {

	@Autowired
	private PartyServiceI service;
	@Autowired
	private PartyRepo repo;
	
	@GetMapping("/get")
	public PartyDetails get() {
		return new PartyDetails(12,"party1", "part1@gmail.com", "1234567899", "party type 1", "larven", "morshi", "morshi");
	}
	
	@PostMapping("/createPartyDetails")
	public PartyDetails createPartyDetails(@RequestBody PartyDetails obj) {
		return service.createPartyDetails(obj);
	}
	@PutMapping("/updatePartyDetails")
	public PartyDetails updatePartyDetails(@RequestBody PartyDetails obj) {
		return service.updatePartyDetails(obj);
	}
	
	@GetMapping("/delete/{id}")
	public String deletePartyDetailsById(@PathVariable("id") int surgeonId) {
		service.deletePartyDetailsById(surgeonId);
		return "Deleted";
	}
	@GetMapping("/getAll")
	public List<PartyDetails> getAllPartyDetails() {
		return service.getAllPartyDetails();
	}
	
	@GetMapping("getAll/{branch}")
	public List<PartyDetails> getCustom(@PathVariable("branch") String branch) {
		return repo.getbyBranch(branch);
	}
	
	
	
	
}
