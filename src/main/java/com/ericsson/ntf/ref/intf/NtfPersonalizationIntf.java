package com.ericsson.ntf.ref.intf;

import com.ericsson.ntf.common.message.CustomerRecord;

public interface NtfPersonalizationIntf {
    /**
     *
     * @param subscriberId
     * @param contractId
     * @return
     */
    CustomerRecord getCustomerRecord(String subscriberId, String contractId);
}