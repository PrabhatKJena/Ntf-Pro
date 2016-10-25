package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.ref.data.tblentities.NtfLanguage;
import com.ericsson.ntf.ref.data.tblentities.NtfUnitOfMeasurement;
import com.ericsson.ntf.ref.intf.NtfReferenceDataIntf;
import com.ericsson.ntf.ref.util.CSVFileReader;
import com.ericsson.ntf.ref.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.io.ICsvReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NtfReferenceDataFileImplV2 implements NtfReferenceDataIntf {
    private static Logger logger = LoggerFactory.getLogger(NtfPersistenceFileImpl.class);

    private static final String UOM_FILE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.unitofmeasurement.csv";

    private List<NtfUnitOfMeasurement> ntfUnitOfMeasurementList;
    private String[] uomColumns = new String[]{"uom","description","measure","scaleFactorNum","scaleFactorDenoExp","baseUnitFlag","symbol"};

    @Override
    public List<NtfLanguage> getLanguageList() {
        return null;
    }

    @Override
    public List<NtfUnitOfMeasurement> getUnitOfMeasurements() {
        CSVFileReader fileReader  = null;
        Map<String, String> rowDataMap = null;
        try {
            fileReader = new CSVFileReader(UOM_FILE_PATH);
            NtfUnitOfMeasurement measurement = null;
            ntfUnitOfMeasurementList = new ArrayList<NtfUnitOfMeasurement>();
            while ((rowDataMap = fileReader.readLineAsMap()) != null) {
                measurement = new NtfUnitOfMeasurement();
                measurement.setUom(rowDataMap.get(uomColumns[0]));
                measurement.setDescription(rowDataMap.get(uomColumns[1]));
                measurement.setMeasure(rowDataMap.get(uomColumns[2]));
                measurement.setScaleFactorNum(Util.toLong(rowDataMap.get(uomColumns[3])));
                // Ignored uomColumns[4] -> scaleFactorDenoExp
                measurement.setBaseUnitFlag(Boolean.parseBoolean(rowDataMap.get(uomColumns[5])));
                measurement.setSymbol(rowDataMap.get(uomColumns[6]));

                ntfUnitOfMeasurementList.add(measurement);
            }
        } catch (IOException e) {
            System.out.println("Error while processing file.");
        }finally {
            fileReader.close();
        }
        return ntfUnitOfMeasurementList;
    }

    @Override
    public NtfUnitOfMeasurement getUnitOfMeasurement(String unitName) {
        if (unitName == null || unitName.trim().length() == 0) {
            return null;
        }
        if (ntfUnitOfMeasurementList == null || ntfUnitOfMeasurementList.size() == 0)
            getUnitOfMeasurements();

        for (NtfUnitOfMeasurement measurement : ntfUnitOfMeasurementList) {
            if (unitName.equals(measurement.getUom()))
                return measurement;
        }
        return null;
    }

    @Override
    public String getContactTypeKey(String contactTypeName) {
        return null;
    }

    @Override
    public String getContactRoleKey(String contactRoleName) {
        return null;
    }

    @Override
    public void clearCache() {
        ntfUnitOfMeasurementList = null;
    }

    private void closeReader(ICsvReader beanReader) {
        try {
            if (beanReader != null)
                beanReader.close();
        } catch (IOException e) {
            logger.error("Error while trying to close file  reader" + e.getMessage());
        }
    }

}
