package org.test.springtest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	
	@Id
	String name;
	int age;
	String rank;
	String year;
	String belts;
	
	public Topic(){
	}
	
	public Topic(String name, int age, String rank, String year, String belt){
		this.name=name;
		this.age=age;
		this.rank=rank;
		this.year=year;
		this.belts=belt;
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
	public String getBelt() {
		return belts;
	}
	public void setBelt(String belts) {
		this.belts = belts;
	}
	
}
