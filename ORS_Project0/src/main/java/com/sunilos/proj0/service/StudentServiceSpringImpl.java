package com.sunilos.proj0.service;

import java.text.Normalizer.Form;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunilos.proj0.dao.StudentDAOInt;
import com.sunilos.proj0.dto.StudentDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.exception.DuplicateRecordException;

@Service(value = "studentService")
public class StudentServiceSpringImpl implements StudentServiceInt {

	@Autowired
	private StudentDAOInt dao;

	public void setDao(StudentDAOInt dao) {
		this.dao = dao;
	}

	private static Logger log = Logger
			.getLogger(StudentServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(StudentDTO dto) throws ApplicationException,
			DuplicateRecordException {
		StudentDTO existDto = dao.findByEmailId(dto.getEmail());
		if (existDto != null) {
			throw new DuplicateRecordException("Student Name is already Exist");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(StudentDTO dto) throws ApplicationException,
			DuplicateRecordException {
		StudentDTO existDto = dao.findByEmailId(dto.getEmail());
		if (existDto != null && existDto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Record is already Exist");
		}
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) throws ApplicationException {
		dao.delete(id);

	}

	@Transactional(readOnly = true)
	public StudentDTO findByEmailId(String emailId) throws ApplicationException {

		return dao.findByEmailId(emailId);
	}

	@Transactional(readOnly = true)
	public StudentDTO findByPK(long pk) throws ApplicationException {

		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public List search(StudentDTO dto, int pageNo, int pageSize)
			throws ApplicationException {

		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(StudentDTO dto) throws ApplicationException {

		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List list() throws ApplicationException {

		return dao.list();
	}

	@Transactional(readOnly = true)
	public List list(int pageNo, int pageSize) throws ApplicationException {

		return dao.list(pageNo, pageSize);
		
	}

}
