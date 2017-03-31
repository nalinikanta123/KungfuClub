package org.maru.parent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.maru.student.Student;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@Embeddable
public class ParentId implements Serializable  {
	
	@GeneratedValue
	int prt_number;
	String prt_type;
	@Column(name="std_number_son")
	private int std_number_son;
	
//	@JoinColumn(name = "std_number_son", referencedColumnName = "std_num",insertable=false, updatable=false)
//	@ManyToOne
//	public Student student;
}
