package com.webco.engine;

/**
 * Created by dean on 20/02/16.
 */
public enum States {

	/**
	 * These are PLATFORM states; the platform will return one of these.
	 */

    DEFINITION, // 
    SANDBOX, // 
    PUBLISHEDV1, //
    PUBLISHEDPATCHED, //
    ARCHIVED, //
    
    // 
    RUNNING, //
    STOPPED, // 
    IN_MAINTENANCE, //
    ERROR

}
