package com.bs.deal;

import java.util.List;


public interface DealServiceI {
	public Deal createDeal(Deal deal) ;
	public Deal updateDeal(Deal deal);
	public void deleteDealById(int id);
	public List<Deal> getAllDeal() ;
	public Deal getDealById(int id);
}
