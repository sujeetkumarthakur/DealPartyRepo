package com.bs.deal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.bs.party.PartyDetails;
import com.bs.party.PartyRepo;

@Service
public class DealServiceImpl implements DealServiceI{
	@Autowired
	private DealRepo repo;
	@Override
	public Deal createDeal(Deal deal) {
		return repo.save(deal);
	}

	@Override
	public Deal updateDeal(Deal deal) {
		Optional<Deal> existed = repo.findById(deal.getDealId());
		Deal existedObj = null;
		if (existed.isPresent()) {
			existedObj = existed.get();
			existedObj.setAccountName(deal.getAccountName());
			existedObj.setAgreementDate(deal.getAgreementDate());
			existedObj.setDetalis(deal.getDetalis());
			existedObj.setFacilityLetterDate(deal.getFacilityLetterDate());
			existedObj.setProduct(deal.getProduct());
			existedObj.setSanctionLetterDate(deal.getSanctionLetterDate());
			existedObj.setState(deal.getState());
			//add new children
			addNewChildren(deal, existedObj);
			repo.save(existedObj);
		}
		return existedObj;
	}

	private void addNewChildren(Deal newdealObject, Deal existedObj) {
		long existedChildrenCount= existedObj.getChildren().stream().count();
		long newChildrenCount = newdealObject.getChildren().stream().count();
		if(newChildrenCount!=existedChildrenCount)
			existedObj.getChildren().addAll(newdealObject.getChildren());
		
	}

	@Override
	public void deleteDealById(int id) {
		Optional<Deal> existed = repo.findById(id);
		if (existed.isPresent()) {
			repo.deleteById(id);
		}
	}

	@Override
	public List<Deal> getAllDeal() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Deal getDealById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
