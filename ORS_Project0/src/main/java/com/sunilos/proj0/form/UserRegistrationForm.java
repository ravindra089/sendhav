package com.sunilos.proj0.form;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.mysql.jdbc.Util;
import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.UserDTO;



/**
 * @author Ravindra
 *
 */
public class UserRegistrationForm extends BaseForm {
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "First name cannot contain space")
	private String firstName;

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]*")
	private String lastName;

	@Email
	@NotEmpty
	private String login;

	@NotEmpty
	@Size(max = 10, min = 5)
	private String password;

	@NotEmpty
	private String gender;

	@NotEmpty
	private String dob;

	@NotEmpty
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Mobile no start form 789")
	private String mobileNo;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setPassword(password);
		dto.setLogin(login);
		dto.setDob(new Date(dob));
		dto.setGender(gender);
		dto.setMobileNo(mobileNo);

		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;
		id = dto.getId();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		login = dto.getLogin();
		password = dto.getPassword();
		mobileNo = dto.getMobileNo();
		gender = dto.getGender();
		super.populate(bDto);
	}
}
