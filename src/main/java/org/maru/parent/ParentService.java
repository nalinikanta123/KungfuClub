package org.maru.parent;

import java.util.ArrayList;
import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.maru.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

	@Autowired
	public ParentRepository parentRepository;

	// 1. Service to get all rank information
	public List<Parent> getAllParent() {
		List<Parent> parent = new ArrayList<Parent>();
		parentRepository.findAll().forEach(parent::add);
		return parent;
	}
	
	//2. Add new rank information
	public void addParent(Parent parent){
		parentRepository.save(parent);
	}
	
}
