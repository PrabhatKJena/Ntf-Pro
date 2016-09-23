package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.common.message.CustomerRecord;
import com.ericsson.ntf.ref.intf.NtfPersonalizationIntf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class NtfPersonalizationFileImpl implements NtfPersonalizationIntf {

    private static Logger logger = LoggerFactory.getLogger(NtfPersonalizationFileImpl.class);

    private static final String CUST_RECORD_FILE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\cpm.customerrecord.csv";

    /*private static final String[] columnNames = new String[]{"subscriberId", "contractId", "language", "notifyFlag", "startTime", "endTime", "channel", "email",
            "timeZone", "msisdn", "partyNameATitle", "partyNameFamPrefix", "partyNameFamily", "partyNameFormOfAddress", "partyNameFormatted", "partyNameGiven",
            "partyNamePrefGiven", "partyNameQualifications", "partyNameMiddle"};*/
    private static final String SUBSCRIPTION_ID_COLUMN_NAME = "subscriberId";
    private static final String CONTACT_ID_COLUMN_NAME = "contractId";

    private CellProcessor[] customerProductCellProcessor = new CellProcessor[]{
            new NotNull(), // column value must not null in CSV file
            new NotNull(), // column value must not null in CSV file
            new NotNull(), // column value must not null in CSV file
            new ParseBool(new NotNull()), // column value must not null and Boolean value in CSV file
            new NotNull(), // startTime
            new Optional(), // column value must not null in CSV file
            new NotNull(), // column value must not null in CSV file
            new NotNull(), // email
            new Optional(), // timezone
            new NotNull(), // msisdn
            new Optional(), // partyNameATitle
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
    };

    @Override
    public CustomerRecord getCustomerRecord(String subscriberId, String contractId) {
        if (subscriberId == null || contractId == null || subscriberId.trim().length() == 0 || contractId.trim().length() == 0) {
            return null;
        }
        CsvMapReader custRecordBeanReader = null;
        try {
            custRecordBeanReader = new CsvMapReader(new FileReader(CUST_RECORD_FILE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = custRecordBeanReader.getHeader(true);
            Map<String, Object> customerRecordMap = null;
            CustomerRecord customerRecord = null;
            while ((customerRecordMap = custRecordBeanReader.read(header, customerProductCellProcessor)) != null) {
                if (subscriberId.equals(customerRecordMap.get(SUBSCRIPTION_ID_COLUMN_NAME)) && contractId.equals(customerRecordMap.get(CONTACT_ID_COLUMN_NAME))) {
                    customerRecord = buildCustomerRecord(customerRecordMap);
                    return customerRecord;
                }
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(custRecordBeanReader);
        }
        return null;
    }

    private CustomerRecord buildCustomerRecord(Map<String, Object> customerRecordMap) {
        CustomerRecord record = new CustomerRecord();
        record.setLanguage(customerRecordMap.get("language").toString());
        record.setNotifyFlag(Boolean.valueOf(customerRecordMap.get("notifyFlag").toString()));
        record.setStartTime(customerRecordMap.get("startTime").toString());
        record.setEndTime(customerRecordMap.get("endTime").toString());
        record.setChannel(customerRecordMap.get("channel").toString());
        record.setEmail(customerRecordMap.get("email").toString());
        record.setTimeZone(customerRecordMap.get("timeZone").toString());
        record.setMsisdn(customerRecordMap.get("msisdn").toString());
        record.setPartyNameATitle(customerRecordMap.get("partyNameATitle").toString());
        record.setPartyNameFamily(customerRecordMap.get("partyNameFamily").toString());
        record.setPartyNameFamPrefix(customerRecordMap.get("partyNameFamPrefix").toString());
        record.setPartyNameFormatted(customerRecordMap.get("partyNameFormatted").toString());
        record.setPartyNameFormOfAddress(customerRecordMap.get("partyNameFormOfAddress").toString());
        record.setPartyNameGiven(customerRecordMap.get("partyNameGiven").toString());
        record.setPartyNameMiddle(customerRecordMap.get("partyNameMiddle").toString());
        record.setPartyNamePrefGiven(customerRecordMap.get("partyNamePrefGiven").toString());
        record.setPartyNameQualifications(customerRecordMap.get("partyNameQualifications").toString());
        return record;
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
