package org.maru.rankHist;

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
import org.maru.rank.Rank;
import org.maru.student.Student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Rank_history {
	@Id
	@GeneratedValue
	int rank_hist_num;
	@ManyToOne
	@JoinColumn(name ="std_num")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@feeNum")
	public Student student;
	@ManyToOne
	@JoinColumn(name ="rk_code")
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@feeNum")
	public Rank rank;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	Date dt_achieved;
	
	
	//Getter and Setter
	public int getRankHist_num() {
		return rank_hist_num;
	}
	public void setRankHist_num(int rank_hist_num) {
		this.rank_hist_num = rank_hist_num;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Date getDt_achieved() {
		return dt_achieved;
	}
	public void setDt_achieved(Date dt_achieved) {
		this.dt_achieved = dt_achieved;
	}
	
	
}
