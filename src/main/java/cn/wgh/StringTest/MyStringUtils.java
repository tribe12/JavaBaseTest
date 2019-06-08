package cn.wgh.StringTest;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringUtils {
	
	
	/**
	 * 自定义String占位符,传入参数拼接String
	 * @param str
	 * @param param
	 * @return
	 */
	public static String matcherStr(String str, Map<String, String> param) {
		StringBuffer strbf = new StringBuffer();
		String regex = "\\$\\{(.+?)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String name = matcher.group(1);// 键名
			String value = (String) param.get(name);// 键值
			if (value == null) {
				value = "";
			}
			matcher.appendReplacement(strbf, value);
		}
		matcher.appendTail(strbf);
		return strbf.toString();
	}
}
