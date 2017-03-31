package org.maru.student;

import java.util.ArrayList;
import java.util.List;

import org.maru.Topic.Topic;
import org.maru.Topic.TopicRepository;
import org.maru.rank.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// 1. Service to get all Student records
	public List<Student> getAllStudents() {
		List<Student> student = new ArrayList<Student>();
		studentRepository.findAll().forEach(student::add);
		return student;
	}

	//2.insert new record
	public void addStudent(Student student){
		studentRepository.save(student);
	}
}
