package com.sunilos.proj0.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.CollegeDTO;


/**
 * @author Ravindra
 *
 */
public class CollegeForm extends BaseForm {

	@NotEmpty
	private String name;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String address;

	@NotEmpty
	
	private String state;

	@NotEmpty
	
	private String city;

	@NotEmpty
	private String mobileNo;

	private Long[] Ids;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long[] getIds() {
		return Ids;
	}

	public void setIds(Long[] ids) {
		Ids = ids;
	}

	@Override
	public BaseDTO getDto() {
		CollegeDTO dto = new CollegeDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setAddress(address);
		dto.setCity(city);
		dto.setState(state);
		dto.setPhoneNo(mobileNo);
		return dto;

	}

	@Override
	public void populate(BaseDTO bDto) {
		CollegeDTO dto = (CollegeDTO) bDto;
		id = dto.getId();
		name = dto.getName();
		address = dto.getAddress();
		city = dto.getCity();
		state = dto.getState();
		mobileNo = dto.getPhoneNo();

	}
}
