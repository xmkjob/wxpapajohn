package com.papa.wx.web.util;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.SystemDefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONObject;



public class JsonUtil {

 //得到HttpClient

   
	public HttpClient getHttpClient(){
		
		  HttpParams mHttpParams=new BasicHttpParams();
	        //设置网络链接超时
	        //�?:Set the timeout in milliseconds until a connection is established.
	        HttpConnectionParams.setConnectionTimeout(mHttpParams, 20*1000);
	        //设置socket响应超时
	        //�?:in milliseconds which is the timeout for waiting for data.
	        HttpConnectionParams.setSoTimeout(mHttpParams, 20*1000);
	        //设置socket缓存大小
	        HttpConnectionParams.setSocketBufferSize(mHttpParams, 8*1024);
	        //设置是否可以重定�?
	        HttpClientParams.setRedirecting(mHttpParams, true);
	         
	        HttpClient httpClient=new DefaultHttpClient(mHttpParams);
	        return httpClient;
    }
     
    //得到JSONObject(Get方式)
    public JSONObject getJSONObjectByGet(String urlString){
        JSONObject resultJsonObject=null;
        if ("".equals(urlString)||urlString==null) {
            return null;
        }
        HttpClient httpClient=new JsonUtil().getHttpClient();
        
        
     //   System.out.println(httpClient.getParams().getParameter("type"));
        StringBuilder urlStringBuilder=new StringBuilder(urlString);
        StringBuilder entityStringBuilder=new StringBuilder();
        //利用URL生成�?个HttpGet请求
        HttpGet httpGet=new HttpGet(urlStringBuilder.toString());
        BufferedReader bufferedReader=null;
        HttpResponse httpResponse=null;
        try {
            //HttpClient发出�?个HttpGet请求
            httpResponse=httpClient.execute(httpGet);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //得到httpResponse的状态响应码
        int statusCode=httpResponse.getStatusLine().getStatusCode();
        if (statusCode==HttpStatus.SC_OK) {
            //得到httpResponse的实体数�?
            HttpEntity httpEntity=httpResponse.getEntity();
            if (httpEntity!=null) {
                try {
                    bufferedReader=new BufferedReader
                    (new InputStreamReader(httpEntity.getContent(), "UTF-8"), 8*1024);
                    String line=null;
                    while ((line=bufferedReader.readLine())!=null) {
                        //entityStringBuilder.append(line+"/n");
                    	entityStringBuilder.append(line);
                    }
                    //利用从HttpEntity中得到的String生成JsonObject
                    
                    
                    String json=entityStringBuilder.toString();
                   // System.out.println(json.substring(0, json.length()));
                    resultJsonObject=new JSONObject(json.substring(0, json.length()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultJsonObject;
    }
     
    
    private Map map = new LinkedHashMap();

    /**
     * 添加一个 JSON 属性，值为一个字符串，重复添加时产生数组<p/>
     * 
     * add("name", "value");<br/>
     * 添加一个字符串，产生的 JSON 如：{"name":"value"}<p/>
     * 
     * add("name", "value1");<br/>
     * add("name", "value2");<br/>
     * 添加两个同属性的字符串，产生的 JSON 如：{"name":["value1", "value2"]}<p/>
     * 
     * @param key       JSON 属性名
      * @param str       字符串格式的属性值
      */
    public void add(String key, String value) {
        addElement(key, value);
    }
    
    public void add(String key, int num) {
        addElement(key, new Integer(num));
    }
    
    public void add(String key, boolean b) {
        addElement(key, new Boolean(b));
    }

    /**
     * 添加一个 JSON 属性，值为一个 JSON，重复添加时产生 JSON 数组<p/>
     * 
     * Json json1 = new Json();<br/>
     * json1.add("name1", "value1");<br/>
     * json1.add("name2", "value2");<br/>
     * Json json = new Json();<br/>
     * json.add("message", json1);<br/>
     * 添加一个 JSON，产生的 JSON 如：{"message":{"name1":"value1", "name2":"value2"}}<p/>
     * 
     * Json json1 = new Json();<br/>
     * json1.add("name1", "value1");<br/>
     * json1.add("name2", "value2");<br/>
     * Json json2 = new Json();<br/>
     * json2.add("name1", "value3");<br/>
     * json2.add("name2", "value4");<br/>
     * Json json = new Json();<br/>
     * json.add("message", json1);<br/>
     * json.add("message", json2);<br/>
     * 添加两个同属性的 JSON，产生的 JSON 如：{"message":[{"name1":"value1", "name2":"value2"}, {"name1":"value3", "name2":"value4"}]}<p/>
     * 
     * @param key       JSON 属性名
      * @param json      JSON 格式的属性值
      */
    public void add(String key, JsonUtil json) {
        addElement(key, json);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int k = 0;
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            String key = (String)(i.next());
            Object obj = map.get(key);
            if (k > 0) {
                sb.append(",");
            }
            appendKey(sb, key);
            if (obj instanceof String) {
                appendString(sb, (String)obj);
            } else if (obj instanceof List) {
                appendList(sb, (List)obj);
            } else if (obj instanceof JsonUtil) {
                appendJson(sb, (JsonUtil)obj);
            } else {
                appendOther(sb, obj);
            }
            k++;
        }
        sb.append("}");
        return sb.toString();
    }

    private void addElement(String key, Object obj) {
        if (!map.containsKey(key)) {
            if(obj instanceof JsonUtil) {
                List list = new ArrayList();
                list.add(obj);
                map.put(key, list);
            } else {
                map.put(key, obj);
            }
            return;
        }

        Object o = map.remove(key);

        if (o instanceof List) {
            ((List)o).add(obj);
            map.put(key, o);
            return;
        }

        // o is a String
        List list = new ArrayList();
        list.add(o);
        list.add(obj);
        map.put(key, list);
    }

    /**
     * Append JSON property name
     * 
     * @param sb
     * @param key
     */
    private void appendKey(StringBuilder sb, String key) {
        sb.append("\"").append(key).append("\":");
    }

    /**
     * Append JSON property value that is a String
     * 
     * @param sb
     * @param str
     */
    private void appendString(StringBuilder sb, String str) {
        sb.append("\"").append(str).append("\"");
    }
    
    /**
     * Append JSON property value that is a Integer
     * 
     * @param sb
     * @param num
     */
    private void appendOther(StringBuilder sb, Object obj) {
        sb.append(obj);
    }

    /**
     * Append JSON property value that is a List
     * 
     * @param sb
     * @param list
     */
    private void appendList(StringBuilder sb, List list) {
        sb.append("[");
        for (int j = 0, m = list.size(); j < m; j++) {
            if (j > 0) {
                sb.append(",");
            }
            Object obj = list.get(j);
            if (obj instanceof String) {
                appendString(sb, (String)obj);
            } else if (obj instanceof JsonUtil) {
                appendJson(sb, (JsonUtil)obj);
            } else {
                appendOther(sb, obj);
            }
        }
        sb.append("]");
    }

    /**
     * Append JSON property value that is a JSON
     * 
     * @param sb
     * @param json
     */
    private void appendJson(StringBuilder sb, JsonUtil json) {
        sb.append(json.toString());
    }
    

  /*  public static void main(String[] args) throws ParseException {
    	
    	//获取楼盘
		String url = "http://xinfangim-qa.sohusce.com/auto/groups?cityId=1";
		JSONObject json = new JsonUtil().getJSONObjectByGet(url);
		JSONArray groups = json.getJSONArray("data");  
    	System.out.println(groups);
	}*/
}
