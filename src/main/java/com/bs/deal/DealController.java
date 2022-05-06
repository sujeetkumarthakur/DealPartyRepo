package com.bs.deal;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.party.PartyDetails;

@RestController
@RequestMapping("/deal")
public class DealController {
	
	@Autowired
	private DealServiceI service;

	@GetMapping("/getDeal")
	public Deal gt() {
		Set<PartyDetails> children=new HashSet<PartyDetails>();
		children.add(new PartyDetails(52, "Ankur", "ankur@gmail.com", "1234567899", "type 1", "ankur", "Morshi", "Morshi branch"));
		children.add(new PartyDetails(23, "Nikhil", "nikhil@gmail.com", "8888888888", "type 2", "Nikhil", "Nagpur", "Nagpur branch"));
		children.add(new PartyDetails(33, "Sujit", "Sujit@gmail.com", "9999999999", "type 3", "Sujit", "UP", "UP branch"));
		Deal deal=new Deal(12,"Product1","12/5/2012","12/12/2022","Account1","MH","12/12/2015","descrition",children);
		return deal;
	}
	
	@PostMapping("/createDeal")
	public Deal createDeal(@RequestBody Deal deal) {
		return service.createDeal(deal);
	}
	@PutMapping("/updateDeal")
	public Deal updateDeal(@RequestBody Deal deal) {
		return service.updateDeal(deal);
	}

	@GetMapping("/deleteDealById/{id}")
	public void deleteDealById(@PathVariable("id") int id) {
		service.deleteDealById(id);
	}
	@GetMapping("/getAllDeal")
	public List<Deal> getAllDeal() {
		// TODO Auto-generated method stub
		return service.getAllDeal();
	}
	
	@GetMapping("/getDealById/{id}")
	public Deal getDealById(@PathVariable("id")  int id) {
		// TODO Auto-generated method stub
		return service.getDealById(id);
	}

}
