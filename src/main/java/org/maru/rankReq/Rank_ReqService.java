package org.maru.rankReq;

import java.util.ArrayList;
import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.maru.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rank_ReqService {

	@Autowired
	public Rank_ReqRepository rankReqRepository;

	// 1. Service to get all rank information
	public List<Rank_Req> getAllRankReq() {
		List<Rank_Req> rankReq = new ArrayList<Rank_Req>();
		rankReqRepository.findAll().forEach(rankReq::add);
		return rankReq;
	}
	
	//2. Add new rank information
	public void addRankReq(Rank_Req rankReq){
		rankReqRepository.save(rankReq);
	}
	
}
