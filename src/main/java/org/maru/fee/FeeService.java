package org.maru.fee;

import java.util.ArrayList;
import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.maru.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeService {

	@Autowired
	public FeeRepository feeRepository;

	// 1. Service to get all rank information
	public List<Fee> getAllFees() {
		List<Fee> fee = new ArrayList<Fee>();
		feeRepository.findAll().forEach(fee::add);
		return fee;
	}
	
	//2. Add new rank information
	public void addFees(Fee fee){
		feeRepository.save(fee);
	}
	
}
