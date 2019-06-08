package cn.wgh.password;

import static org.junit.Assert.*;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import sun.security.rsa.RSASignature.MD5withRSA;

public class PasswordTest {
	/**
	 * 一般MD5加密
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMD5() throws Exception {
		String str = "111111";
		String str_MD5 = MD5.encode(str);
		System.out.println(str_MD5);// 96E79218965EB72C92A549DD5A330112
	}

	/**
	 * MD5 + 散列算法
	 * 
	 * @throws Exception
	 */
	@Test
	public void Md5HashTest() throws Exception {
		// 原字符串
		String source = "111111";
		// 加“盐”
		String salt = "qwerty";
		// 散列次数
		int hashIterations = 1;

		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		String md5HashStr = md5Hash.toString();

		System.out.println(md5Hash);// f3694f162729b7d0254c6e40260bf15c
		System.out.println(md5HashStr);// f3694f162729b7d0254c6e40260bf15c

	}

	@Test
	public void SimpleHashTest() throws Exception {
		// 加密算法名称
		String algorithmName = "MD5";
		// 原字符串
		String source = "111111";
		// 加“盐”
		String salt = "qwerty";
		// 散列次数
		int hashIterations = 1;

		SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(simpleHash);
		String simpleHashStr = simpleHash.toString();
		System.out.println(simpleHashStr);
	}
}
