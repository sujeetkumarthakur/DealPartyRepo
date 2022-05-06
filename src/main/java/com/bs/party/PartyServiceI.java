package com.bs.party;

import java.util.List;

public interface PartyServiceI {
	public PartyDetails createPartyDetails(PartyDetails partyDetails) ;
	
	public PartyDetails updatePartyDetails(PartyDetails partyDetails);
	public void deletePartyDetailsById(int id);
	public List<PartyDetails> getAllPartyDetails() ;
}
