package cn.wgh.http;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.collections4.multiset.SynchronizedMultiSet;
import org.apache.http.client.HttpClient;
import org.junit.Test;

public class GetUrlNameTest {

	/**
	 * 在浏览器中可以看到： Content-Disposition attachment; filename=utf-8''2016%E5%B9%B411%E6%9C%8815%E6%97%A510%EF%BC%9A09%EF%BC%
	 * 9A04.amr
	 * 
	 * @throws Exception
	 */

	@Test
	public void testName() throws Exception {
		URL testUrl = new URL(
				"http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48");
		HttpURLConnection conn = (HttpURLConnection) testUrl.openConnection();
		String Content_Disposition = conn.getHeaderField("Content-Disposition");
		Content_Disposition= new String(Content_Disposition.replaceAll(" ", "").getBytes("UTF-8"), "ISO8859-1");
		System.out.println("Content-Disposition:   " + Content_Disposition);
		String ContentDisposition = URLDecoder.decode(Content_Disposition, "UTF-8");
		System.out.println("ContentDisposition:" + ContentDisposition);
		String fileName = ContentDisposition.substring(ContentDisposition.lastIndexOf("'") + 1);
		System.out.println("fileName:" + fileName);
	}

	@Test
	public void test1() throws Exception {
		URL testUrl = new URL(
				"http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48");
		HttpURLConnection conn = (HttpURLConnection) testUrl.openConnection();
		if (conn.getResponseCode() == 200) {
			String file = conn.getURL().getFile();
			System.out.println(file);// /echat_sit/Attachment/582a6e428e824138ef3b7d48
			System.out.println(file.substring(file.lastIndexOf('/') + 1)); // 582a6e428e824138ef3b7d48
		}
	}

	@Test
	public void test() throws Exception {
		URL testUrl = new URL(
				"http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48");
		HttpURLConnection conn = (HttpURLConnection) testUrl.openConnection();
		conn.setFollowRedirects(true);
		int ret = conn.getResponseCode();
		String fn = URLDecoder.decode(conn.getURL().toString(), "UTF-8");
		System.out.println("------------" + ret + "-------" + fn);
		System.out.println("------------" + ret + "-------" + fn.substring(fn.lastIndexOf("/") + 1));
		InputStream in = conn.getInputStream();
		InputStreamReader dis = new InputStreamReader(in);
		java.io.BufferedReader bf = new java.io.BufferedReader(dis);
		String r = bf.readLine();
		int k = 0;
		while (r != null) {
			System.out.println(r);
			r = bf.readLine();
			k++;
			if (k > 5)
				break;
		}
		conn.disconnect();
	}

}
