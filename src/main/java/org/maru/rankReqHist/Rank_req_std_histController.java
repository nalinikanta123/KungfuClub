package org.maru.rankReqHist;

import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rank_req_std_histController {

	@Autowired
	public Rank_req_std_histService rankReqHistService;

	// 1. Get all rank records
	@RequestMapping("/rankReqHist")
	public List<Rank_req_std_hist> getAllRankReqHist() {
		return rankReqHistService.getAllRankReqHist();
	}

	// 2.Add new Rank
	@RequestMapping(value = "/rankReqHist", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRankReqHist(@RequestBody Rank_req_std_hist rankReqHist) {
		System.out.println("RankReqHist Date recieved= " + rankReqHist.dt_achieved);
		rankReqHistService.addRankReqHist(rankReqHist);
	}

	// 2. Get all rank req hist records of student
	@RequestMapping("/rankReqHist/stud/{id}")
	public List<Rank_req_std_hist> getStudentReqHist(@PathVariable int id) {
		return rankReqHistService.getStudentReqHist(id);
	}
}
