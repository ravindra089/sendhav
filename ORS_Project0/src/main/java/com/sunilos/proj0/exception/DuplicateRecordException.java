package com.sunilos.proj0.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * 
 */

/**
 * @author Ravindra
 *
 */
public class DuplicateRecordException extends Exception {

	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}