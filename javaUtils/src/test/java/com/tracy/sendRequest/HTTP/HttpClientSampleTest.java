package com.tracy.sendRequest.HTTP;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class HttpClientSampleTest {
	//@Test
	public void getTest() {
		HttpClientSample sample = new HttpClientSample();
		sample.get("http://localhost/springDemo/admin/users/show/1");
	}
	
	@Test
	public void postTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", "中文");
		map.put("firstName", "测试");
		map.put("lastName", "中文");
		map.put("password", "test");
		HttpClientSample sample = new HttpClientSample();
		sample.post("http://localhost/springDemo/admin/users/addP",map);
	}
	
}
