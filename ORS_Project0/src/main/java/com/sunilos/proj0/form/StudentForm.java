package com.sunilos.proj0.form;

import java.text.Normalizer.Form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.StudentDTO;
import com.sunilos.proj0.util.Util;

public class StudentForm extends BaseForm {

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "First name cannot contain space")
	private String firstName;

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]*")
	private String lastName;

	@NotEmpty
	private String dob;

	@NotEmpty
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "{Pattern.form.phoneNo}")
	private String mobileNo;

	@NotEmpty
	@Email
	private String emailId;

	@NotNull
	private Long collegeId;

	private Long[] Ids;

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public Long[] getIds() {
		return Ids;
	}

	public void setIds(Long[] ids) {
		Ids = ids;
	}

	@Override
	public BaseDTO getDto() {
		StudentDTO dto = new StudentDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDob(Util.getDate(dob));
		dto.setMobileNo(mobileNo);
		dto.setEmail(emailId);
		dto.setCollegeId(collegeId);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		StudentDTO dto = (StudentDTO) bDto;
		id = dto.getId();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		dob = Util.getDate(dto.getDob());
		mobileNo = dto.getMobileNo();
		emailId = dto.getEmail();
		collegeId = dto.getCollegeId();
		
	}
}
