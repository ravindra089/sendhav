package com.sunilos.proj0.form;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.util.Util;

/**
 * @author Ravindra
 * 
 */
public class UserForm extends BaseForm {
	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	@Email
	private String login;

	@NotEmpty
	@Size(max = 10, min = 5)
	private String password;

	@NotEmpty
	private String gender;

	protected Long roleId;

	@NotEmpty
	private String dob;

	@NotEmpty
	private String mobileNo;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	private Long lastLogin;

	private String lock;

	private String registeredIP;

	private String lastLoginIP;

	private Long[] Ids;

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setGender(gender);
		dto.setRoleId(roleId);
		dto.setMobileNo(mobileNo);
		dto.setDob(Util.getDate(dob));
		/* dto.setLastLogin(new Timestamp(lastLogin)); */

		dto.setRegisteredIP(registeredIP);
		dto.setCreatedBy(createdBy);
		/* dto.setModifiedBy(modifiedBy); */
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		return dto;
	};

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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public Long[] getIds() {
		return Ids;
	}

	public void setIds(Long[] ids) {
		Ids = ids;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;

		id = dto.getId();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		login = dto.getLogin();
		password = dto.getPassword();
		dob = Util.getDate(dto.getDob());
		mobileNo = dto.getMobileNo();
		roleId = dto.getRoleId();
		if (dto.getLastLogin() != null) {
			lastLogin = dto.getLastLogin().getTime();
		}
		gender = dto.getGender();
		registeredIP = dto.getRegisteredIP();
		createdBy = dto.getCreatedBy();
		/* modifiedBy = dto.getModifiedBy(); */
		if (dto.getCreatedDatetime() != null) {
			createdDatetime = dto.getCreatedDatetime().getTime();
		}
		if (dto.getModifiedDatetime() != null) {
			modifiedDatetime = dto.getModifiedDatetime().getTime();
		}
		super.populate(bDto);
	}
}
