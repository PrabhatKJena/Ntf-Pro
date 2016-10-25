package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.ref.data.tblentities.NtfUnitOfMeasurement;
import com.ericsson.ntf.ref.intf.NtfPersistenceIntf;
import com.ericsson.ntf.ref.intf.NtfReferenceDataIntf;

import java.util.List;

public class NtfReferenceDataFileImplTest {
    public static void main(String[] args) {
        NtfPersistenceIntf persistenceIntf = new NtfPersistenceFileImpl();
        NtfReferenceDataIntf referenceData = persistenceIntf.getReferenceData();

        // Test getLanguage()
//        fetchLanguageData(referenceData);
        // Test getUnitOfMesaurment
        fetchMesurementData(referenceData);

        NtfUnitOfMeasurement measurement = referenceData.getUnitOfMeasurement("aa");
        System.out.println(">>>> NtfUnitOfMeasurement by uniName: "+measurement);

        System.out.println(">>>> ContactType : "+referenceData.getContactTypeKey("CONTACT_NAME2"));
        System.out.println(">>>> ContactRole : "+referenceData.getContactRoleKey("ROLE_NAME2"));

        System.out.println("----Afrcte clearing cache ------");
        referenceData.clearCache();
//        fetchLanguageData(referenceData);
        fetchMesurementData(referenceData);

    }

    private static void fetchMesurementData(NtfReferenceDataIntf referenceData) {
        List<NtfUnitOfMeasurement> unitOfMeasurements = referenceData.getUnitOfMeasurements();
        System.out.println(">>> List of NtfUnitOfMeasurement");
        for (NtfUnitOfMeasurement unitOfMeasurement : unitOfMeasurements) {
            System.out.println(unitOfMeasurement);
        }
    }

   /* private static void fetchLanguageData(NtfReferenceDataIntf referenceData) {
        List<NtfLanguage> languages = referenceData.getLanguages();
        System.out.println(">>>> List of NtfLanguage");
        for (NtfLanguage language : languages) {
            System.out.println(language);
        }
    }*/

}
