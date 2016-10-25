package com.ericsson.ntf.ref.intf;

import java.util.List;

import com.ericsson.ntf.ref.data.tblentities.NtfLanguage;
import com.ericsson.ntf.ref.data.tblentities.NtfUnitOfMeasurement;

public interface NtfReferenceDataIntf {
	
	/**
	 * Get a list of languages from the Language table
	 * 
	 * @return: List<NtfLanguage>
	 */
    List<NtfLanguage> getLanguageList();
    
    /**
     * Get a list of unit of measurements
     * 
     * @return
     */
    List<NtfUnitOfMeasurement> getUnitOfMeasurements();
    
    /**
     * Get a specific UnitOfMeasurement
     * 
     * @param unitName
     * @return
     */
    NtfUnitOfMeasurement getUnitOfMeasurement(String unitName);

    /**
     *  Get a contact type key for a contact type name.
     *  
     * @param contactTypeName
     * @return
     */
	String getContactTypeKey(String contactTypeName);

	/**
	 * Get a contact role key for a contact role name
	 * @param contactRoleName
	 * @return
	 */
	String getContactRoleKey(String contactRoleName);

	/**
	 * Clear the cached data
	 */
	void clearCache();
}
