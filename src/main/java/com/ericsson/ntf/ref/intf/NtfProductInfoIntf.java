package com.ericsson.ntf.ref.intf;

public interface NtfProductInfoIntf {
	/**
	 * Get the product name from the rmca.productoffering table, using product offering id.
	 * 
	 * @param productOfferingId: product offering id
	 * 
	 * @return product name
	 */
	String getProductName(String productOfferingId);
	
	/**
	 * Get the bucket name from the rmca.resourcespecification table, using bucket id.
	 * 
	 * @param bucketSpecId: bucket spec id 
	 * 
	 * @return 
	 */
	String getBucketName(String bucketSpecId);
	
	/**
	 * Get the threshold name
	 * 
	 * @param bucketSpecId
	 * 
	 * @param thresholdSpecId
	 * 
	 * @return
	 */
	String getThresholdName(String bucketSpecId, String thresholdSpecId);
}
