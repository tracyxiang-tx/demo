package com.tracy.sendRequest.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpRequestSample {

	/**
	 * @Description:使用HttpURLConnection发送get请求
	 * 
	 */
	public static String get(String urlParam, Map<String, Object> params) {
		StringBuffer resultBuffer = null;

		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
		}

		HttpURLConnection con = null;
		BufferedReader br = null;

		// 发送请求
		try {
			URL url = null;

			if (sbParams != null && sbParams.length() > 0) {
				url = new URL(urlParam + "?"
						+ sbParams.substring(0, sbParams.length() - 1));
			} else {
				url = new URL(urlParam);
			}
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			con.connect();

			// 读取返回内容
			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(con
					.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "UTF-8"));
				String tmp;
				while ((tmp = br.readLine()) != null) {
					resultBuffer.append(tmp);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}

		return resultBuffer.toString();

	}

	/**
	 * @Description:使用HttpURLConnection发送post请求
	 * 
	 */
	public static String post(String urlParam, Map<String, Object> params) {
		StringBuffer resultBuffer = null;

		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
		}

		HttpURLConnection con = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;

		// 发送请求
		try {
			URL url = new URL(urlParam);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(true);
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			if (sbParams != null && sbParams.length() > 0) {
				osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
				osw.write(sbParams.substring(0, sbParams.length() - 1));
				osw.flush();
			}
			// 读取返回内容
			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(con
					.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "UTF-8"));
				String tmp;
				while ((tmp = br.readLine()) != null) {
					resultBuffer.append(tmp);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}

		return resultBuffer.toString();
	}

	/**
	 * @Description:使用URLConnection发送get请求
	 *
	 */

	public static String get2(String urlParam, Map<String, Object> params) {
		StringBuffer resultBuffer = null;

		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
		}

		HttpURLConnection con = null;
		BufferedReader br = null;

		// 发送请求
		try {
			URL url = null;

			if (sbParams != null && sbParams.length() > 0) {
				url = new URL(urlParam + "?"
						+ sbParams.substring(0, sbParams.length() - 1));
			} else {
				url = new URL(urlParam);
			}
			con = (HttpURLConnection) url.openConnection();
			// 设置请求属性
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "Keep-Alive");
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			con.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立连接
			con.connect();

			// 读取返回内容
			resultBuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(con.getInputStream(),
					"UTF-8"));
			String tmp;
			while ((tmp = br.readLine()) != null) {
				resultBuffer.append(tmp);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}

		return resultBuffer.toString();

	}

	/**
	 * @Description:使用URLConnection发送post
	 */
	public static String post2(String urlParam, Map<String, Object> params) {

		StringBuffer resultBuffer = null;
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
		}
		URLConnection con = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;

		try {

			URL realUrl = new URL(urlParam);
			// 打开和URL直接的连接
			con = realUrl.openConnection();
			// 设置请求的通用属性
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "Keep-Alive");
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			con.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送post请求必须设置如下两行
			con.setDoOutput(true);
			con.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
			if (sbParams != null && sbParams.length() > 0) {
				// 发送请求参数
				osw.write(sbParams.substring(0, sbParams.length() - 1));
				// flush输出流的缓冲
				osw.flush();
			}

			// 定义BufferedReader输入流来读取URL的响应
			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(con
					.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "UTF-8"));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}

	/**
	 * @Description:使用socket发送get请求
	 */
	public static String get3(String urlParam, Map<String, Object> params) {
		String result = "";

		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
		}
		Socket socket = null;
		OutputStreamWriter osw = null;
		InputStream is = null;

		// 发送请求
		try {
			URL url = new URL(urlParam);
			String host = url.getHost();
			int port = url.getPort();
			if (-1 == port) {
				port = 80;
			}

			String path = url.getPath();
			socket = new Socket(host, port);
			StringBuffer sb = new StringBuffer();
			sb.append("GET " + path + " HTTP/1.1\r\n");
			sb.append("Host: " + host + "\r\n");
			sb.append("Content-Type: application/x-www-form-urlencoded; charset=UTF-8 \r\n");
			sb.append("Content-Length: ")
					.append(sb.toString().getBytes().length).append("\r\n");
			// 这里一个回车换行，表示消息头写完，不然服务器会继续等待
			sb.append("\r\n");
			if (sbParams != null && sbParams.length() > 0) {
				sb.append(sbParams.substring(0, sbParams.length() - 1));
			}
			osw = new OutputStreamWriter(socket.getOutputStream());
			osw.write(sb.toString());
			osw.flush();
			is = socket.getInputStream();
			String line = null;
			// 服务器响应数据长度
			int contentLength = 0;
			// 读取http响应头部信息
			do {
				line = readLine(is, 0, "UTF-8");
				if (line.startsWith("Content-Length")) {
					// 拿到响应体内容长度
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				// 如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!line.equals("\r\n"));
			// 读取出响应体数据（就是你要的数据）
			result = readLine(is, contentLength, "UTF-8");

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return result;

	}

	/**
	 * @Description:使用socket发送post请求
	 */
	public static String post3(String urlParam, Map<String, Object> params) {

		String result = "";
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}
		Socket socket = null;
		OutputStreamWriter osw = null;
		InputStream is = null;

		try {
			URL url = new URL(urlParam);
			String host = url.getHost();
			int port = url.getPort();
			if (-1 == port) {
				port = 80;
			}
			String path = url.getPath();
			socket = new Socket(host, port);
			StringBuffer sb = new StringBuffer();
			
			sb.append("POST " + path + " HTTP/1.1 \r\n");
			sb.append("Host: " + host + " \r\n"); 
			sb.append("Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8 \r\n");
			sb.append("Connection: Keep-Alive\r\n");
			sb.append("Content-Type: application/x-www-form-urlencoded; charset=UTF-8 \r\n");
			sb.append("Content-Length: ")
					.append(sb.toString().getBytes().length).append("\r\n");
			// 这里一个回车换行，表示消息头写完，不然服务器会继续等待
			sb.append("\r\n");
			if (sbParams != null && sbParams.length() > 0) {
				sb.append(sbParams.substring(0, sbParams.length() - 1));
			}
			osw = new OutputStreamWriter(socket.getOutputStream());
			osw.write(sb.toString());
			osw.flush();
			is = socket.getInputStream();
			String line = null;
			// 服务器响应体数据长度
			int contentLength = 0;
			// 读取http响应头部信息
			do {
				line = readLine(is, 0, "UTF-8");
				if (line.startsWith("Content-Length")) {
					// 拿到响应体内容长度
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				// 如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!line.equals("\r\n"));
			// 读取出响应体数据（就是你要的数据）
			result = readLine(is, contentLength, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * @Description:读取一行数据，contentLe内容长度为0时，读取响应头信息，不为0时读正文
	 * 
	 */
	private static String readLine(InputStream is, int contentLength,
			String charset) throws IOException {
		List<Byte> lineByte = new ArrayList<Byte>();
		byte tempByte;
		int cumsum = 0;
		if (contentLength != 0) {
			do {
				tempByte = (byte) is.read();
				lineByte.add(Byte.valueOf(tempByte));
				cumsum++;
			} while (cumsum < contentLength);// cumsum等于contentLength表示已读完
		} else {
			do {
				tempByte = (byte) is.read();
				lineByte.add(Byte.valueOf(tempByte));
			} while (tempByte != 10);// 换行符的ascii码值为10
		}

		byte[] resutlBytes = new byte[lineByte.size()];
		for (int i = 0; i < lineByte.size(); i++) {
			resutlBytes[i] = (lineByte.get(i)).byteValue();
		}
		return new String(resutlBytes, charset);
	}

}
