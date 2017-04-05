package org.maru.rank;

import java.util.ArrayList;
import java.util.List;


import org.maru.student.Student;
import org.maru.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankService {

	@Autowired
	public RankRepository rankRepository;

	// 1. Service to get all rank information
	public List<Rank> getAllRanks() {
		List<Rank> rank = new ArrayList<Rank>();
		rankRepository.findAll().forEach(rank::add);
		return rank;
	}
	
	//2. Add new rank information
	public void addRank(Rank rank){
		rankRepository.save(rank);
	}
	
}
