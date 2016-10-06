package com.sunilos.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ST_COURSE")
public class CourseDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Course Name
	 */
	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	/**
	 * Course Subject
	 */
	@Column(name = "SUBJECT", length = 50)
	private String subject;

	/**
	 * accessor
	 */

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String getKey() {

		return id + "";
	}

	@Override
	public String getValue() {

		return courseName + " " + subject;
	}

}
