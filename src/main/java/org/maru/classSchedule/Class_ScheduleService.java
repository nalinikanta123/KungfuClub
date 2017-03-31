package org.maru.classSchedule;

import java.util.ArrayList;
import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.maru.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Class_ScheduleService {

	@Autowired
	public Class_ScheduleRepository classSRepository;

	// 1. Service to get all rank information
	public List<Class_Schedule> getAllClassSchedule() {
		List<Class_Schedule> classs = new ArrayList<Class_Schedule>();
		classSRepository.findAll().forEach(classs::add);
		return classs;
	}
	
	//2. Add new rank information
	public void addClassSchedule(Class_Schedule classs){
		classSRepository.save(classs);
	}
	
}
