
package cn.wgh.StringTest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTest {
	@Test
	public void testName() throws Exception {
		String str = "abc3";
		// str = "1";
		// str = "5553065";
		// 判断是否只包含0到9的数字
		boolean flag = str.matches("[0-9;]+");
		System.out.println("str:" + str);
		System.out.println(flag);
	}

	@Test
	public void testName2() throws Exception {
		// TODO Auto-generated method stub
		String str = "123456";
		String[] strs = str.split("");
		int a = 0; // 如:a代表1出现次数
		int b = 0; // b代表2出现次数
		// 省略
		for (int i = 0; i < strs.length; i++) {
			switch (Integer.parseInt(strs[i])) {
			case 1:
				a++;
			case 2:
				b++;
				// 省略
			}
		}
		for (int i = 0; i < strs.length; i++) {
			switch (Integer.parseInt(strs[i])) {
			case 1:
				System.out.print("1出现的次数为：" + a + "次");
			case 2:
				b++;
				// 省略
			}
		}
	}

	@Test
	public void testName222() throws Exception {

		Date date = new Date();
		System.out.println(date);
	}

	
	@Test
	public void 截取字符串() throws Exception {
		//"逗号分隔"
		String str = "sf,wgf,serg,43,fd";
		// 截取到等于第二个参数的字符串为止
		 System.out.println(StringUtils.substringBefore(str, ","));
		// 从左往右查到相等的字符开始，保留后边的，不包含等于的字符。
		 System.out.println(StringUtils.substringAfter(str, ","));
		// 这个也是截取到相等的字符，但是是从右往左.
		 System.out.println(StringUtils.substringBeforeLast(str,","));
		// 这个截取同上是从右往左。但是保留右边的字符
		 System.out.println(StringUtils.substringAfterLast(str, ","));

	}
	
	@Test
	public void 截取字符串2() throws Exception {
		String str = "省,市,县";
		// 截取到等于第二个参数的字符串为止
		System.out.println(StringUtils.substringBefore(str, ","));//
		// 从左往右查到相等的字符开始，保留后边的，不包含等于的字符。
		System.out.println(StringUtils.substringAfter(str, ","));
		// 这个也是截取到相等的字符，但是是从右往左.
		System.out.println(StringUtils.substringBeforeLast(str, ","));//
		// 这个截取同上是从右往左。但是保留右边的字符
		System.out.println(StringUtils.substringAfterLast(str, ","));
		System.out.println("------------");
		str = "省,市";
		// 截取到等于第二个参数的字符串为止
		System.out.println(StringUtils.substringBefore(str, ","));//
		// 从左往右查到相等的字符开始，保留后边的，不包含等于的字符。
		System.out.println(StringUtils.substringAfter(str, ","));
		// 这个也是截取到相等的字符，但是是从右往左.
		System.out.println(StringUtils.substringBeforeLast(str, ","));//
		// 这个截取同上是从右往左。但是保留右边的字符
		System.out.println(StringUtils.substringAfterLast(str, ","));

		System.out.println("------------");
		str = "省";
		// 截取到等于第二个参数的字符串为止
		System.out.println(StringUtils.substringBefore(str, ","));//
		// 从左往右查到相等的字符开始，保留后边的，不包含等于的字符。
		System.out.println(StringUtils.substringAfter(str, ","));
		// 这个也是截取到相等的字符，但是是从右往左.
		System.out.println(StringUtils.substringBeforeLast(str, ","));//
		// 这个截取同上是从右往左。但是保留右边的字符
		System.out.println(StringUtils.substringAfterLast(str, ","));

	}
	
	
	
	// 以逗号分隔，截取字符串
	@Test
	public void testName11() throws Exception {
		/**
		 * 方法一：
		 */
		System.out.println("方法一");
		String str = "123456,abcdef,一二三四五六,12cd五六";
//		str="123";
		String s = null;
		int j = 0;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).equals(",")) {
				s = str.substring(j, i);
				j = i + 1;
				list.add(s);
			} else if (i == str.length() - 1) {
				s = str.substring(j, i + 1);
				list.add(s);
			}
		}
		System.out.println("  list:" + list);

		/**
		 * 方法二：
		 */
		System.out.println("方法二");
		int uj = 0;
		List<String> ulist = new ArrayList<>();
		for (int ui = 0; ui < str.length(); ui++) {
			if (str.substring(ui, ui + 1).equals(",")) {
				ulist.add(str.substring(uj, ui));
				uj = ui + 1;
			} else if (ui == str.length() - 1) {
				ulist.add(str.substring(uj, ui + 1));
			}
		}
		System.out.println(" ulist:"+ulist);
		
		
		/**
		 * 方法三：
		 */
		
		System.out.println("方法三");
		String[] split = str.split(",");
		List<String> asList = Arrays.asList(split);
		System.out.println("asList:"+asList);
		List<String> list3 = new ArrayList<String>(asList);
		System.out.println(" list3:"+list3); 
		// 在使用Arrays.asList()后调用add，remove这些method时出现java.lang.UnsupportedOperationException异常。
		// 这是由于Arrays.asList() 返回java.util.Arrays$ArrayList， 而不是ArrayList。
		// Arrays$ArrayList和ArrayList都是继承AbstractList，remove，add等
		// method在AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
		// ArrayList override这些method来对list进行操作，但是Arrays$ArrayList没有override remove()，add()等，
		// 所以throw UnsupportedOperationException。 
		List<String> lists = new ArrayList<String>(Arrays.asList(str.split(",")));
		System.out.println(" lists:"+lists);
	}
	//如果方法三中字符串是null
	@Test
	public void testSplit() throws Exception {
		String urls = null;
//		 urls = "";
		if(StringUtils.isNotBlank(urls)){
			System.err.println("sssssssssss");
		}
//		String[] split = urls.split(",");
//		List<String> asList = Arrays.asList(split);
//		System.out.println("asList:"+asList);
//		List<String> list3 = new ArrayList<String>(asList);
//		System.out.println(" list3:"+list3); 
		
	}
	
	
	@Test
	public void List用逗号分隔保存为字符串() throws Exception {
		List<Object> list = new ArrayList<Object>();
		list.add("哈哈");
		list.add("呵呵");
		list.add("啊啊");
		list.add("嘿嘿");
		System.out.println(list);
		String str = StringUtils.join(list.toArray(), ",");
		System.out.println(str);
	}
	
	
	
	
	
	/**
	 * 去掉后缀名
	 * @throws Exception
	 */
	@Test
	public void test去掉后缀名() throws Exception {
		String filePathName = "5784564.56哈哈dfgfd.amr";
//		       filePathName = "在大家看着就不打就.amr";
		
		/**
		 * 方法一：
		 */
		String fileName = null;
		for (int i = filePathName.length(); i > 0; i--) {
			System.out.println(i);
			if (filePathName.substring(i - 1, i).equals(".")) {
				fileName = filePathName.substring(0, i-1);
				break;
			}
		}
		System.out.println("方法一："+fileName);
		
		/**
		 * 方法二：
		 */
		String prefix = filePathName.substring(0,filePathName.lastIndexOf("."));
		System.out.println("方法二："+prefix);
		
		/**
		 * 方法三：
		 */
		String baseName = FilenameUtils.getBaseName(filePathName);
		System.out.println("方法三："+baseName);
	}
	
	/**
	 * 获取后缀名
	 * @throws Exception
	 */
	@Test
	public void test获取后缀名() throws Exception {
		String  filePathName = "5784564.56哈哈dfgfd.amr";
//		String fileName = "在大家看着就不打就.amr";
		/**
		 * 方法一：
		 */
		String suffixName ="";
		for (int i = filePathName.length(); i > 0; i--) {
			System.out.println(i);
			if (filePathName.substring(i - 1, i).equals(".")) {
				suffixName = filePathName.substring(i,filePathName.length());
				break;
			}
		}
		System.out.println("方法一："+suffixName);
		/**
		 * 方法二：
		 */
		String suffix = filePathName.substring(filePathName.lastIndexOf(".") + 1);
		System.out.println("方法二："+suffix);
		
		/**
		 * 方法三
		 */
		String extension = FilenameUtils.getExtension(filePathName);
		System.out.println("方法三："+extension);
	}
	
	/**
	 * 判断以某字符串结束(可用于判断文件后缀名)
	 * @throws Exception
	 */
	@Test
	public void endsWithTest() throws Exception {
		String str ="jpg";
		String str1 ="abc.jpg";
		String str2 ="123.jpg";
		boolean endsWith1 = str1.endsWith(str);
		boolean endsWith2 = str2.endsWith(str);
		System.out.println(endsWith1);
		System.out.println(endsWith2);
		System.out.println("fjfjpg".endsWith(str));
	}
	
	
	
	@Test
	public void startsWithTest() throws Exception {
	
	}
	
	
	
	/**
	 * 去掉某个字符
	 * @throws Exception
	 */
	@Test
	public void testsplit() throws Exception {
		// TODO Auto-generated method stub
		String str = "\"http://echat-sit.oss-cn-hangzhou.aliyuncs.com/echat_sit/Attachment/582a6e428e824138ef3b7d48\"";
		System.out.println(str);
		str = str.replaceAll("\"", "");
		
		System.out.println(str);
		
	}
	
	
	/**
	 * 判断在某字符在字符串的哪个位置
	 * @throws Exception
	 */
	@Test
	public void indexOfTest() throws Exception {
		String url = "sndkasn";
		String str = "dka";
		char ch = 'a';
		int indexOf = url.indexOf(str);
		System.out.println(indexOf);
		int indexOfch = url.indexOf(ch);
		System.out.println(indexOfch);
		boolean contains = url.contains(str);
		System.out.println(contains);
	}
	
	
	@Test
	public void contains() throws Exception {
		String str = "ajhdjau dhau";
		String s = "";
		boolean contains = str.contains(s);
		System.out.println(contains);
	}
	
	@Test
	public void StringUtils() throws Exception {
		String str = "";
		str = null;
		System.out.println(StringUtils.isEmpty(str));
		System.out.println(StringUtils.isNotEmpty(str));
		System.out.println("--------------------------------");
		
		
		String newPassword = "2 ";
		System.out.println(StringUtils.isEmpty(newPassword) );
		System.out.println(newPassword.contains(" ") );
		if(StringUtils.isEmpty(newPassword) || newPassword.contains(" ")){
			System.out.println("newPassword:"+newPassword);
			System.out.println("************");
		}
	}
	
	@Test
	public void 用0补齐() throws Exception {
		//(1)、如果数字1是字符串,如下处理：
		String str1="101";
		DecimalFormat df=new DecimalFormat("0000000");
		String str2=df.format(Integer.parseInt(str1));
		System.out.println(str2);
		//(2)、如果数字1是整型,如下处理：
		int int1=100;
		DecimalFormat intdf=new DecimalFormat("0000000");
		String int2=intdf.format(int1);
		System.out.println(int2);
	}
	
	
	@Test
	public void 计算某字符出现次数() throws Exception {
		String str = "sf,wgf,serg,43,fd";
		int countMatches = StringUtils.countMatches(str,",");
		System.out.println(countMatches);
	}
	
	
	@Test
	public void newString() throws Exception {
//		new String(bytes, charset);
	}
	
	
	
	@Test
	public void 替换自定义占位符() throws Exception {
		String str = "1${v1}3${v2}";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("v1", "2");
		map.put("v2", "4");
		String matcherStr = MyStringUtils.matcherStr(str, map);
		
		System.out.println("str:"+str);
		System.out.println("matcherStr:"+matcherStr);
		
	}
	
	@Test
	public void 解码() throws Exception {
		String str = "%E4%B8%8A%E7%9A%84%E9%AB%98%E5%B3%B0%E6%97%B6%E6%AE%B5";
		System.out.println(str.getBytes());
		String str2 = new String(str.getBytes(),"ISO8859-1");
		String str3 = new String(str.getBytes(),"UTF-8");
		
		
		System.out.println(str2);
		System.out.println(str3);
		
		
		
//		String encodeURL=URLEncoder.dencode( str, "UTF-8" );  
//		System.out.println(encodeURL);
		String decode = URLDecoder.decode( str, "UTF-8" );
		System.out.println(decode);
		
	}
	
	@Test
	public void 判断字符串长度() throws Exception {
//		String str = "15208145789";
//		String str = "";
		String str = null;
		
		System.err.println(str.length());
	}
	
	@Test
	public void test判断小数点后位数_保留2位小数() throws Exception {
		double d = 230010.5;

		DecimalFormat df = new DecimalFormat( "0.00"); 
		if(overDecimalPoint(230010.025,2)){
			String format = df.format(d);
			System.out.println(format);
		}else{
			System.out.println(d);
		}
		
	}
	
	
	private boolean overDecimalPoint(double d, int i) {
		if (i < (StringUtils.substringAfterLast(String.valueOf(d), ".")).length()) {
			return true;
		}
		return false;
	}

	@Test
	public void testName2232() throws Exception {
		System.out.println(StringUtils.lastIndexOf("adfas", "a"));
		
		int lastIndexOfAny = StringUtils.lastIndexOf("123.123.456", ".");
		System.out.println(lastIndexOfAny);
		
		
		System.out.println(StringUtils.substringAfterLast("123.123.456", "."));
		System.out.println(StringUtils.substringAfter("123.123.456", "."));
		
		System.out.println(StringUtils.substringAfterLast("4064.3", "."));
	}
	
	@Test
	public void testNamebbbbbb() throws Exception {
		double bdmal = 230010.5;
		DecimalFormat df1 =new DecimalFormat();
		System.out.println(df1.format(bdmal));
		
		DecimalFormat df2 =new DecimalFormat("0.00");
		System.out.println(df2.format(bdmal));
	}
	
	@Test
	public void containsOnly() throws Exception {
		System.out.println(StringUtils.containsOnly("afaf", "af "));// true
		System.out.println(StringUtils.containsOnly("123456", "1"));// false
		System.out.println(StringUtils.containsOnly("123456", "13"));// false
	}
	
	
	@Test
	public void containsTest() throws Exception {
		System.out.println(StringUtils.contains("afaf", "af"));// true
		System.out.println(StringUtils.contains("123456", "1"));// true
		System.out.println(StringUtils.contains("123456", "13"));// false
		System.out.println(StringUtils.contains("123456", "32"));// false
		System.out.println(StringUtils.contains("1", "123456"));// false
	}

}
