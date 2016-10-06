package com.sunilos.proj0.dao;

import java.util.List;

import com.sunilos.proj0.dto.FacultyDTO;
import com.sunilos.proj0.exception.*;


/**
 * @author Ravindra
 *
 */
public interface FacultyDAOInt {
	/**
	 * Add a Faculty
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when Faculty already exists
	 */
	public long add(FacultyDTO dto);

	/**
	 * Update a Faculty
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : if updated user record is already exist
	 */
	public void update(FacultyDTO dto);

	/**
	 * Delete a Faculty
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(long id);

	/**
	 * Find Faculty by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public FacultyDTO findByUserId(Long uId);

	/**
	 * Find Faculty by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	public FacultyDTO findByPK(long pk);

	/**
	 * Search Faculty with pagination
	 * 
	 * @return list : List of Faculty
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List search(FacultyDTO dto, int pageNo, int pageSize);

	/**
	 * Search Faculty
	 * 
	 * @return list : List of Faculty
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	public List search(FacultyDTO dto);

	/**
	 * Gets List of Faculty
	 * 
	 * @return list : List of Faculty
	 * @throws DatabaseException
	 */
	public List list();

	/**
	 * get List of Faculty with pagination
	 * 
	 * @return list : List of Faculty
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	public List list(int pageNo, int pageSize);

}
