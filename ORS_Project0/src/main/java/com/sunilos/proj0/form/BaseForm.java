package com.sunilos.proj0.form;

import com.sunilos.proj0.dto.BaseDTO;

/**
 * Contains generic attributes of a form. It is extended by all form beans.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public class BaseForm {

	protected long id;

	private Integer pageNo = 1;

	private Integer pageSize = 5;

	private String operation;

	protected String createdBy;

	protected String modifiedBy;

	protected Long createdDatetime;

	protected Long modifiedDatetime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Long createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Long getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Long modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	/**
	 * Converts fto into form.
	 * 
	 * @param bDto
	 */

	public void populate(BaseDTO bDto) {

	}

	public BaseDTO getDto() {
		// TODO Auto-generated method stub
		return getDto();
	}
}
