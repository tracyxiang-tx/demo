package com.tracy.sendRequest.HTTP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientSample {

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * 
	 */
	public void get(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet(url);
			// 执行get请求
			CloseableHttpResponse response = httpClient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println("Response content length: "
							+ entity.getContentLength());
					// 打印响应内容
					System.out.println("Response content: "
							+ EntityUtils.toString(entity));
				}
				System.out.println("------------------------------------");
			} finally {
				response.close();
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param 请求参数
	 *            name1=value1,name2=value2
	 */
	public void post(String url, Map<String, Object> params) {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httpPost = new HttpPost(url);
		// 创建参数队列
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet()) {

			// System.out.println("Key = " + entry.getKey() + ", Value = " +
			// entry.getValue());
			formParams.add(new BasicNameValuePair(entry.getKey(),
					(String) entry.getValue()));
		}
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formParams,"UTF-8");
			httpPost.setEntity(uefEntity);
			System.out.println("executing request " + httpPost.getURI());

			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					System.out
							.println("--------------------------------------");
					System.out.println("Response content: "
							+ EntityUtils.toString(entity, "UTF-8"));
					System.out
							.println("--------------------------------------");
				}
			} finally {
				response.close();
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
