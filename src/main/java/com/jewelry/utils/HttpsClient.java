package com.jewelry.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.util.Map;

public class HttpsClient {
    private static Logger logger = LoggerFactory.getLogger(HttpsClient.class);
    private static final int HTTPS_READ_TIME_OUT = 20000;
    private static final int HTTPS_CON_TIME_OUT = 20000;

    static {
//        // 声明SSL上下文
//        SSLContext sslContext = null;
//        // 实例化主机名验证接口
//        //HostnameVerifier hnv = new HostnameVerifier();
//        try {
//            sslContext = getSSLContext(password, keyStorePath, trustStorePath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (sslContext != null) {
//            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext
//                    .getSocketFactory());
//        }
//        //HttpsURLConnection.setDefaultHostnameVerifier(hnv);
    }

    public static KeyStore getKeyStore(String password, String keyStorePath)
            throws Exception {
        // 实例化密钥库
        KeyStore ks = KeyStore.getInstance("JKS");
        // 获得密钥库文件流
        FileInputStream is = new FileInputStream(keyStorePath);
        // 加载密钥库
        ks.load(is, password.toCharArray());
        // 关闭密钥库文件流
        is.close();
        return ks;
    }

    /**
     * 获得SSLSocketFactory.
     * @param password
     *            密码
     * @param keyStorePath
     *            密钥库路径
     * @param trustStorePath
     *            信任库路径
     * @return SSLSocketFactory
     * @throws Exception
     */
    public static SSLContext getSSLContext(String password,
                                           String keyStorePath, String trustStorePath) throws Exception {
        // 实例化密钥库
        KeyManagerFactory keyManagerFactory = KeyManagerFactory
                .getInstance(KeyManagerFactory.getDefaultAlgorithm());
        // 获得密钥库
        KeyStore keyStore = getKeyStore(password, keyStorePath);
        // 初始化密钥工厂
        keyManagerFactory.init(keyStore, password.toCharArray());

        // 实例化信任库
        TrustManagerFactory trustManagerFactory = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        // 获得信任库
        KeyStore trustStore = getKeyStore(password, trustStorePath);
        // 初始化信任库
        trustManagerFactory.init(trustStore);
        // 实例化SSL上下文
        SSLContext ctx = SSLContext.getInstance("TLS");
        // 初始化SSL上下文
        ctx.init(keyManagerFactory.getKeyManagers(),
                trustManagerFactory.getTrustManagers(), null);
        // 获得SSLSocketFactory
        return ctx;
    }

    /**
     * raw 方式发送post请求
     * @param httpsUrl
     * @param encoding
     * @param data
     * @return
     */
    public static String HttpsPost(String httpsUrl, String encoding, String data) {
        HttpsURLConnection urlCon = null;
        try {
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
            urlCon.setDoInput(true);
            urlCon.setDoOutput(true);
            urlCon.setRequestMethod("POST");
            urlCon.setUseCaches(false);
            urlCon.setConnectTimeout(HTTPS_CON_TIME_OUT);
            urlCon.setReadTimeout(HTTPS_READ_TIME_OUT);
            //设置为gbk可以解决服务器接收时读取的数据中文乱码问题
            urlCon.getOutputStream().write(data.getBytes("utf-8"));
            urlCon.getOutputStream().flush();
            urlCon.getOutputStream().close();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlCon.getInputStream()));
            String line;
            String out="";
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out+=line;
            }
            logger.info("url={},postData={},ret={}", httpsUrl, data, out);
            return out;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String HttpsPost(String httpsUrl, String encoding,
                                   Map<String, String> headInfo){
        HttpsURLConnection urlCon = null;
        try {
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
            urlCon.setDoInput(true);
            urlCon.setDoOutput(true);
            urlCon.setRequestMethod("POST");
            urlCon.setUseCaches(false);
            urlCon.setConnectTimeout(HTTPS_CON_TIME_OUT);
            urlCon.setReadTimeout(HTTPS_READ_TIME_OUT);
            for (String key:headInfo.keySet()){
                urlCon.addRequestProperty(key, headInfo.get(key));
            }
            //设置为gbk可以解决服务器接收时读取的数据中文乱码问题
            urlCon.getOutputStream().flush();
            urlCon.getOutputStream().close();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlCon.getInputStream()));
            String line;
            String out="";
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out+=line;
            }
            logger.info("url={},ret={}", httpsUrl, out);
            return out;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String HttpsGet(String httpsUrl, String encoding){
        HttpsURLConnection urlCon = null;
        try {
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
            urlCon.setDoInput(true);
            urlCon.setDoOutput(true);
            urlCon.setRequestMethod("GET");
            urlCon.setUseCaches(false);
            urlCon.setConnectTimeout(HTTPS_CON_TIME_OUT);
            urlCon.setReadTimeout(HTTPS_READ_TIME_OUT);
            //设置为gbk可以解决服务器接收时读取的数据中文乱码问题
            urlCon.getOutputStream().flush();
            urlCon.getOutputStream().close();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlCon.getInputStream()));
            String line;
            String out="";
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out+=line;
            }
            logger.info("url={},ret={}", httpsUrl, out);
            return out;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String HttpsGet(String httpsUrl, String encoding, Map<String, String> headInfo){
        HttpsURLConnection urlCon = null;
        try {
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
            urlCon.setDoInput(true);
            urlCon.setDoOutput(true);
            urlCon.setRequestMethod("GET");
            urlCon.setUseCaches(false);
            urlCon.setConnectTimeout(HTTPS_CON_TIME_OUT);
            urlCon.setReadTimeout(HTTPS_READ_TIME_OUT);
            for (String key:headInfo.keySet()){
                urlCon.addRequestProperty(key, headInfo.get(key));
            }

            //设置为gbk可以解决服务器接收时读取的数据中文乱码问题
            urlCon.getOutputStream().flush();
            urlCon.getOutputStream().close();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlCon.getInputStream()));
            String line;
            String out="";
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out+=line;
            }
            logger.info("url={},ret={}", httpsUrl, out);
            return out;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
