package com.sunilos.proj0.service;

import java.util.List;

import com.sunilos.proj0.dto.TimeTableDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.exception.DatabaseException;
import com.sunilos.proj0.exception.DuplicateRecordException;

public interface TimeTableServiceInt {
	/**
	 * Add a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when Course already exists
	 */
	public long add(TimeTableDTO dto) throws ApplicationException,
			DuplicateRecordException;

	/**
	 * Update a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : if updated user record is already exist
	 */
	public void update(TimeTableDTO dto) throws ApplicationException,
			DuplicateRecordException;

	/**
	 * Delete a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(long id) throws ApplicationException;

	/**
	 * Find Course by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public TimeTableDTO findByName(Long fid, String name)
			throws ApplicationException;

	/**
	 * Find Course by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public TimeTableDTO findByPK(long pk) throws ApplicationException;

	/**
	 * Search Course with pagination
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List search(TimeTableDTO dto, int pageNo, int pageSize)
			throws ApplicationException;

	/**
	 * Search Course
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	public List search(TimeTableDTO dto) throws ApplicationException;

	/**
	 * Gets List of Course
	 * 
	 * @return list : List of Course
	 * @throws DatabaseException
	 */
	public List list() throws ApplicationException;

	/**
	 * get List of Course with pagination
	 * 
	 * @return list : List of Course
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException;

}
