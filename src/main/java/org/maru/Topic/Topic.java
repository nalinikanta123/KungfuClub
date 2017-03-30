package org.maru.Topic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.maru.Test.Test;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Topic {
	
	@Id
	public String name;
	public int age;
	public String rank;
	public String year;
	public String belts;
	@OneToMany(mappedBy="topic1",fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@topicId") // V.IMP for object to JSON conversion
	public Collection<Test> test = new ArrayList<>();
	
	public Topic(){
	}
	
	public Topic(String name, int age, String rank, String year, String belts ){
		this.name=name;
		this.age=age;
		this.rank=rank;
		this.year=year;
		this.belts=belts;
		//this.test=test;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBelts() {
		return belts;
	}

	public void setBelts(String belts) {
		this.belts = belts;
	}

	
	public Collection<Test> getTest() {
		return test;
	}

	public void setTest(Collection<Test> test) {
		this.test = test;
	}
}
