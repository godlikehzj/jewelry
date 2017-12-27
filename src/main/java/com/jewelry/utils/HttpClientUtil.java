package com.jewelry.utils;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

public class HttpClientUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    public static final int HTTP_CON_TIME_OUT = 20000;
    public static final int HTTP_SO_TIME_OUT = 20000;

    /**
     * form-data 或x-www-form-urlencoded的key-value方式发送post请求
     *
     * @param url
     * @param encoding
     * @param paramMap
     * @return
     */
    public static String HttpPost(String url, String encoding, Map<String, String> paramMap) {
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(params, HTTP_SO_TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(params, HTTP_CON_TIME_OUT);
        httpclient = new DefaultHttpClient(params);
        HttpPost httpPost = new HttpPost(url);

        httpPost.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);
        // 建立一个NameValuePair数组，用于存储欲传递的参数
        List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();
        // 添加参数
        Iterator<String> iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = paramMap.get(key);
            data.add(new BasicNameValuePair(key, value));
        }

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(data, "utf-8"));
            retString = httpclient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={}, postData={}, ret={}", url, paramMap.toString(), retString);
        return retString;
    }


    /**
     * raw 方式发送post请求
     * @param url
     * @param encoding
     * @param data
     * @return
     */
    public static String HttpPost(String url, String encoding, String data, Integer timeout){
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(params, timeout);
        HttpConnectionParams.setConnectionTimeout(params, timeout);
        httpclient = new DefaultHttpClient(params);
        HttpPost httpPost = new HttpPost(url);

        httpPost.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            StringEntity postData = new StringEntity(data,encoding);
            httpPost.setEntity(postData);
            retString = httpclient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={},postData={},ret={}", url, data, retString);
        return retString;
    }

    /**
     * raw 方式发送post请求
     * @param url
     * @param encoding
     * @param data
     * @return
     */
    public static String HttpPost(String url, String encoding, String data){
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(params, HTTP_SO_TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(params, HTTP_CON_TIME_OUT);
        httpclient = new DefaultHttpClient(params);
        HttpPost httpPost = new HttpPost(url);

        httpPost.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            StringEntity postData = new StringEntity(data,encoding);
            httpPost.setEntity(postData);
            retString = httpclient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={},postData={},ret={}", url, data, retString);
        return retString;
    }

    public static String HttpPost(String url, String encoding){
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(params, HTTP_SO_TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(params, HTTP_CON_TIME_OUT);
        httpclient = new DefaultHttpClient(params);
        HttpPost httpPost = new HttpPost(url);

        httpPost.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);


        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            retString = httpclient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={},ret={}", url, retString);
        return retString;
    }

    public static String HttpPost(String url, String encoding,Map<String, String> headInfo, Map<String, String> paramMap){
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(params, HTTP_SO_TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(params, HTTP_CON_TIME_OUT);
        httpclient = new DefaultHttpClient(params);
        HttpPost httpPost = new HttpPost(url);

        for (String key:headInfo.keySet()){
            httpPost.setHeader(key, headInfo.get(key));
        }

        httpPost.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);
        // 建立一个NameValuePair数组，用于存储欲传递的参数
        List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();
        // 添加参数
        Iterator<String> iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = paramMap.get(key);
            data.add(new BasicNameValuePair(key, value));
        }

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(data,"utf-8"));
            retString = httpclient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={},head={},postData={},ret={}", url, headInfo.toString(), paramMap.toString(),  retString);
        return retString;
    }

    public static String HttpGet(String url, String encoding, Integer timeout){
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        if (timeout != -1){
            HttpConnectionParams.setSoTimeout(params, timeout);
            HttpConnectionParams.setConnectionTimeout(params, timeout);
        }

        httpclient = new DefaultHttpClient(params);
        HttpGet httpGet = new HttpGet(url);

        httpGet.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            retString = httpclient.execute(httpGet, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={},ret={}", url, retString);

        return retString;
    }

    public static String HttpGet(String url, String encoding){
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(params, HTTP_SO_TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(params, HTTP_CON_TIME_OUT);
        httpclient = new DefaultHttpClient(params);
        HttpGet httpGet = new HttpGet(url);

        httpGet.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            retString = httpclient.execute(httpGet, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={},ret={}", url, retString);

        return retString;
    }

    public static String HttpGet(String url, String encoding, Map<String, String> headInfo){
        String retString = null;
        HttpParams params = new BasicHttpParams();
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(params, HTTP_SO_TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(params, HTTP_CON_TIME_OUT);
        httpclient = new DefaultHttpClient(params);
        HttpGet httpGet = new HttpGet(url);

        for (String key:headInfo.keySet()){
            httpGet.setHeader(key, headInfo.get(key));
        }

        httpGet.getParams().setParameter(HttpProtocolParams.HTTP_CONTENT_CHARSET, encoding);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            retString = httpclient.execute(httpGet, responseHandler);
        } catch (ClientProtocolException e) {
            logger.error(" catch error : ", e);
        } catch (IOException e) {
            logger.error(" catch error : ", e);
        }
        logger.info("url={},head={},ret={}", url, headInfo.toString(), retString);

        return retString;
    }


    /*
     * 随机生成国内IP地址
     */
    public static String getRandomIp(){
        //ip范围
        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
                {1038614528,1039007743},//61.232.0.0-61.237.255.255
                {1783627776,1784676351},//106.80.0.0-106.95.255.255
                {2035023872,2035154943},//121.76.0.0-121.77.255.255
                {2078801920,2079064063},//123.232.0.0-123.235.255.255
                {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
                {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
                {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
                {-770113536,-768606209},//210.25.0.0-210.47.255.255
                {-569376768,-564133889}, //222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
        return ip;
    }

    /*
         * 将十进制转换成ip地址
         */
    private static String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";

        b[0] = (int)((ip >> 24) & 0xff);
        b[1] = (int)((ip >> 16) & 0xff);
        b[2] = (int)((ip >> 8) & 0xff);
        b[3] = (int)(ip & 0xff);
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]);

        return x;
    }


    public static String getIpAddress(HttpServletRequest request){
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Real-IP");
        if (logger.isInfoEnabled()) {
            logger.info("getIpAddress(HttpServletRequest) - X-Real-IP - String ip=" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
            if (logger.isInfoEnabled()) {
                logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
            }
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
