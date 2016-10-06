package com.sunilos.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunilos.proj0.dao.TimeTableDAOInt;
import com.sunilos.proj0.dto.TimeTableDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.exception.DuplicateRecordException;

@Service(value = "timetableService")
public class TimeTableServiceSpringImpl implements TimeTableServiceInt {

	@Autowired
	private TimeTableDAOInt dao;

	public void setDao(TimeTableDAOInt dao) {
		this.dao = dao;
	}

	private static Logger log = Logger
			.getLogger(TimeTableServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(TimeTableDTO dto) throws ApplicationException,
			DuplicateRecordException {
		TimeTableDTO existDto = dao.findByName(dto.getUserId(), dto.getTime());
		if (existDto != null) {
			throw new DuplicateRecordException("Subject Name already Exist");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(TimeTableDTO dto) throws ApplicationException,
			DuplicateRecordException {
		TimeTableDTO existDto = dao.findByName(dto.getUserId(), dto.getTime());
		if (existDto != null && existDto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Time Table does not exist");
		}
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) throws ApplicationException {
		dao.delete(id);

	}

	@Transactional(readOnly = true)
	public TimeTableDTO findByName(Long fid, String name)
			throws ApplicationException {

		return dao.findByName(fid, name);
	}

	@Transactional(readOnly = true)
	public TimeTableDTO findByPK(long pk) throws ApplicationException {

		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public List search(TimeTableDTO dto, int pageNo, int pageSize)
			throws ApplicationException {

		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(TimeTableDTO dto) throws ApplicationException {

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
