package org.maru.instructor;

import java.util.ArrayList;
import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.maru.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

	@Autowired
	public InstructorRepository instructorRepository;

	// 1. Service to get all rank information
	public List<Instructor> getAllInstructor() {
		List<Instructor> instructor = new ArrayList<Instructor>();
		instructorRepository.findAll().forEach(instructor::add);
		return instructor;
	}
	
	//2. Add new rank information
	public void addInstructor(Instructor instructor){
		instructorRepository.save(instructor);
	}
	
}
