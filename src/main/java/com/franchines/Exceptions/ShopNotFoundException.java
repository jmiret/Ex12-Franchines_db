package com.franchines.Exceptions;

/**
 * 
 * @author jordi.miret
 *
 */

public class ShopNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6456379856928124597L;

	public ShopNotFoundException(Long id) {
		super("Could not find shop " + id);
	}

}
