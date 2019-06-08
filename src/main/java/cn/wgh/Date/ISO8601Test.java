package cn.wgh.Date;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.log4j.helpers.ISO8601DateFormat;
import org.junit.Test;

public class ISO8601Test {
	
	//activiti 时间：2016-11-03T14:27:03.036+08:00
	
	/**
	 * 转换ISO8601格式时间，目前转不了时分秒
	 * @throws Exception
	 */
	@Test
	public void ISO8601test() throws Exception {
		String s = "1996-01-01T00:00:00+08:00";  
//		s="2013-06-12T14:31:08.612+0000";
        s="2016-11-07T18:14:51.000+08:00";
		DateFormat dateFormat = ISO8601DateFormat.getDateInstance();
		Date ISOdate = dateFormat.parse(s);
		SimpleDateFormat sdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");  
		String str = sdateFormat.format(ISOdate);
		System.out.println("ISOdate: "+ISOdate);
		System.out.println(str);
	}
	
	
	/**
	 * 转换ISO8601格式时间，手动过滤字符串来转换
	 * @throws Exception
	 */
	@Test
	public void ISO8601test2() throws Exception {
		String s="2016-11-08T14:34:04.000Z";
		s="2016-11-08 14:34:04.000";
		s="2016-11-15T10:09:17.000+08:00";
		System.out.println("s: "+s);
		s=s.replace("T", " ");
		for (int ui = 0; ui < s.length(); ui++) {
			if (s.substring(ui, ui + 1).equals(".")) {
				s =s.substring(0, ui);
			} 
		}
		System.out.println("s: "+s);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse(s);
		String str = df.format(date);
		System.out.println("date: "+date);
		System.out.println("str: "+str);
	}
	
	@Test
	public void ISO8601test3() throws Exception {
		Date now = new Date();
		String nowStr = DateFormatUtils.ISO_DATE_FORMAT.format(now);
		System.out.println("               ISO_DATE_FORMAT: "+nowStr);// 2016-11-16
		
		nowStr = DateFormatUtils.ISO_DATETIME_FORMAT.format(now);
		System.out.println("           ISO_DATETIME_FORMAT: "+nowStr);// 2016-11-16T14:50:23
		
		nowStr = DateFormatUtils.ISO_DATE_TIME_ZONE_FORMAT.format(now);
		System.out.println("     ISO_DATE_TIME_ZONE_FORMAT: "+nowStr);// 2016-11-16+08:00

		nowStr = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now);
		System.out.println(" ISO_DATETIME_TIME_ZONE_FORMAT: "+nowStr);// 2016-11-16T14:50:23+08:00
		
		nowStr = DateFormatUtils.ISO_TIME_FORMAT.format(now);
		System.out.println("               ISO_TIME_FORMAT: "+nowStr);// T14:50:23
		
		nowStr = DateFormatUtils.ISO_TIME_NO_T_FORMAT.format(now);
		System.out.println("          ISO_TIME_NO_T_FORMAT: "+nowStr);// 14:50:23
		
		nowStr = DateFormatUtils.ISO_TIME_NO_T_TIME_ZONE_FORMAT.format(now);
		System.out.println("ISO_TIME_NO_T_TIME_ZONE_FORMAT: "+nowStr);// 14:50:23+08:00
		
		nowStr = DateFormatUtils.ISO_TIME_TIME_ZONE_FORMAT.format(now);
		System.out.println("     ISO_TIME_TIME_ZONE_FORMAT: "+nowStr);// T14:50:23+08:00
		
	}
	
	@Test
	public void ISO8601test4() throws Exception {
		String s="2016-11-16T14:34:35+08:00";
		
		FastDateFormat isodf = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT;
		Date date = isodf.parse(s);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String str = sdf.format(date);
		
		System.out.println("s:   "+s);   //		s:   2016-11-16T14:34:35+08:00
		System.out.println("date:"+date);//		date:Wed Nov 16 14:34:35 CST 2016
		System.out.println("str: "+str); //		str: 2016-11-16 14:34:35
	}
	
	/*  *****************************************************************************************************  */
	
	/**
	 * 自动加一天，方法一：
	 * @throws Exception
	 */
	@Test
	public void testNameAdd() throws Exception {
		String str = "2016-02-29";
		System.out.println("   str:"+str);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);
		long time = date.getTime();
		time+=86400000;
		date.setTime(time);
		String newStr = df.format(date);
		System.out.println("newStr:"+newStr);
	}

	/**
	 * 自动加一天，方法二：
	 * @throws Exception
	 */
	@Test
	public void testNameAdd_() throws Exception {
		String str = "2016-11-30";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 1);
		String newStr = df.format(calendar.getTime());
		System.out.println("   str:"+str);
		System.out.println("newStr:"+newStr);
	}
	
	
	@Test
	public void testNameAdd_3() throws Exception {
		String str = "2016-11-30";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);
		Date addDays = DateUtils.addDays(date, 1);
		System.out.println(addDays);
		String newStr = df.format(addDays);
		System.out.println("newStr:"+newStr);
		
	}
	
	/*  *****************************************************************************************************  */
}
