package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.ref.intf.NtfPersistenceIntf;
import com.ericsson.ntf.ref.intf.NtfPersonalizationIntf;
import com.ericsson.ntf.ref.intf.NtfProductInfoIntf;
import com.ericsson.ntf.ref.intf.NtfReferenceDataIntf;

public class NtfPersistenceFileImpl implements NtfPersistenceIntf {

    @Override
    public void init() {
    }

    @Override
    public void dbConnect() {

    }

    @Override
    public void shutdown() {
    }

    @Override
    public NtfReferenceDataIntf getReferenceData() {
        return new NtfReferenceDataFileImplV2();
    }

    @Override
    public NtfProductInfoIntf getProductInfo() {
        return new NtfProductInfoFileImpl();
    }

    @Override
    public NtfPersonalizationIntf getPersonlization() {
        return null;
    }

}
