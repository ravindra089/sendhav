package com.sunilos.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ST_FACULTY")
public class FacultyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	/**
	 * Faculty Name
	 */
	@Column(name = "FACULTYNAME", length = 50)
	private String facultyName;
	/**
	 * College Name
	 */
	@Column(name = "COLLEGENAME", length = 50)
	private String collegeName;
	/**
	 * College Id Foreign Key
	 */
	@Column(name = "COLLEGEID", length = 5)
	private long collegeId;
	/**
	 * User Id Foreign Key
	 */
	@Column(name = "USERID", length = 5)
	private long userId;

	/**
	 * accessor
	 */
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String getKey() {

		return id + "";
	}

	@Override
	public String getValue() {

		return facultyName;
	}

}
