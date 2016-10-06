package com.sunilos.proj0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.TimeTableDTO;

public class TimeTableForm extends BaseForm{
	@NotEmpty
	@Email
	private Long userId;
	private String facultyName;
	private Long courseId;
	private String courseName;
	private String subject;
	private String day;
	private String time;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public TimeTableDTO getDto(){
		TimeTableDTO dto=new TimeTableDTO();
		dto.setUserId(userId);
		dto.setCourseId(courseId);
		dto.setCourseName(courseName);
		dto.setFacultyName(facultyName);
		dto.setSubject(subject);
		dto.setDay(day);
		dto.setTime(time);
		
		
		return dto;
		
	}
	@Override
	public void populate(BaseDTO bDto){
		TimeTableDTO dto=(TimeTableDTO) bDto;
		userId=dto.getUserId();
		courseId=dto.getCourseId();
		courseName=dto.getCourseName();
		facultyName=dto.getFacultyName();
		subject=dto.getSubject();
		day=dto.getDay();
		time=dto.getTime();
		super.populate(bDto);
		
	}

}
