package org.test.springtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

class local {
	public String name;
	public int age;
	public String year;
	public String rank;
	public String belts;

	public local(String name, int age, String year, String rank, String belts) {
		this.name = name;
		this.age = age;
		this.year = year;
		this.rank = rank;
		this.belts = belts;
	}

	public local() {
	}
}

@RestController
public class RestControllers {

	@Autowired
	private TopicService topicService;

	@Autowired
	private TestService testService;

	@RequestMapping("/")
	public String home() {
		return "go for /hello";
	}

	
	//insert data
	@RequestMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addStudent(@RequestBody Topic local) {
		System.out.println("Name recieved = " + local.name);
		System.out.println("age recieved = " + local.age);
		System.out.println("rank recieved = " + local.rank);
		System.out.println("year recieved = " + local.year);
		System.out.println("belts recieved = " + local.belts);
		System.out.println("Calling add topic call\n");
		topicService.addTopic(local);
		System.out.println("Return from add topic call\n");
	}

	@RequestMapping("/object")
	public List<Object> test1() {
		ArrayList<Object> obj = new ArrayList<Object>();
		local obj1 = new local("test1", 1, "2010", "1", "white");
		local obj2 = new local("test2", 2, "2011", "2", "black");
		local obj3 = new local("test3", 3, "2012", "3", "white");
		local obj4 = new local("test4", 4, "2013", "4", "red");
		local obj5 = new local("test5", 5, "2014", "5", "white");
		local obj6 = new local("test6", 6, "2015", "6", "black");
		obj.add(obj1);
		obj.add(obj2);
		obj.add(obj3);
		obj.add(obj4);
		obj.add(obj5);
		obj.add(obj6);
		return obj;
	}

	// get real time data from DB
	@RequestMapping("/object2")
	public List<Topic> test2() {
//		for(int i=0; i <  topicService.getAllTopics().size(); i++){
//			
//			String test=topicService.getAllTopics().get(i).name;
//			System.out.println( test);
//			if(test == "yadwinder"){
//				System.out.println("Hello");
//			}
//			if(test.contains("yadwinder")){
//				System.out.println("Size is " + topicService.getAllTopics().get(i).getTest().size());
//				Iterator<Test> itr= topicService.getAllTopics().get(i).getTest().iterator();
//				while(itr.hasNext()){
//					Test test1 = itr.next();
//					System.out.println("value = " + test1.fee);
//					System.out.println("value = " + test1.test_id);
//				}
//				
//			}
//		}
		
		return topicService.getAllTopics();
		//return null;
	}

	// Customised query
	@RequestMapping("/topic1/{belts}")
	public List<Topic> test4(@PathVariable String belts) {
		System.out.println("Input received = " + belts);
		return topicService.getCustTopic(belts);
	}

	// get real time data from DB for specific rank
	@RequestMapping("/topic/{belts}")
	public List<Topic> test3(@PathVariable String belts) {
		System.out.println("Input received = " + belts);
		return topicService.getSpecificBelts(belts);
	}

	// JOIN TEST 2
	@RequestMapping("/topic2")
	public List<Test> test5() {
		 System.out.println("Array returned = " + testService.getAllTest().toArray().length);
		 for(int i =0 ; i <testService.getAllTest().toArray().length; i++ ){
			 System.out.println(testService.getAllTest().get(i).fee);
			 System.out.println(testService.getAllTest().get(i).test_id);
			 if(testService.getAllTest().get(i).getTopic() != null){
			 System.out.println(testService.getAllTest().get(i).getTopic().age);
			 System.out.println(testService.getAllTest().get(i).getTopic().belts);
			 System.out.println(testService.getAllTest().get(i).getTopic().name);
			 System.out.println(testService.getAllTest().get(i).getTopic().rank);
			 System.out.println(testService.getAllTest().get(i).getTopic().year);
			 }
			 System.out.println("*********************");
		 }
		
		
//		ArrayList<Object> obj = new ArrayList<Object>();
//		local obj1 = new local("test1", 1, "2010", "1", "white");
//		local obj2 = new local("test2", 2, "2011", "2", "black");
//		local obj3 = new local("test3", 3, "2012", "3", "white");
//		local obj4 = new local("test4", 4, "2013", "4", "red");
//		local obj5 = new local("test5", 5, "2014", "5", "white");
//		local obj6 = new local("test6", 6, "2015", "6", "black");
//		obj.add(obj1);
//		obj.add(obj2);
//		obj.add(obj3);
//		obj.add(obj4);
//		obj.add(obj5);
//		obj.add(obj6);
	//	return obj;
		return testService.getAllTest();
	}
	
	// JOIN TEST 3
		@RequestMapping("/topic3/{name}")
		public Test test6(@PathVariable String name) {
			System.out.println("Input received = " + name);
			return testService.getByTestName(name);
		}

	
		
	//JOIN TEST ADD DATA
		//insert data
		@RequestMapping(value = "/fees", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public void addfees(@RequestBody Test local) {
			System.out.println("Name recieved = " + local.test_id);
			System.out.println("fee recieved = " + local.fee);
			System.out.println("name FK = " + local.getTopic().name);
			testService.addTopic(local);
			System.out.println("Return from add topic call\n");
		}

}
