package org.maru.student;

import java.util.List;

import org.maru.Topic.TopicService;
import org.maru.rank.Rank;
import org.maru.rank.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private RankService rankService;

	// 1. Get all student records
	@RequestMapping("/student")
	public List<Student> getAllStudets() {
		return studentService.getAllStudents();
	}

	// 2. Insert new student record
	@RequestMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRank(@RequestBody Student student) {
		System.out.println("Student num recieved = " + student.std_num );
		System.out.println("Student Fname recieved = " + student.std_fname);
		System.out.println("Student Lname recieved = " + student.std_lname);
		System.out.println("Student phone recieved = " + student.std_phone);
		System.out.println("Student email recieved = " + student.std_email);
		System.out.println("Student dob recieved = " + student.std_dob);
		System.out.println("Student enroll date recieved = " + student.std_date_enroll);
		System.out.println("Student addr1 recieved = " + student.std_address_line1);
		System.out.println("Student addr2 recieved = " + student.std_address_line2);
		System.out.println("Student city recieved = " + student.std_address_city);
		System.out.println("Student prov recieved = " + student.std_address_prov);
		System.out.println("Student zipcode recieved = " + student.std_address_zipcode);
		//System.out.println("Student rank_code recieved = " + student.);
		
		System.out.println("Calling add topic call\n");
		//rankService.addRank(student.getRank());
		studentService.addStudent(student);
	}
	
	//3. Update existing record(For Example : Update Rank information)
	@RequestMapping(value="/student/{id}", method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student,
								@PathVariable int id){
		System.out.println("ID as paramter recieved = " + id);
		System.out.println("Student num recieved = " + student.std_num );
		System.out.println("Student Fname recieved = " + student.std_fname);
		System.out.println("Student Lname recieved = " + student.std_lname);
		System.out.println("Student phone recieved = " + student.std_phone);
		System.out.println("Student email recieved = " + student.std_email);
		System.out.println("Student dob recieved = " + student.std_dob);
		System.out.println("Student enroll date recieved = " + student.std_date_enroll);
		System.out.println("Student addr1 recieved = " + student.std_address_line1);
		System.out.println("Student addr2 recieved = " + student.std_address_line2);
		System.out.println("Student city recieved = " + student.std_address_city);
		System.out.println("Student prov recieved = " + student.std_address_prov);
		System.out.println("Student zipcode recieved = " + student.std_address_zipcode);
		studentService.updateStudent(id, student);
	}
	
	//4. Get a particular student
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET) 
	public Student getOneStudent(@PathVariable int id){
		System.out.println("id recieved = " + id);
		return studentService.getOneStudent(id);
	}
	
	//5. Get student by rank
	@RequestMapping(value="/student/rank/{id}", method=RequestMethod.GET)
	public List<Student> getByStudentRank(@PathVariable int id){
		System.out.println("id recieved = " + id);
		return studentService.getByStudentRank(id);
	}
}
