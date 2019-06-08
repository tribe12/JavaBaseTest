package cn.wgh.Date;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class DateTest {
	@Test
	public void testName() throws Exception {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = dateFormate.format(date);
		System.out.println(str);
		Date date2 = dateFormate.parse(str);
		System.out.println(date2);
	}
	
	@Test
	public void testName2() throws Exception {
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		System.out.println(time);
		System.out.println(timestamp);
	}
	
	
	@Test
	public void testName3() throws Exception {
		String formate1 = "yyyy-MM-dd HH:mm:ss";
		String formate2 = "yyyy-MM-dd";
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat dateFormate = new SimpleDateFormat(formate2);
		String str = dateFormate.format(date);
		System.out.println(str);
		Date date2 = dateFormate.parse(str);
		System.out.println(date2);
		Timestamp timestamp1 = new Timestamp(date.getTime());
		Timestamp timestamp2 = new Timestamp(date2.getTime());
		
		System.out.println(timestamp1);
		System.out.println(timestamp2);
		
	}
	
	@Test
	public void 产生毫秒数() throws Exception {
		Date date = new Date();
		long time = date.getTime();
		
		System.out.println(time);
		
	}
	
	
	@Test
	public void testBefore() throws Exception {
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		System.out.println(date1.getTime());
		System.out.println(date2.getTime());
		System.out.println(date1.before(date2));
		System.out.println(date2.before(date1));
		System.out.println(date1.equals(date2));
		
		System.out.println("-------------------");
		Date date3 = new Date();
		Date date4 = new Date();
		System.out.println(date3.equals(date4));
		System.out.println("-------------------");
		System.out.println(date1.after(date2));
		System.out.println(date2.after(date1));
		System.out.println(date3.after(date4));
		System.out.println(date4.after(date3));
	}
	
	
	
	@Test
	public void testTime() throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
	}
	
	@Test
	public void testTime2() throws Exception {
		String t1 = "42737";
		String t2 = "42909";//Excle读出来的2017年6月23日
		Calendar cal = Calendar.getInstance();
//		cal.set(1900, 1, 1);
		cal.set(1899, 12, 29);
//		cal.add(Calendar.DAY_OF_MONTH, 42907);
//		cal.add(Calendar.DAY_OF_MONTH, 42909);
		cal.add(Calendar.DAY_OF_MONTH, 42737);
//		cal.add(Calendar.DAY_OF_MONTH, 1);
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(y);
		System.out.println(m);
		System.out.println(d);
		String ymd = y+"-"+m+"-"+d;
		System.out.println(ymd);
		System.out.println("==============");
		
		
		String yStr = String.valueOf(y);
		DecimalFormat df=new DecimalFormat("00");
		String mStr = df.format(m);
		String dStr = df.format(d);
		
		System.out.println(yStr);
		System.out.println(mStr);
		System.out.println(dStr);
		
		ymd = yStr+"-"+mStr+"-"+dStr;
		System.out.println(ymd);
		System.out.println("==============");
	}
	
	
	@Test
	public void 获取到往前推几月() throws Exception {
		Date now = new Date();   //当前时间
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(now);//把当前时间赋给日历
		calendar.add(calendar.MONTH, -3);  //设置为前3月
		Date dBefore = calendar.getTime();   //得到前3月的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
		String defaultStartDate = sdf.format(dBefore);    //格式化前3月的时间
		String defaultEndDate = sdf.format(now); //格式化当前时间
		System.out.println("前3个月的时间是：" + defaultStartDate);
		System.out.println("生成的时间是：" + defaultEndDate);

		//=========================
		String changeMonth = CheckDateUtil.getChangeMonth("yyyy-MM-dd", -3);
		System.out.println("changeMonth:"+changeMonth);
	}
	
	
	
	@Test
	public void 获取当月时间() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 获取上月月的第一天
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String firstDay = format.format(cal_1.getTime());
		System.out.println("-----1------firstDay:" + firstDay);
		// 获取上月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
		String lastDay = format.format(cale.getTime());
		System.out.println("-----2------lastDay:" + lastDay);

		// 获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		System.out.println("===============first:" + first);

		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		System.out.println("===============last:" + last);
	}
	
	@Test
	public void 获取当前月初始值() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar nowCalendar = Calendar.getInstance();
		SimpleDateFormat formatMini = new SimpleDateFormat("yyyy-MM-dd");
		
		nowCalendar.add(Calendar.MONTH, 0);
		nowCalendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String firstDate = format.format(nowCalendar.getTime());
		firstDate += "00:00:00";
		Date startTime = formatMini.parse(firstDate);
		
		
		System.out.println(startTime);
		
		String firstTime = format.format(startTime);
		System.out.println(firstTime);
	}
	
	
	
	
	@Test
	public void 加一天或减一天() throws Exception {
		SimpleDateFormat formatMini = new SimpleDateFormat("yyyy-MM-dd");
		Calendar nowCalendar = Calendar.getInstance();
		String dateStr = formatMini.format(nowCalendar.getTime());
//		 dateStr = "2017-10-23";
		Date date = formatMini.parse(dateStr);
		Date addDays = DateUtils.addDays(date, 1);
		
		System.out.println("当天："+date);
		System.out.println("加一天："+addDays);
//		System.out.println("减一天："+addDays);
		long time = date.getTime();
	}
	
	
	//------------------------------------------------------
	
	@Test
	public void 计算天数() throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = sdf.parse("2012-09-08 10:10:10");
		Date d2 = sdf.parse("2012-09-12 00:00:00");
		System.out.println(daysBetween(d1, d2));

		System.out.println(daysBetween("2012-09-08 10:10:10", "2012-09-15 00:00:00"));
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	//------------------------------------------------------
	
	
}
