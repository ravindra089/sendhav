package com.sunilos.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.sunilos.proj0.dto.MarksheetDTO;
import com.sunilos.proj0.exception.*;



/**
 * @author Ravindra
 *
 */
public interface MarksheetDAOInt {

	/**
	 * Adds a Marksheet
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when Roll No already exists
	 * 
	 */

	public long add(MarksheetDTO dto) throws DataAccessException;

	/**
	 * Deletes a Marksheet
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(long id) throws DataAccessException;

	/**
	 * Finds Marksheet by Roll No
	 * 
	 * @param rollNo
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public MarksheetDTO findByRollNo(String rollNo) throws ApplicationException;

	/**
	 * Finds Marksheet by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DataAccessException
	 */

	public MarksheetDTO findByPK(long pk) throws DataAccessException;

	/**
	 * Updates a Marksheet
	 * 
	 * @param dto
	 * @throws DataAccessException
	 * @throws DuplicateRecordException
	 */
	public void update(MarksheetDTO dto) throws DataAccessException,
			DuplicateRecordException;

	/**
	 * Searches Marksheet
	 * 
	 * @param dto
	 *            : Search Parameters
	 * @throws DataAccessException
	 */
	public List search(MarksheetDTO dto) throws DataAccessException;

	/**
	 * Searches Marksheet with pagination
	 * 
	 * @return list : List of Marksheets
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * 
	 * @throws DataAccessException
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize)
			throws DataAccessException;

	/**
	 * Gets List of Marksheet
	 * 
	 * @return list : List of Marksheets
	 * @throws DatabaseException
	 */
	public List list() throws DataAccessException;

	/**
	 * get List of Marksheet with pagination
	 * 
	 * @return list : List of Marksheets
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DataAccessException
	 */
	public List list(int pageNo, int pageSize) throws DataAccessException;

	/**
	 * get Merit List of Marksheet with pagination
	 * 
	 * @return list : List of Marksheets
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DataAccessException
	 */
	public List getMeritList(int pageNo, int pageSize)
			throws DataAccessException;

}
