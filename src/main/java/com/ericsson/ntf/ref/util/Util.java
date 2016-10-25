package com.ericsson.ntf.ref.util;

public class Util {
    public static long toLong(String str) {
        if (str == null || str.length() == 0)
            return 0;
        return Long.parseLong(str);
    }

}