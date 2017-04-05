package org.maru.classMain;

import java.util.List;


import org.maru.instructor.Instructor;
import org.maru.instructor.InstructorService;
import org.maru.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {

	@Autowired
	public ClassService classService;
	@Autowired
	public InstructorService instructorService;
	
	// 1. Get all Class records
		@RequestMapping("/class")
		public List<Class> getAllClass() {
			return classService.getAllClass();
		}
		
	//2.Add new class
		@RequestMapping(value = "/class", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public void addClass(@RequestBody Class classObj) {
			System.out.println("Class Desc recieved = " +classObj.cls_description);
			System.out.println("Class Level recieved = " +classObj.cls_level);
			System.out.println("Class INs recieved = " +classObj.instructor.getIns_number());
			if(classObj.instructor.getIns_number() == 0){
				//System.out.println("Hello");
				List<Instructor> inst=instructorService.getAllInstructor();
				if(inst.size()>0){
					System.out.println(inst.get(0).getIns_number());
					classObj.instructor.setIns_number(inst.get(0).getIns_number());
				}
			}
			System.out.println("Class INs recieved = " +classObj.instructor.getIns_number());
			classService.addClass(classObj);
		}
	
	
}
