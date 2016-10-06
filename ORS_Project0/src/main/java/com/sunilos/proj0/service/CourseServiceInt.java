package com.sunilos.proj0.service;

import java.util.List;

import com.sunilos.proj0.dto.CourseDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.exception.DatabaseException;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.exception.RecordNotFoundException;

/**
 * @author Ravindra
 *
 */
public interface CourseServiceInt {
	
	public long add(CourseDTO dto) throws ApplicationException,
			DuplicateRecordException;

	/**
	 * Update a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : if updated user record is already exist
	 * @throws RecordNotFoundException
	 */
	public void update(CourseDTO dto) throws ApplicationException,
			DuplicateRecordException, RecordNotFoundException;

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
	public CourseDTO findByName(String name, String sub)
			throws ApplicationException;

	/**
	 * Find Course by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public CourseDTO findByPK(long pk) throws ApplicationException;

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
	public List search(CourseDTO dto, int pageNo, int pageSize)
			throws ApplicationException;

	/**
	 * Search Course
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	public List search(CourseDTO dto) throws ApplicationException;

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
