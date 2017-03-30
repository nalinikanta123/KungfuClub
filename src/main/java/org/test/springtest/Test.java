package org.test.springtest;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Test {

	
	@Id
	String test_id;
	int fee;
	@ManyToOne
	@JoinColumn(name ="name")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@testId")
	private Topic topic1;
	
	Test(){
		
	}
	
	Test(String test_id, int fee, Topic topic){
		this.test_id=test_id;
		this.fee=fee;
		
	}
	

	public String getName() {
		return test_id;
	}

	public void setName(String test_id) {
		this.test_id = test_id;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}


	public Topic getTopic() {
		return topic1;
	}

	public void setTopic(Topic topic) {
		this.topic1 = topic;
	}
	

	
}
