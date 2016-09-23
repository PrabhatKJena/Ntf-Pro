package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.common.message.CustomerRecord;
import com.ericsson.ntf.ref.intf.NtfPersonalizationIntf;

public class NtfPersonalizationFileImplTest {

    public static void main(String[] args) {
        NtfPersonalizationIntf ntfPersonalizationIntf = new NtfPersonalizationFileImpl();
        CustomerRecord customerRecord = ntfPersonalizationIntf.getCustomerRecord("sub1", "cont1");
        System.out.println(customerRecord);
    }
}
