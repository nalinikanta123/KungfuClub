package org.maru.classAttendance;

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
import org.maru.classMain.Class;
import org.maru.classSchedule.Class_Schedule;
import org.maru.student.Student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Class_Attendance {
	@Id
	@GeneratedValue
	int cls_serial_num;
	@ManyToOne
	@JoinColumn(name ="std_num")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@stdNum")
	public Student studentFee;
	@ManyToOne
	@JoinColumn(name ="cls_code")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@clsNum")
	public Class classs;
	@ManyToOne
	@JoinColumn(name ="sch_num")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@schNum")
	public Class_Schedule classSch;
	Date att_date;
	
	//Getter and Setters
	public int getCls_serial_num() {
		return cls_serial_num;
	}
	public void setCls_serial_num(int cls_serial_num) {
		this.cls_serial_num = cls_serial_num;
	}
	public Student getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(Student studentFee) {
		this.studentFee = studentFee;
	}
	public Class getClasss() {
		return classs;
	}
	public void setClasss(Class classs) {
		this.classs = classs;
	}
	public Date getAtt_date() {
		return att_date;
	}
	public void setAtt_date(Date att_date) {
		this.att_date = att_date;
	}
	
	
	
}
