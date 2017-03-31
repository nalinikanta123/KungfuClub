package org.maru.classMain;

import java.util.ArrayList;
import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.maru.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

	@Autowired
	public ClassRepository classRepository;

	// 1. Service to get all rank information
	public List<Class> getAllClass() {
		List<Class> classObj = new ArrayList<Class>();
		classRepository.findAll().forEach(classObj::add);
		return classObj;
	}
	
	//2. Add new rank information
	public void addClass(Class classObj){
		classRepository.save(classObj);
	}
	
}
