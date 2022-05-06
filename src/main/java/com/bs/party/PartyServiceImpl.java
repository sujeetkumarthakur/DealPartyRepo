package com.bs.party;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyServiceI {
	@Autowired
	private PartyRepo repo;

	@Override
	public PartyDetails createPartyDetails(PartyDetails partyDetails) {
		return repo.save(partyDetails);
	}

	@Override
	public PartyDetails updatePartyDetails(PartyDetails partyDetails) {
		Optional<PartyDetails> existed = repo.findById(partyDetails.getPartyId());
		PartyDetails existedObj = null;
		if (existed.isPresent()) {
			existedObj = existed.get();
			existedObj.setAddress(partyDetails.getAddress());
			existedObj.setBranch(partyDetails.getBranch());
			existedObj.setEmail(partyDetails.getEmail());
			existedObj.setMobileNumber(partyDetails.getMobileNumber());
			existedObj.setName(partyDetails.getName());
			existedObj.setPartySignatureName(partyDetails.getPartySignatureName());
			existedObj.setPartyType(partyDetails.getPartyType());
			repo.save(existedObj);
		}
		return existedObj;
	}

	@Override
	public void deletePartyDetailsById(int id) {
		Optional<PartyDetails> existed = repo.findById(id);
		if (existed.isPresent()) {
			repo.deleteById(id);
		}
	}

	@Override
	public List<PartyDetails> getAllPartyDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
