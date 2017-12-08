package com.jewelry.utils;

import java.util.HashMap;
import java.util.Map;

public class ApiStatus {
    public final static int ok = 0;
    public static Map<Integer, String> msg = new HashMap<Integer, String>();

    static {
        msg.put(ok, "OK");
    }
}
