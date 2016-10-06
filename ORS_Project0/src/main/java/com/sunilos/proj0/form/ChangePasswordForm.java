package com.sunilos.proj0.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.UserDTO;

public class ChangePasswordForm extends BaseForm {

	@NotEmpty
	private String oldpassword;

	@NotEmpty
	@Size(min = 5, max = 10)
	private String newpassword;

	@NotEmpty
	@Size(min = 5, max = 10)
	private String confirmpassword;

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
