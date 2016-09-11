package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.ref.data.tblentities.NtfContactRole;
import com.ericsson.ntf.ref.data.tblentities.NtfContactType;
import com.ericsson.ntf.ref.data.tblentities.NtfLanguage;
import com.ericsson.ntf.ref.data.tblentities.NtfUnitOfMeasurement;
import com.ericsson.ntf.ref.intf.NtfReferenceDataIntf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NtfReferenceDataFileImpl implements NtfReferenceDataIntf {
    private static Logger logger = LoggerFactory.getLogger(NtfPersistenceFileImpl.class);

    private static final String LANG_FILE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.language.csv";
    private static final String UOM_FILE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.unitofmeasurement.csv";
    private static final String CONTACT_TYPE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.contacttype.csv";
    private static final String CONTACT_ROLE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.contactrole.csv";

    private CellProcessor[] langCellProcessor = new CellProcessor[]{
            new NotNull(), // column value must not null in CSV file
            new NotNull() // column value must not null in CSV file
    };
    private CellProcessor[] uomCellProcessor = new CellProcessor[]{
            new NotNull(),
            new NotNull(),
            new ParseLong(), // for Long data from CSV
            new ParseLong(new NotNull()), // for Long data from CSV
            new ParseBool(new NotNull()), // for Boolean data from CSV
            new NotNull()
    };
    private CellProcessor[] contactTypeCellProcessor = new CellProcessor[]{
            new NotNull(), // column value must required in CSV file
            new NotNull() // column value must required in CSV file
    };
    private CellProcessor[] contactRoleCellProcessor = new CellProcessor[]{
            new NotNull(), // column value must required in CSV file
            new NotNull() // column value must required in CSV file
    };

    private List<NtfLanguage> ntfLanguageList;
    private List<NtfUnitOfMeasurement> ntfUnitOfMeasurementList;

    @Override
    public List<NtfLanguage> getLanguages() {
        if (ntfLanguageList != null && ntfLanguageList.size() > 0)
            return ntfLanguageList;

        ntfLanguageList = new ArrayList<NtfLanguage>();
        ICsvBeanReader langBeanReader = null;
        try {
            langBeanReader = new CsvBeanReader(new FileReader(LANG_FILE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = langBeanReader.getHeader(true);
            NtfLanguage langBean = null;
            while ((langBean = langBeanReader.read(NtfLanguage.class, header, langCellProcessor)) != null) {
                ntfLanguageList.add(langBean);
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(langBeanReader);
        }
        return ntfLanguageList;
    }

    @Override
    public List<NtfUnitOfMeasurement> getUnitOfMeasurements() {
        if (ntfUnitOfMeasurementList != null && ntfUnitOfMeasurementList.size() > 0)
            return ntfUnitOfMeasurementList;

        ntfUnitOfMeasurementList = new ArrayList<NtfUnitOfMeasurement>();
        ICsvBeanReader uomBeanReader = null;
        try {
            uomBeanReader = new CsvBeanReader(new FileReader(UOM_FILE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = uomBeanReader.getHeader(true);
            NtfUnitOfMeasurement measurementBean = null;
            while ((measurementBean = uomBeanReader.read(NtfUnitOfMeasurement.class, header, uomCellProcessor)) != null) {
                ntfUnitOfMeasurementList.add(measurementBean);
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(uomBeanReader);
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
        if (contactTypeName == null && contactTypeName.length() == 0)
            return null;
        ICsvBeanReader contactTypeBeanReader = null;
        try {
            contactTypeBeanReader = new CsvBeanReader(new FileReader(CONTACT_TYPE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = contactTypeBeanReader.getHeader(true);
            NtfContactType ntfContactType = null;
            while ((ntfContactType = contactTypeBeanReader.read(NtfContactType.class, header, contactTypeCellProcessor)) != null) {
                if (contactTypeName.equals(ntfContactType.getDescription())) {
                    return ntfContactType.getContactType();
                }
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(contactTypeBeanReader);
        }
        return null;
    }

    @Override
    public String getContactRoleKey(String contactRoleName) {
        if (contactRoleName == null && contactRoleName.length() == 0)
            return null;

        ICsvBeanReader contactRoleBeanReader = null;
        try {
            contactRoleBeanReader = new CsvBeanReader(new FileReader(CONTACT_ROLE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = contactRoleBeanReader.getHeader(true);
            NtfContactRole ntfContactRole = null;
            while ((ntfContactRole = contactRoleBeanReader.read(NtfContactRole.class, header, contactRoleCellProcessor)) != null) {
                if (contactRoleName.equals(ntfContactRole.getDescription())) {
                    return ntfContactRole.getContactRole();
                }
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(contactRoleBeanReader);
        }
        return null;
    }

    @Override
    public void clearCache() {
        ntfLanguageList = null;
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
