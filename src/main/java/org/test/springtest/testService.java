package org.test.springtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestService {
	@Autowired
	private TestRepository testRepository;
	
	public List<Test> getAllTest(){
		List<Test> tests= new ArrayList<Test>();
		testRepository.findAll().forEach(tests::add);
		return tests;
	}
	
	
	public Test getByTestName(String name){
		return testRepository.findOne(name);
	}
	
	public void addTopic(Test test){
		testRepository.save(test);
	}
	
}
