package com.bs.party;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepo extends JpaRepository<PartyDetails, Integer> {
	@Query(value = "select t  from PartyDetails t where branch like :branch")
	public List<PartyDetails> getbyBranch(@Param("branch") String branch);
	

}
