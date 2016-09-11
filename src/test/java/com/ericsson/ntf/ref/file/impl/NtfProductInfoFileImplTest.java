package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.ref.intf.NtfPersistenceIntf;
import com.ericsson.ntf.ref.intf.NtfProductInfoIntf;

public class NtfProductInfoFileImplTest {
    public static void main(String[] args) {
        NtfPersistenceIntf persistenceIntf = new NtfPersistenceFileImpl();
        NtfProductInfoIntf productInfo = persistenceIntf.getProductInfo();
        System.out.println(">>>> Product name :" + productInfo.getProductName("p001"));
        System.out.println(">>>> Bucket name :" + productInfo.getBucketName("b001"));
    }
}
