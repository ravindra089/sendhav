package com.sunilos.proj0.service;

import java.util.List;

import com.sunilos.proj0.dto.MarksheetDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.exception.DatabaseException;
import com.sunilos.proj0.exception.DuplicateRecordException;

public interface MarksheetServiceInt {

	/**
	 * Marksheet Service interface.
	 * 
	 * 
	 */

	/**
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(MarksheetDTO dto) throws ApplicationException,
			DuplicateRecordException;

	/**
	 * Deletes a Marksheet
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(long id) throws ApplicationException;

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
	 * @throws ApplicationException
	 */

	public MarksheetDTO findByPK(long pk) throws ApplicationException;

	/**
	 * Updates a Marksheet
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(MarksheetDTO dto) throws ApplicationException,
			DuplicateRecordException;

	/**
	 * Searches Marksheet
	 * 
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	public List search(MarksheetDTO dto) throws ApplicationException;

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
	 * @throws ApplicationException
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize)
			throws ApplicationException;

	/**
	 * Gets List of Marksheet
	 * 
	 * @return list : List of Marksheets
	 * @throws DatabaseException
	 */
	public List list() throws ApplicationException;

	/**
	 * get List of Marksheet with pagination
	 * 
	 * @return list : List of Marksheets
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize) throws ApplicationException;

	/**
	 * get Merit List of Marksheet with pagination
	 * 
	 * @return list : List of Marksheets
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List getMeritList(int pageNo, int pageSize)
			throws ApplicationException;

}
