package com.ericsson.ntf.ref.file.impl;

import com.ericsson.ntf.ref.intf.NtfProductInfoIntf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class NtfProductInfoFileImpl implements NtfProductInfoIntf {

    public static final String PRODUCT_ID_COLUMN_NAME = "productOfferingId";
    public static final String PRODUCT_NAME_COLUMN_NAME = "productName";
    public static final String BUCKET_ID_COLUMN_NAME = "bucketSpecId";
    public static final String BUCKET_NAME_COLUMN_NAME = "bucketName";
    public static final String THRESHOLD_ID_COLUMN_NAME = "thresholdSpecId";
    public static final String THRESHOLD_NAME_COLUMN_NAME = "thresholdName";

    private static Logger logger = LoggerFactory.getLogger(NtfPersistenceFileImpl.class);

    private static final String PRODUCT_FILE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.product.csv";
    private static final String BUCKET_FILE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.bucket.csv";
    private static final String THRESHOLD_FILE_PATH = "C:\\Users\\prajena\\Downloads\\Dheeraj_files\\coba.threshold.csv";

    private CellProcessor[] productInfoCellProcessor = new CellProcessor[]{
            new NotNull(), // column value must not null in CSV file
            new NotNull() // column value must not null in CSV file
    };
    private CellProcessor[] bucketCellProcessor = new CellProcessor[]{
            new NotNull(), // column value must not null in CSV file
            new NotNull() // column value must not null in CSV file
    };
    private CellProcessor[] thresholdCellProcessor = new CellProcessor[]{
            new NotNull(), // column value must not null in CSV file
            new NotNull(), // column value must not null in CSV file
            new NotNull() // column value must not null in CSV file
    };

    @Override
    public String getProductName(String productOfferingId) {
        if (productOfferingId == null || productOfferingId.length() == 0) {
            return null;
        }

        CsvMapReader productBeanReader = null;
        try {
            productBeanReader = new CsvMapReader(new FileReader(PRODUCT_FILE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = productBeanReader.getHeader(true);
            Map<String, Object> productInfo = null;
            while ((productInfo = productBeanReader.read(header, productInfoCellProcessor)) != null) {
                if (productOfferingId.equals(productInfo.get(PRODUCT_ID_COLUMN_NAME))) {
                    return (String) productInfo.get(PRODUCT_NAME_COLUMN_NAME);
                }
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(productBeanReader);
        }
        return null;
    }

    @Override
    public String getBucketName(String bucketSpecId) {
        if (bucketSpecId == null || bucketSpecId.length() == 0) {
            return null;
        }

        CsvMapReader bucketBeanReader = null;
        try {
            bucketBeanReader = new CsvMapReader(new FileReader(BUCKET_FILE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = bucketBeanReader.getHeader(true);
            Map<String, Object> bucketInfo = null;
            while ((bucketInfo = bucketBeanReader.read(header, bucketCellProcessor)) != null) {
                if (bucketSpecId.equals(bucketInfo.get(BUCKET_ID_COLUMN_NAME))) {
                    return (String) bucketInfo.get(BUCKET_NAME_COLUMN_NAME);
                }
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(bucketBeanReader);
        }
        return null;
    }

    @Override
    public String getThresholdName(String bucketSpecId, String thresholdSpecId) {
        if (bucketSpecId == null || bucketSpecId.length() == 0 || thresholdSpecId == null || thresholdSpecId.length() == 0) {
            return null;
        }

        String thresholdName = null;
        CsvMapReader thresholdMapReader = null;
        try {
            thresholdMapReader = new CsvMapReader(new FileReader(THRESHOLD_FILE_PATH), CsvPreference.STANDARD_PREFERENCE);
            String[] header = thresholdMapReader.getHeader(true);
            Map<String, Object> thresholdInfo = null;
            while ((thresholdInfo = thresholdMapReader.read(header, thresholdCellProcessor)) != null) {
                if (bucketSpecId.equals(thresholdInfo.get(BUCKET_ID_COLUMN_NAME)) && thresholdSpecId.equals(thresholdInfo.get(THRESHOLD_ID_COLUMN_NAME))) {
                    return (String) thresholdInfo.get(THRESHOLD_NAME_COLUMN_NAME);
                }
            }
        } catch (IOException e) {
            logger.error("Error while processing file " + e.getMessage());
        } finally {
            closeReader(thresholdMapReader);
        }

        return thresholdName;
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
