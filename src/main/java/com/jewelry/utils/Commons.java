package com.jewelry.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Commons {
    public final static String domain = "http://120.27.15.2/";
    public final static String transfer_url = "http://api.fixer.io/latest?base=CNY";

    public static Double getUSD(){
        String result = HttpClientUtil.HttpGet(transfer_url, "utf-8");
        if (result == null) return 0d;
        JSONObject jsonObject = JSON.parseObject(result);
        return  jsonObject.getJSONObject("rates").getDouble("USD");
    }
}
