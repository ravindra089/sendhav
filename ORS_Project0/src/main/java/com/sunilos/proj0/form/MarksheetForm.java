package com.sunilos.proj0.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.sunilos.proj0.dto.BaseDTO;
import com.sunilos.proj0.dto.MarksheetDTO;

public class MarksheetForm extends BaseForm {

	protected Long id = 0l;

	@NotEmpty
	private String rollNo;

	private String name;

	@NotNull
	@Max(100)
	@Min(0)
	private Integer physics;

	@NotNull
	@Max(100)
	@Min(0)
	private Integer chemistry;

	@NotNull
	@Max(100)
	@Min(0)
	private Integer maths;

	protected Long studentId;

	private Long[] Ids;

	
	

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long[] getIds() {
		return Ids;
	}

	public void setIds(Long[] ids) {
		Ids = ids;
	}

	@Override
	public BaseDTO getDto() {
		MarksheetDTO dto = new MarksheetDTO();
		dto.setId(id);
		dto.setMaths(maths);
		dto.setPhysics(physics);
		dto.setChemistry(chemistry);
		dto.setRollNo(rollNo);
		dto.setStudentId(studentId);
		dto.setName(name);
		return dto;

	}

	@Override
	public void populate(BaseDTO bDto) {
		MarksheetDTO dto = (MarksheetDTO) bDto;
		id = dto.getId();
		name = dto.getName();
		maths = dto.getMaths();
		physics = dto.getPhysics();
		chemistry = dto.getChemistry();
		rollNo = dto.getRollNo();
		studentId = dto.getStudentId();

	}
}
