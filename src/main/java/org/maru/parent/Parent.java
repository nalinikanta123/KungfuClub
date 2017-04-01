package org.maru.parent;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


import org.maru.Test.Test;
import org.maru.Topic.Topic;
import org.maru.student.Student;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity//@IdClass(ParentId.class)
public class Parent {

	@Id
	@GeneratedValue
	int prt_number;
//	@Id
//	@Basic(optional = false)
	String prt_type;
//
//	@Id
//	@Basic(optional = false)
//	@Column(name = "std_number_son")
//	private int std_number_son;

	//@JoinColumn(name = "std_number_son", referencedColumnName = "std_num",insertable=false, updatable=false)
	@JoinColumn(name = "std_number_son", referencedColumnName = "std_num")
	@ManyToOne
	//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@stdNum")
	public Student student;

	String prt_fname;
	String prt_lname;
	int prt_phone;
	String prt_email;
	
	@ManyToOne()
	@JoinColumn(name = "std_number", referencedColumnName = "std_num")
	//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@stdNum1")
	public Student studentParent;

	// public ParentId getParentId() {
	// return parentId;
	// }
	// public void setParentId(ParentId parentId) {
	// this.parentId = parentId;
	// }
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getPrt_number() {
		return prt_number;
	}

	public void setPrt_number(int prt_number) {
		this.prt_number = prt_number;
	}

	public String getPrt_type() {
		return prt_type;
	}

	public void setPrt_type(String prt_type) {
		this.prt_type = prt_type;
	}

	public Student student() {
		return student;
	}

	public void student(Student student) {
		this.student = student;
	}

	public String getPrt_fname() {
		return prt_fname;
	}

	public void setPrt_fname(String prt_fname) {
		this.prt_fname = prt_fname;
	}

	public String getPrt_lname() {
		return prt_lname;
	}

	public void setPrt_lname(String prt_lname) {
		this.prt_lname = prt_lname;
	}

	public int getPrt_phone() {
		return prt_phone;
	}

	public void setPrt_phone(int prt_phone) {
		this.prt_phone = prt_phone;
	}

	public String getPrt_email() {
		return prt_email;
	}

	public void setPrt_email(String prt_email) {
		this.prt_email = prt_email;
	}

	public Student getStudentParent() {
		return studentParent;
	}

	public void setStudentParent(Student studentParent) {
		this.studentParent = studentParent;
	}

//	public int getStd_number_son() {
//		return std_number_son;
//	}
//
//	public void setStd_number_son(int std_number_son) {
//		this.std_number_son = std_number_son;
//	}

	
}
