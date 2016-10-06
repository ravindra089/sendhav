package com.sunilos.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sunilos.proj0.dto.CollegeDTO;
import com.sunilos.proj0.exception.*;



/**
 * @author Ravindra
 *
 */
public interface CollegeDAOInt {

	/**
	 * Add a College
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when college already exists
	 */
	public long add(CollegeDTO dto) throws DataAccessException;

	/**
	 * Update a College
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : if updated user record is already exist
	 */
	public void update(CollegeDTO dto) throws DataAccessException;

	/**
	 * Delete a College
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(long id) throws DataAccessException;

	/**
	 * Find College by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public CollegeDTO findByName(String name) throws DataAccessException;

	/**
	 * Find College by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public CollegeDTO findByPK(long pk) throws ApplicationException;

	/**
	 * Search College with pagination
	 * 
	 * @return list : List of College
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize)
			throws DataAccessException;

	/**
	 * Search College
	 * 
	 * @return list : List of College
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	public List search(CollegeDTO dto) throws DataAccessException;

	/**
	 * Gets List of College
	 * 
	 * @return list : List of College
	 * @throws DatabaseException
	 */
	public List list() throws DataAccessException;

	/**
	 * get List of College with pagination
	 * 
	 * @return list : List of College
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws DataAccessException;

}
