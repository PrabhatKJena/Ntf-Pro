package com.ericsson.ntf.ref.intf;

public interface NtfPersistenceIntf {
	/**
	 * The implementation of init() should call initCilClient() from within init().
	 * This function will be the value of the "init-method" tag in bean definition
	 * when the implementation class is injected.
	 * 
	 * This method also can serve as a place holder later on for other initialization,
	 * not just the CIL server.
	 */
	void init();
	
	/**
	 * Need to get the database server.
	 * 
	 * The implementation class should declare a field of com.ericsson.ntf.cil.client.NtfCilClient
	 * and initialized it inside this method while implementing it.
	 */
	void dbConnect();
	
	/**
	 * The method will be the value of the "destroy-method" tag. So far, its primary role is to close
	 * the connection to the database.
	 */
	void shutdown();
	
	/**
	 * Reference data from COBA
	 */
	NtfReferenceDataIntf getReferenceData();
	
	/**
	 * Product information from RMCA
	 */
	NtfProductInfoIntf getProductInfo();
	
	/**
	 * Personalization from CPM
	 */
	NtfPersonalizationIntf getPersonlization();
}
