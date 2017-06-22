package com.tracy.sendRequest.HTTP;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HttpRequestSampleTest {

	// @Test
	public void getTest() {
		HttpRequestSample sample = new HttpRequestSample();
		String result = sample.get(
				"http://localhost/springDemo/admin/users/show/1", null);
		System.out.println(result);
	}

	// @Test
	public void postTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", "中文1");
		map.put("firstName", "测试1");
		map.put("lastName", "中文1");
		map.put("password", "test1");
		HttpRequestSample sample = new HttpRequestSample();
		String result = sample.post(
				"http://localhost/springDemo/admin/users/addP", map);
		System.out.println(result);
	}

	//@Test
	public void get2Test() {
		HttpRequestSample sample = new HttpRequestSample();
		String result = sample.get2(
				"http://localhost/springDemo/admin/users/show/14", null);
		System.out.println(result);
	}

	//@Test
	public void post2Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", "中文2");
		map.put("firstName", "测试2");
		map.put("lastName", "中文2");
		map.put("password", "test2");
		HttpRequestSample sample = new HttpRequestSample();
		String result = sample.post2(
				"http://localhost/springDemo/admin/users/addP", map);
		System.out.println(result);
	}
	
	//@Test
	public void get3Test() {
		HttpRequestSample sample = new HttpRequestSample();
		String result = sample.get3(
				"http://localhost/springDemo/admin/users/show/10", null);
		System.out.println(result);
	}
	
	@Test
	public void post3Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", "fds");
		map.put("firstName", "gsdfg");
		map.put("lastName", "sdg3");
		map.put("password", "test3");
		HttpRequestSample sample = new HttpRequestSample();
		String result = sample.post3(
				"http://192.168.0.29/springDemo/admin/users/addP", map);
		System.out.println(result);
	}

}
