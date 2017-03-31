package org.maru.instructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.maru.Test.Test;
import org.maru.Topic.Topic;
import org.maru.student.Student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Instructor {
	@Id
	@GeneratedValue
	int ins_number;
	String ins_name;
	
	//All getter and setters
	public int getIns_number() {
		return ins_number;
	}
	public void setIns_number(int ins_number) {
		this.ins_number = ins_number;
	}
	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
}
