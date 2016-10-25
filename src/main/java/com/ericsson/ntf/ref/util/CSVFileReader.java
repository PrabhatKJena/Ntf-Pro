package com.ericsson.ntf.ref.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CSVFileReader {

    private LineNumberReader reader = null;
    private String[] columnNames = null;

    public CSVFileReader(String filePath) throws IOException {
        reader = new LineNumberReader(new FileReader(filePath));
        String line = null;
        if ((line = reader.readLine()) != null) {
            columnNames = extractColumnNames(line);
        }
    }

    public Map<String, String> readLineAsMap() throws IOException {
        String line = null;
        Map<String, String> rowDataMap = null;
        if ((line = reader.readLine()) != null) {
            rowDataMap = processLineData(line);
        }
        return rowDataMap;
    }

    private Map<String, String> processLineData(String line) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        if (line != null && line.length() > 0) {
            String[] strings = line.split(COLUMN_SEPARATOR);
            int cl = columnNames == null ? 0 : columnNames.length;
            int sl = strings == null ? 0 : strings.length;
            if (cl != sl) {
                throw new IOException("No of columns data mismatch with no of headers.");
            }
            for (int i = 0; i < strings.length; i++) {
                map.put(columnNames[i], strings[i] == null ? null : strings[i].trim());
            }
        }
        return map;
    }

    private static final String COLUMN_SEPARATOR = ",";

    private String[] extractColumnNames(String line) {
        if (line != null && line.length() > 0) {
            return line.split(COLUMN_SEPARATOR);
        }
        return null;
    }

    public void close() {
        if (reader != null)
            try {
                reader.close();
            } catch (IOException e) {
            }
    }

}
