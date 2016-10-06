package com.sunilos.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sunilos.proj0.dto.CourseDTO;
import com.sunilos.proj0.exception.*;



/**
 * @author Ravindra
 *
 */
public interface CourseDAOInt {
	/**
	 * Add a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when Course already exists
	 */
	public long add(CourseDTO dto) throws ApplicationException,
			DuplicateRecordException;

	/**
	 * Update a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : if updated user record is already exist
	 */
	public void update(CourseDTO dto) throws DataAccessException;

	/**
	 * Delete a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(long id) throws DataAccessException;

	/**
	 * Find Course by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public CourseDTO findByName(String name, String sub)
			throws DataAccessException;

	/**
	 * Find Course by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public CourseDTO findByPK(long pk) throws DataAccessException;

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
			throws DataAccessException;

	/**
	 * Search Course
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	public List search(CourseDTO dto) throws DataAccessException;

	/**
	 * Gets List of Course
	 * 
	 * @return list : List of Course
	 * @throws DatabaseException
	 */
	public List list() throws DataAccessException;

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
