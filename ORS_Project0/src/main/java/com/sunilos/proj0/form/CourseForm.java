package com.sunilos.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.CourseDTO;

public class CourseForm extends BaseForm {

	@NotEmpty
	private String courseName;

	@NotEmpty
	private String subjectName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public BaseDTO getDto() {
		CourseDTO dto = new CourseDTO();
		dto.setId(id);
		dto.setCourseName(courseName);
		dto.setSubject(subjectName);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		CourseDTO dto = (CourseDTO) bDto;

		id = dto.getId();
		courseName = dto.getCourseName();
		subjectName = dto.getSubject();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		if (dto.getCreatedDatetime() != null) {
			createdDatetime = dto.getCreatedDatetime().getTime();
		}
		if (dto.getModifiedDatetime() != null) {
			modifiedDatetime = dto.getModifiedDatetime().getTime();
		}
		super.populate(bDto);
	}
}
