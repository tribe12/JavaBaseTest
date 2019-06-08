package cn.wgh.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class IPTest {
	@Test
	public void getNAME_IP() throws Exception {
		try {
			// 获取计算机名
			String name = InetAddress.getLocalHost().getHostName();
			// 获取IP地址
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println("计算机名：" + name);
			System.out.println("IP地址：" + ip);
			// int i= 1/0;
		} catch (UnknownHostException e) {
			System.out.println("异常：" + e);
			e.printStackTrace();
		}

		System.err.println("111111111");
	}

	@Test
	public void testName(HttpServletRequest request) throws Exception {
		
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		System.err.println("remoteAddr:"+remoteAddr);
		System.err.println("remoteHost:"+remoteHost);
		
		
		
		

		String ip = request.getHeader("x-forwarded-for");
		System.err.println("##" + ip);
		if (StringUtils.isNotEmpty(ip)) {
			System.err.println("111```");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			System.err.println("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			System.err.println("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			System.err.println("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			System.err.println("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			System.err.println("000");
		}

		System.err.println("ip：" + ip);

	}
}