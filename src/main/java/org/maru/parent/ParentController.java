package org.maru.parent;

import java.util.List;

import org.maru.Topic.Topic;
import org.maru.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

	@Autowired
	public ParentService feeService;
	
	// 1. Get all rank records
		@RequestMapping("/parent")
		public List<Parent> getAllParent() {
			return feeService.getAllParent();
		}
		
	//2.Add new Rank
		@RequestMapping(value = "/parent", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public void addRank(@RequestBody Parent parent) {
			System.out.println("Parent Fname recieved = " +parent.prt_fname);
			System.out.println("Parent Lname recieved = " +parent.prt_lname);
			//System.out.println("Parent Lname recieved = " +parent.getStd_number_son());
			//System.out.println("Parent Lname recieved = " +parent.getStd_number());
			System.out.println("Parent Lname recieved = " +parent.getStudent().std_num);
			System.out.println("Parent Lname recieved = " +parent.getStudentParent().std_num);
			System.out.println("Setting the correct values");
			//parent.setStd_number_son(parent.getStudent().std_num);
			//parent.setStd_number(parent.getStudentParent().std_num);
			//System.out.println("Parent son recieved = " +parent.getStd_number_son());
			//System.out.println("Parent parent recieved = " +parent.getStd_number());
			
			System.out.println("Calling add parent call\n");
//			if(parent.getStudentParent().std_num ==0){
//				parent.setStudentParent(null);
//			}
			feeService.addParent(parent);
		}
	
	
}
