package cn.smart.test;

import cn.smart.commons.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientTest {

    public static void main(String[] args) throws Exception {
        //doGet();
        //doGetParam();
        //doPost();
        //doPostParam();
        //doPostJsonParam();
        customUtilsUse();
    }

    /**
     * Get请求不带参数
     */
    public static void doGet() throws IOException {
        //创建一个HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();

        //创建Get请求对象。在请求中输入url
        HttpGet get = new HttpGet("http://www.baidu.com");
        //发送请求，并返回相应
        CloseableHttpResponse response = client.execute(get);
        //处理响应
        //获取响应状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.println("响应码:" + code);

        //获取响应内容
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity, "utf-8");

        System.out.println("响应内容:" + content);

        //关闭链接
        client.close();


    }

    /**
     * Get请求带参数
     */
    public static void doGetParam() throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();

        //创建一个封装URL的对象。在该对象中可以给定请求参数/
        URIBuilder builder = new URIBuilder("https://www.sogou.com/web");
        builder.addParameter("query", "西游记");

        //创建GET请求
        HttpGet get = new HttpGet(builder.build());

        //发送请求，并返回相应
        CloseableHttpResponse response = client.execute(get);
        //处理响应
        //获取响应状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.println("响应码:" + code);

        //获取响应内容
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity, "utf-8");

        System.out.println("响应内容:" + content);

        //关闭链接
        client.close();

    }

    /**
     * Post请求不带参数
     */
    public static void doPost() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost post = new HttpPost("http://localhost/tes/httpPost");
        CloseableHttpResponse response = client.execute(post);

        //获取响应状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.println("响应码:" + code);

        //获取响应内容
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity, "utf-8");

        System.out.println("响应内容:" + content);

        //关闭链接
        client.close();

    }

    /**
     * Post请求带参数
     */
    public static void doPostParam() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost/tes/httpPost/param");
        //给定参数
        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("name", "啊的名"));
        list.add(new BasicNameValuePair("pwd", "admin"));

        //参数转换
        StringEntity entity = new UrlEncodedFormEntity(list, "utf-8");
        post.setEntity(entity);

        CloseableHttpResponse response = client.execute(post);

        //获取响应状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.println("响应码:" + code);

        //获取响应内容
        HttpEntity en = response.getEntity();
        String content = EntityUtils.toString(en, "utf-8");

        System.out.println("响应内容:" + content);

        //关闭链接
        client.close();

    }

    /**
     * Json格式请求参数
     */
    public static void doPostJsonParam() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost/tes/httpPost/param/json");

        String json = "{\"name\":\"张三丰\",\"pwd\":\"admin\"}";
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);

        post.setEntity(entity);

        CloseableHttpResponse response = client.execute(post);

        //获取响应状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.println("响应码:" + code);

        //获取响应内容
        HttpEntity en = response.getEntity();
        String content = EntityUtils.toString(en, "utf-8");

        System.out.println("响应内容:" + content);

        //关闭链接
        client.close();
    }

    /**
     * 测试HttpClient自定义工具类
     */
    public static void customUtilsUse(){
        String url = "http://localhost/tes/httpPost/param";
        Map<String,String> map = new HashMap<>();
        map.put("name","啊的名");
        map.put("pwd","admin");
        String result = HttpClientUtil.doPost(url, map);
        System.out.println(result);
    }

}
