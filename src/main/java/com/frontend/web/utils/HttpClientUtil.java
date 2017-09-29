package com.frontend.web.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * 发送Post请求
     * @param url 请求的url地址
     * @param param 参数报文体
     * @param header 请求头信息
     * @return 处理结果报文
     * @throws IOException
     * @throws URISyntaxException
     * @author wangly
     */
    public static String sendPost(String url, String param, Map<String, String> header) throws IOException,
            URISyntaxException {
    	logger.info("restful request url:"+url);
    	logger.info("restful request param:"+param);
    	String charset = "utf-8";
    	if(header==null){
    		header = new HashMap<>();
    		header.put("Content-type", "application/x-www-form-urlencoded");
    	}
    	DubboRestResponse resp=new DubboRestResponse();
    	StringBuffer buffer = new StringBuffer();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        
        HttpPost httpPost = new HttpPost(new URL(url).toURI());
        if(header!=null){
        	for (Map.Entry<String, String> entry : header.entrySet()) {
        		httpPost.setHeader(entry.getKey(), entry.getValue());
        		if("charset".equals(entry.getKey())){
        		    charset = entry.getValue();
        		}
        	}        	
        }
        StringEntity dataEntity = new StringEntity(param, ContentType.APPLICATION_JSON);
        httpPost.setEntity(dataEntity);
        CloseableHttpResponse response = httpclient.execute(httpPost);
        try {
        	//请求成功且有返回体
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        entity.getContent(), charset));
                String tempStr;
                while ((tempStr = reader.readLine()) != null)
                    buffer.append(tempStr);
                resp.setResultCode("000000");
                resp.setResultMessage("请求成功");
                resp.setData(buffer.toString());
                logger.info("=============HttpPost请求成功，返回结果===="+JSON.toJSONString(resp)); 
                
            } 
            //请求成功，但没有返回体
            else if (response.getStatusLine().getStatusCode() == 204) {
            	resp = new DubboRestResponse();
            	resp.setResultCode(String.valueOf(response.getStatusLine().getStatusCode()));
            	resp.setResultMessage("请求成功，无返回体！");
            	String resp204Json = JSON.toJSONString(resp);
            	logger.info("=============HttpPost请求成功，无返回体===="+resp204Json.toString());
            	
            }
            //请求失败
            else {
            	resp = new DubboRestResponse();
            	resp.setResultCode(String.valueOf(response.getStatusLine().getStatusCode()));
            	resp.setResultMessage("请求异常！");
            	String respErrorJson = JSON.toJSONString(resp);
            	logger.error("=============HttpPost请求异常===="+respErrorJson.toString());
            	
            }
        }
        //系统异常
        catch(Exception e){
        	logger.error(e.getMessage(),e);
        	resp = new DubboRestResponse();
        	resp.setResultCode("DUBBO_REST_SYSTEM_ERROR");
        	resp.setResultMessage(e.getMessage());
        	String sysErrorJson = JSON.toJSONString(resp);
        	logger.error("=============HttpPost请求系统异常===="+sysErrorJson.toString(),e);
        }
        //释放资源
        finally {
        	try {
        		if(response != null ){
        			response.close();    			
        		}
        		if(httpclient != null ){
        			httpclient.close();    			
        		}
        	} catch (IOException e) {
	        	logger.error(e.getMessage(),e);
			}
        }
        
        return JSON.toJSONString(resp);
        
        
    }

    /**
     * 发送Post请求
     * @param url
     * @param param
     * @return
     * @author wangly
     */
    public static String sendPost(String url, String param) {
        logger.info("restful address : " + url);
        logger.info("param : " + param);
        String result = "";
        try {
            result = HttpClientUtil.sendPost(url, param, null);
            logger.info("result : " + result);
        } catch (IOException e) {
            String errorMessage = e.getMessage();
            logger.error(errorMessage, e);
        } catch (URISyntaxException e) {
            String errorMessage = e.getMessage();
            logger.error(errorMessage, e);
        }
        // 请求发生异常后，result 为 空
        return result;
    }

    /**
     * 发送GET请求
     * 
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendGet(String url, Map<String, String> parameters) {
    	return sendGet(url,parameters,null);
    }
    
    public static String sendGet(String url, Map<String, String> parameters, Map<String, String> header) {
    	DubboRestResponse resp=new DubboRestResponse();
    	StringBuffer buffer = new StringBuffer();// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        String full_url = url;
        try {
        	if(parameters!=null){
        		// 编码请求参数
        		if (parameters.size() == 1) {
        			for (String name : parameters.keySet()) {
        				sb.append(name).append("=")
        				.append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
        			}
        			params = sb.toString();
        		} else {
        			for (String name : parameters.keySet()) {
        				sb.append(name).append("=")
        				.append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
        				.append("&");
        			}
        			String temp_params = sb.toString();
        			params = temp_params.substring(0, temp_params.length() - 1);
        		}
        		if(!url.startsWith("?")){
        			full_url += "?" + params;        			
        		}
        		else{
        			full_url += "&" + params;    
        		}
        	}
            logger.info("restful address : " + full_url);
            // 创建URL对象
            URL connURL = new URL(full_url);
            
            // 打开URL连接
            HttpURLConnection httpConn = (HttpURLConnection) connURL
                    .openConnection();
            if(header!=null){
            	for (Map.Entry<String, String> entry : header.entrySet()) {
            		httpConn.addRequestProperty(entry.getKey(), entry.getValue());
            	}            	
            }
            // 建立实际的连接
            httpConn.connect();
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            
            resp.setResultCode("000000");
            resp.setResultMessage("请求成功");
            resp.setData(buffer.toString());
            logger.info("=============HttpGet请求成功，返回结果===="+JSON.toJSONString(resp));
            
            
        } catch (Exception e) {
        	logger.error(e.getMessage(),e);
        	resp = new DubboRestResponse();
        	resp.setResultCode("DUBBO_REST_SYSTEM_ERROR");
        	resp.setResultMessage(e.getMessage());
        	String sysErrorJson = JSON.toJSONString(resp);
        	logger.error("=============HttpGet请求系统异常===="+sysErrorJson,e);
        	
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return JSON.toJSONString(resp);
    }
    
    /**
     * 
     * @param url
     * @param query
     * @return
     * @throws Exception
     */
    public static String httpPost(String url,String query) throws Exception{
		URL restURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setAllowUserInteraction(false);
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print(query);
        ps.close();
        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line,resultStr="";
        while(null != (line=bReader.readLine())){
        	resultStr +=line;
        }
        bReader.close();
        return resultStr;
    }
    
    public static void main(String[] args) {
		String url = "http://192.168.97.13:8089/frontend-web//frontend/service/getArchByVar";
		JSONObject obj = new JSONObject();
		obj.put("reqData", "{\"pageCode\":\"P0001\",\"archCode\":\"PA001\"}");
		System.out.println(sendPost(url, "{\"pageCode\":\"P0001\",\"archCode\":\"PA001\"}"));
	}
}
