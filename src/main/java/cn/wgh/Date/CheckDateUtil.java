package cn.wgh.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class CheckDateUtil {
	public static boolean beforeToday(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtils.isNotEmpty(dateStr)) {
			try {
				long time = format.parse(dateStr).getTime();
				long nowTime = format.parse(format.format(new Date())).getTime();
				if (nowTime > time) {
					return true;
				}
				return false;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static String getChangeMonth(String pattern, int amount) {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(calendar.MONTH, amount);
		Date chgMonth = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(chgMonth);
	}

}
