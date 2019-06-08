package cn.wgh.StringTest;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void testName() throws Exception {
//		org.apache.commons.lang.StringUtils中方法的操作对象是java.lang.String类型的对象，是JDK提供的String类型操作方法的补充，并且是null安全的(即如果输入参数String为null则不会抛出NullPointerException，而是做了相应处理，例如，如果输入为null则返回也是null等，具体可以查看源代码)。
//		除了构造器，StringUtils中一共有130多个方法，并且都是static的，
//		所以我们可以这样调用StringUtils.xxx()。
//		下面分别对一些常用方法做简要介绍：
		
//		1. public static boolean isEmpty(String str)
//		判断某字符串是否为空，为空的标准是str == null 或 str.length();== 0
//		下面是示例：
		StringUtils.isEmpty(null);          // true
		StringUtils.isEmpty("");       // true
		StringUtils.isEmpty(" ");      // false
		StringUtils.isEmpty("        ");     // false
		StringUtils.isEmpty("bob");       // false
		StringUtils.isEmpty(" bob "); // false
		
//		2.public static boolean isNotEmpty(String str); 
//		判断某字符串是否非空，等于!isEmpty(String str)
//		下面是示例：
		StringUtils.isNotEmpty(null);       // false
		StringUtils.isNotEmpty("");          // false
		StringUtils.isNotEmpty(" ");     // true
		StringUtils.isNotEmpty("         ");   // true
		StringUtils.isNotEmpty("bob");  // true
		StringUtils.isNotEmpty(" bob ");  // true
		
//		3. public static boolean isBlank(String str)
//		判断某字符串是否为空或长度为0或由空白符(whitespace)构成
//		下面是示例：
		StringUtils.isBlank(null);        // true
		StringUtils.isBlank("");           // true
		StringUtils.isBlank(" ");                // true
		StringUtils.isBlank("        ");         // true
		StringUtils.isBlank("\t \n \f \r");   // true
		StringUtils.isBlank("\b");              // false
		StringUtils.isBlank("bob");           // false
		StringUtils.isBlank(" bob ");       // false
		
//		4. public static boolean isNotBlank(String str)
//		判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成，
//		等于!isBlank(String str)
//		下面是示例：
		StringUtils.isNotBlank(null);       // false
		StringUtils.isNotBlank("");              // false
		StringUtils.isNotBlank(" ");         // false
		StringUtils.isNotBlank("         ");       // false
		StringUtils.isNotBlank("\t \n \f \r");    // false
		StringUtils.isNotBlank("\b");             // true
		StringUtils.isNotBlank("bob");          // true
		StringUtils.isNotBlank(" bob ");  // true
		
//		5. public static String trim(String str)
//		去掉字符串两端的控制符(control characters, char <// 32)
//		如果输入为null则返回null
//		下面是示例：
		StringUtils.trim(null);               // null
		StringUtils.trim("");                 // ""
		StringUtils.trim(" ");                         // ""
		StringUtils.trim("     \b \t \n \f \r    "); // ""
		StringUtils.trim("     \n\tss   \b");       // "ss"
		StringUtils.trim(" d   d dd     ");    // "d   d dd"
		StringUtils.trim("dd     ");           // "dd"
		StringUtils.trim("     dd       ");          // "dd"
//		
//		6.public static String trimToNull(String str)
//		去掉字符串两端的控制符(control characters, char <// 32)
//		如果变为null或""，则返回null
//		下面是示例：
		StringUtils.trimToNull(null);               // null
		StringUtils.trimToNull("");                          // null
		StringUtils.trimToNull(" ");                         // null
		StringUtils.trimToNull("     \b \t \n \f \r    ");// null
		StringUtils.trimToNull("     \n\tss   \b");    // "ss"
		StringUtils.trimToNull(" d   d dd     ");       // "d   d dd"
		StringUtils.trimToNull("dd     ");          // "dd"
		StringUtils.trimToNull("     dd       ");         // "dd"
//		
//		7.public static String trimToEmpty(String str)
//		去掉字符串两端的控制符(control characters, char <// 32)
//		如果变为null或""，则返回""
//		下面是示例：
		StringUtils.trimToEmpty(null);                   // ""
		StringUtils.trimToEmpty("");                  // ""
		StringUtils.trimToEmpty(" ");                         // ""
		StringUtils.trimToEmpty("     \b \t \n \f \r    ");// ""
		StringUtils.trimToEmpty("     \n\tss   \b");    // "ss"
		StringUtils.trimToEmpty(" d   d dd     ");     // "d   d dd"
		StringUtils.trimToEmpty("dd     ");            // "dd"
		StringUtils.trimToEmpty("     dd       ");         // "dd"
	
//		8.public static String strip(String str)
//		去掉字符串两端的空白符(whitespace)，
//		如果输入为null则返回null
//		下面是示例(注意和trim()的区别)：
		StringUtils.strip(null);                   // null
		StringUtils.strip("");                  // ""
		StringUtils.strip(" ");                 // ""
		StringUtils.strip("     \b \t \n \f \r    ");       // "\b"
		StringUtils.strip("     \n\tss   \b");            // "ss   \b"
		StringUtils.strip(" d   d dd     ");     // "d   d dd"
		StringUtils.strip("dd     ");            // "dd"
		StringUtils.strip("     dd       ");         // "dd"
		
//		9.public static String stripToNull(String str)
//		去掉字符串两端的空白符(whitespace)，
//		如果变为null或""，则返回null
//		下面是示例(注意和trimToNull()的区别)：
		StringUtils.stripToNull(null);                  // null
		StringUtils.stripToNull("");                   // null
		StringUtils.stripToNull(" ");                // null
		StringUtils.stripToNull("     \b \t \n \f \r    ");// "\b"
		StringUtils.stripToNull("     \n\tss   \b");      // "ss   \b"
		StringUtils.stripToNull(" d   d dd     ");      // "d   d dd"
		StringUtils.stripToNull("dd     ");                // "dd"
		StringUtils.stripToNull("     dd       ");         // "dd"
		
//		10.public static String stripToEmpty(String str)
//		去掉字符串两端的空白符(whitespace)，
//		如果变为null或""，则返回""
//		下面是示例(注意和trimToEmpty()的区别)：
		StringUtils.stripToNull(null);                 // ""
		StringUtils.stripToNull("");                  // ""
		StringUtils.stripToNull(" ");                 // ""
		StringUtils.stripToNull("     \b \t \n \f \r    ");  // "\b"
		StringUtils.stripToNull("     \n\tss   \b");    // "ss   \b"
		StringUtils.stripToNull(" d   d dd     ");    // "d   d dd"
		StringUtils.stripToNull("dd     ");                // "dd"
		StringUtils.stripToNull("     dd       ");          // "dd"
		 
//		11.public static String strip(String str, String stripChars)
//		去掉str两端的在stripChars中的字符。
//		如果str为null或等于""，则返回它本身；
//		如果stripChars为null或""，则返回strip(String str)。
		
//		12.public static String stripStart(String str, String stripChars)
//		和11相似，去掉str前端的在stripChars中的字符。
		
//		13.public static String stripEnd(String str, String stripChars)
//		和11相似，去掉str末端的在stripChars中的字符。
		
//		14.public static String[] stripAll(String[] strs)
//		对字符串数组中的每个字符串进行strip(String str)，然后返回。
//		如果strs为null或strs长度为0，则返回strs本身
		
//		15.public static String[] stripAll(String[] strs, String stripChars)
//		对字符串数组中的每个字符串进行strip(String str, String stripChars)，然后返回。
//		如果strs为null或strs长度为0，则返回strs本身
		
//		16.public static boolean equals(String str1, String str2)
//		比较两个字符串是否相等，如果两个均为空则也认为相等。
		
//		17.public static boolean equalsIgnoreCase(String str1, String str2)
//		比较两个字符串是否相等，不区分大小写，如果两个均为空则也认为相等。
		
//		18.public static int indexOf(String str, char searchChar)
//		返回字符searchChar在字符串str中第一次出现的位置。
//		如果searchChar没有在str中出现则返回-1，
//		如果str为null或""，则也返回-1
		
//		19.public static int indexOf(String str, char searchChar, int startPos)
//		返回字符searchChar从startPos开始在字符串str中第一次出现的位置。
//		如果从startPos开始searchChar没有在str中出现则返回-1，
//		如果str为null或""，则也返回-1
		
//		20.public static int indexOf(String str, String searchStr)
//		返回字符串searchStr在字符串str中第一次出现的位置。
//		如果str为null或searchStr为null则返回-1，
//		如果searchStr为"",且str为不为null，则返回0，
//		如果searchStr不在str中，则返回-1
		
//		21.public static int ordinalIndexOf(String str, String searchStr, int ordinal)
//		返回字符串searchStr在字符串str中第ordinal次出现的位置。
//		如果str=null或searchStr=null或ordinal<=0则返回-1
//		举例(*代表任意字符串)：
//		StringUtils.ordinalIndexOf(null, *, *);         // -1
//		StringUtils.ordinalIndexOf(*, null, *);         // -1
//		StringUtils.ordinalIndexOf("", "", *);          // 0
		StringUtils.ordinalIndexOf("aabaabaa", "a", 1);// 0
		StringUtils.ordinalIndexOf("aabaabaa", "a", 2);// 1
		StringUtils.ordinalIndexOf("aabaabaa", "b", 1);// 2
		StringUtils.ordinalIndexOf("aabaabaa", "b", 2);// 5
		StringUtils.ordinalIndexOf("aabaabaa", "ab", 1);// 1
		StringUtils.ordinalIndexOf("aabaabaa", "ab", 2);// 4
		StringUtils.ordinalIndexOf("aabaabaa", "bc", 1);// -1
		StringUtils.ordinalIndexOf("aabaabaa", "", 1);  // 0
		StringUtils.ordinalIndexOf("aabaabaa", "", 2);  // 0
	
//		22. public static int indexOf(String str, String searchStr, int startPos)
//		返回字符串searchStr从startPos开始在字符串str中第一次出现的位置。
//		举例(*代表任意字符串)：
//		StringUtils.indexOf(null, *, *);         // -1
//		StringUtils.indexOf(*, null, *);         // -1
		StringUtils.indexOf("", "", 0);          // 0
		StringUtils.indexOf("aabaabaa", "a", 0);// 0
		StringUtils.indexOf("aabaabaa", "b", 0);// 2
		StringUtils.indexOf("aabaabaa", "ab", 0);// 1
		StringUtils.indexOf("aabaabaa", "b", 3);// 5
		StringUtils.indexOf("aabaabaa", "b", 9);// -1
		StringUtils.indexOf("aabaabaa", "b", -1);// 2
		StringUtils.indexOf("aabaabaa", "", 2);  // 2
		StringUtils.indexOf("abc", "", 9);       // 3
		
//		23.public static int lastIndexOf(String str, char searchChar)
//		基本原理同18。
		
//		24.public static int lastIndexOf(String str, char searchChar, int startPos)
//		基本原理同19。
		
//		25.public static int lastIndexOf(String str, String searchStr)
//		基本原理同20。
		
//		26.public static int lastIndexOf(String str, String searchStr, int startPos)
//		基本原理同22。
		 
//		27.public static boolean contains(String str, char searchChar)
//		判断字符串str中是否包含字符searchChar。
//		如果str为null或""，返回false；
//		如果searchChar不在str中，返回false。
		
//		28.public static boolean contains(String str, String searchStr)
//		判断字符串str是否包含字符串searchStr。
//		如果str为null或searchStr为null，返回false；
//		如果str为""，并且searchStr为""，返回true
//		举例：
//		StringUtils.contains("", "");      // true
//		StringUtils.contains("dfg", "");   // true
//		StringUtils.contains("dfg", "d");  // true
//		StringUtils.contains("dfg", "gz");// false
		
//		29.public static boolean containsIgnoreCase(String str, String searchStr)
//		判断字符串str是否包含字符串searchStr，不区分大小写。
//		和28类似。
		
//		30.public static int indexOfAny(String str, char[] searchChars)
//		找出字符数组searchChars中的字符第一次出现在字符串str中的位置。
//		如果字符数组中的字符都不在字符串中，则返回-1
//		如果字符串为null或""，则返回-1
//		举例(*表示任意)：
//		StringUtils.indexOfAny(null, *);                // -1
//		StringUtils.indexOfAny("", *);                  // -1
//		StringUtils.indexOfAny(*, []);                  // -1
//		StringUtils.indexOfAny("asdf", ['a','f',' ']);  // 0
//		StringUtils.indexOfAny("bs df", ['a','f',' ']);// 2
//		StringUtils.indexOfAny("bsdf", ['a','f',' ']);  // 3
//		StringUtils.indexOfAny("bbeegg", ['a','f',' ']);// -1
		
//		31.public static int indexOfAny(String str, String searchChars)
//		找出字符串searchChars中的字符第一次出现在字符串str中的位置。
//		如果字符串searchChars中的字符都不在字符串str中，则返回-1
//		如果searchChars或str为null或为""，则返回-1
//		举例(*表示任意)：
//		StringUtils.indexOfAny(null, *);        // -1
//		StringUtils.indexOfAny("", *);          // -1
//		StringUtils.indexOfAny(*, null);        // -1
//		StringUtils.indexOfAny(*, "");          // -1
		StringUtils.indexOfAny("asdf", "af ");  // 0
		StringUtils.indexOfAny("bs df", "af ");// 2
		StringUtils.indexOfAny("bsdf", "af ");  // 3
		StringUtils.indexOfAny("bbeegg", "af ");// -1
		
//		32.public static int indexOfAnyBut(String str, char[] searchChars)
//		找出字符串str中不在字符数组searchChars中的第一个字符的位置。
//		如果字符串中的所有字符都在字符数组中，则返回-1
//		如果字符串为null或""，则返回-1
//		举例(*表示任意)：
//		StringUtils.indexOfAnyBut(null, *);                // -1
//		StringUtils.indexOfAnyBut("", *);                  // -1
//		StringUtils.indexOfAnyBut(*, []);                  // -1
//		StringUtils.indexOfAnyBut("asdf", ['a','f',' ']);  // 1
//		StringUtils.indexOfAnyBut("bs df", ['a','f',' ']);// 0
//		StringUtils.indexOfAnyBut(" aaf", ['a','f',' ']);  // -1
//		StringUtils.indexOfAnyBut("bbeegg", ['a','f',' ']);// 0
		
//		33.public static int indexOfAnyBut(String str, String searchChars)
//		找出字符串str中不在字符串searchChars中的第一个字符的位置。
//		如果字符串str中的所有字符都在字符串searchChars中，则返回-1
//		如果字符串str或searchChars为null或""，则返回-1
//		举例(*表示任意)：
//		StringUtils.indexOfAnyBut(null, *);        // -1
//		StringUtils.indexOfAnyBut("", *);          // -1
//		StringUtils.indexOfAnyBut(*, null);        // -1
//		StringUtils.indexOfAnyBut(*, "");          // -1
		StringUtils.indexOfAnyBut("asdf", "af ");  // 1
		StringUtils.indexOfAnyBut("bs df", "af ");// 0
		StringUtils.indexOfAnyBut(" aaf", "af ");  // -1
		StringUtils.indexOfAnyBut("bbeegg", "af ");// 0
		
//		34.public static boolean containsOnly(String str, char[] valid)
//		判断是否字符串str仅包含字符数组valid中的字符，即字符串中的字符是否都在字符数组中。
//		如果str为null，则返回false；如果str为""，则返回true
//		举例(*表示任意)：
//		StringUtils.containsOnly(null, *);             // false
//		StringUtils.containsOnly("", *);               // true
//		StringUtils.containsOnly("afaf", ['a','f',' '])// true
//		StringUtils.containsOnly("af a", ['a','f',' '])// true
//		StringUtils.containsOnly("a", ['a','f',' ']);  // true
//		StringUtils.containsOnly("afg", ['a','f',' ']);// false
//		StringUtils.containsOnly("bbeegg", []);        // false
		
//		35.public static boolean containsOnly(String str, String validChars)
//		判断是否字符串str仅包含字符串validChars中的字符，
//		即字符串str中的字符是否都在字符串validChars中。
//		和34类似，举例(*表示任意)：
//		StringUtils.containsOnly(null, *);      // false
//		StringUtils.containsOnly(*, null);      // false
		StringUtils.containsOnly("", "");       // true
		StringUtils.containsOnly("", "a");      // true
		StringUtils.containsOnly("afaf", "af ");// true
		StringUtils.containsOnly("af a", "af ");// true
		StringUtils.containsOnly("afg", "af ");// false
		StringUtils.containsOnly("afg", "");    // false
//	
//		36.public static boolean containsNone(String str, char[] invalidChars)
//		判断是否字符串str不包含字符数组invalidChars中的字符，如果含有则返回false。
//		举例(*表示任意)：
//		StringUtils.containsNone(null, *);              // true
//		StringUtils.containsNone(*, []);                // true
//		StringUtils.containsNone("", *);                // true
//		StringUtils.containsNone("ab", []);             // true
//		StringUtils.containsNone("b", ['a','f',' ']);   // true
//		StringUtils.containsNone("bcd", ['a','f',' ']);// true
//		StringUtils.containsNone("abc", ['a','f',' ']);// false
//		StringUtils.containsNone(" ", ['a','f',' ']);   // false
		
//		37.public static boolean containsNone(String str, String invalidChars);
//		判断是否字符串str不包含字符串invalidChars中的字符，如果含有则返回false。
//		举例(*表示任意)：
//		StringUtils.containsNone(null, *);      // true
//		StringUtils.containsNone(*, null);      // true
//		StringUtils.containsNone("", *);        // true
		StringUtils.containsNone("ab", "");     // true
		StringUtils.containsNone("b", "af ");   // true
		StringUtils.containsNone("bcd", "af ");// true
		StringUtils.containsNone("abc", "af ");// false
		StringUtils.containsNone(" ", "af ");   // false
		 
//		38.public static int indexOfAny(String str, String[] searchStrs)
//		找出字符串数组searchStrs中的字符串第一次出现在字符串str中的位置。
//		如果数组中没有字符串在str中，则返回-1
//		如果数组为null或长度为0，则返回-1
//		举例(*表示任意)：
//		StringUtils.indexOfAny(null, *);                    // -1
//		StringUtils.indexOfAny(*, null);                    // -1
//		StringUtils.indexOfAny(*, []);                      // -1
//		StringUtils.indexOfAny("", [""]);                   // 0
//		StringUtils.indexOfAny("bbeegg", ["as","df","yy"]);// -1
//		StringUtils.indexOfAny("asdfgh", ["as","df","yy"]);// 0
//		StringUtils.indexOfAny("dfasgh", ["as","df","yy"]);// 0
//		StringUtils.indexOfAny("ghasdf", ["as","df","yy"]);// 2
		
//		39.public static int lastIndexOfAny(String str, String[] searchStrs)
//		找出字符串数组searchStrs中的字符串最后一次出现在字符串str中的位置。
//		如果数组中没有字符串在str中，则返回-1
//		如果数组为null或长度为0，则返回-1
//		举例(*表示任意)：
//		StringUtils.lastIndexOfAny(null, *);                    // -1
//		StringUtils.lastIndexOfAny(*, null);                    // -1
//		StringUtils.lastIndexOfAny(*, []);                      // -1
//		StringUtils.lastIndexOfAny("", [""]);                   // 0
//		StringUtils.lastIndexOfAny("bbeegg", ["as","df","yy"]);// -1
//		StringUtils.lastIndexOfAny("asdfgh", ["as","df","yy"]);// 2
//		StringUtils.lastIndexOfAny("dfghjk", ["as","df","yy"]);// 0
//		StringUtils.lastIndexOfAny("ghasdf", ["as","df","yy"]);// 4
//		StringUtils.lastIndexOfAny("ghasdf", ["as","df",""]);   // 6
		
//		40.public static String substring(String str, int start)
//		得到字符串str的子串。
//		如果start小于0，位置是从后往前数的第|start|个
//		如果str为null或""，则返回它本身
//		举例(*表示任意)：
//		StringUtils.substring(null, *);    // null
//		StringUtils.substring("", *);      // ""
		StringUtils.substring("asdf", 0);// "asdf"
		StringUtils.substring("asdf", 1);// "sdf"
		StringUtils.substring("asdf", 3);// "f"
//		StringUtils.substring("asdf",  );// ""
		StringUtils.substring("asdf", -1);// "f"
		StringUtils.substring("asdf", -3);// "sdf"
		StringUtils.substring("asdf", -8);// "asdf"
		
//		41.public static String substring(String str, int start, int end)
//		得到字符串str的子串。
//		如果start小于0，位置是从后往前数的第|start|个，
//		如果end小于0，位置是从后往前数的第|end|个，
//		如果str为null或""，则返回它本身
//		举例(*表示任意)：
//		StringUtils.substring(null, *, *);    // null
//		StringUtils.substring("", * , *);    // "";
		StringUtils.substring("asdf", 0, 2);  // "as"
		StringUtils.substring("asdf", 0, -1);// "asd"
		StringUtils.substring("asdf", 2, -1);// "d"
		StringUtils.substring("asdf", 2, -2);// ""
		StringUtils.substring("asdf", 3, 2);  // ""
//		StringUtils.substring("asdf", 1,   // "sdf"
		StringUtils.substring("asdf", -1, -3);// ""
		StringUtils.substring("asdf", -3, -1);// "sd"
		StringUtils.substring("asdf", -8, 5);// "asdf"
		
//		42.public static String left(String str, int len)
//		得到字符串str从左边数len长度的子串。
//		如果str为null或为""，则返回它本身
//		如果len小于0，则返回""
//		举例(*表示任意)：
//		StringUtils.left(null, *);   // null
//		StringUtils.left(*, -ve);    // ""
//		StringUtils.left("", *);     // ""
		StringUtils.left("asdf", 0);// ""
		StringUtils.left("asdf", 2);// "as"
//		StringUtils.left("asdf", // "asdf"
		
//		43.public static String right(String str, int len)
//		得到字符串str从右边数len长度的子串。
//		如果str为null或为""，则返回它本身
//		如果len小于0，则返回""
//		举例(*表示任意)：
//		StringUtils.right(null, *);   // null
//		StringUtils.right(*, -ve);    // ""
//		StringUtils.right("", *);     // ""
		StringUtils.right("asdf", 0);// ""
		StringUtils.right("asdf", 2);// "df"
//		StringUtils.right("asdf", // "asdf"
				
//		44.public static String mid(String str, int pos, int len)
//		得到字符串str从pos开始len长度的子串。
//		如果str为null或为""，则返回它本身
//		如果len小于0或pos大于srt的长度，则返回""
//		如果pos小于0，则pos设为0
//		举例(*表示任意)：
//		StringUtils.mid(null, *, *);    // null
//		StringUtils.mid("", *, *);      // ""
//		StringUtils.mid(*, *, -ve);     // ""
		StringUtils.mid("asdf", 0, 4);// "asdf"
		StringUtils.mid("asdf", 2, 2);   // "df"
		StringUtils.mid("asdf", 2, 5);   // "df"
		StringUtils.mid("asdf", -2, 1);// "a"
		StringUtils.mid("asdf", 0, -1);   // ""
		
//		45.public static String substringBefore(String str, String separator)
//		得到字符串str的在字符串separator出现前的字串，且separator不包括在内。
//		如果str为null或为""，则返回它本身
//		如果separator为null，则返回str本身
//		举例(*表示任意)：
//		StringUtils.substringBefore(null, *);           // null
//		StringUtils.substringBefore("", *);             // ""
		StringUtils.substringBefore("asdfg", null);    // "asdfg"
		StringUtils.substringBefore("asdfg", "a");     // ""
		StringUtils.substringBefore("asdfg", "sd");    // "a"
		StringUtils.substringBefore("asdfsag", "sa");  // "asdf"
		StringUtils.substringBefore("asdfg", "h");     // "asdfg"
		StringUtils.substringBefore("asdfg", "");      // ""
		StringUtils.substringBefore("asdfg", "dfgh");  // "asdfg"
		StringUtils.substringBefore("asdfg", "dfg");   // "as"
		StringUtils.substringBefore("abbbabbba", "bb");// "a"
		
//		46.public static String substringAfter(String str, String separator)
//		得到字符串str的在字符串separator出现后的字串，且separator不包括在内。
//		如果str为null或为""，则返回它本身
//		如果separator为null，则返回""
//		举例(*表示任意)：
//		StringUtils.substringAfter(null, *);          // null
//		StringUtils.substringAfter("", *);            // ""
//		StringUtils.substringAfter(*, null);          // ""
		StringUtils.substringAfter("asdfg", "a");    // "sdfg"
		StringUtils.substringAfter("asdfg", "sd");       //    "fg"
		StringUtils.substringAfter("asdfsag", "sa");   //    "g"
		StringUtils.substringAfter("asdfg", "h");           //    ""
		StringUtils.substringAfter("asdfg", "");           //    "asdfg"
		StringUtils.substringAfter("asdfg", "dfgh");   //    ""
		StringUtils.substringAfter("asdfg", "dfg");       //    ""
		StringUtils.substringAfter("abbbabbba", "bb");//    "babbba"
		
//		47.public static String substringBeforeLast(String str, String separator)
//		和45类似，得到字符串str的在字符串separator最后一次出现前的字串。
//		这里不再举例。
		
//		48.public static String substringAfterLast(String str, String separator)
//		和46类似，得到字符串str的在字符串separator最后一次出现后的字串。
//		这里不再举例。
		
//		49.public static String substringBetween(String str, String tag)
//		得到str中的在两个字符串tag中间的字符串，即str中的tag所夹的串。
//		如果str为null或tag为null，返回null
//		举例(*表示任意)：
//		StringUtils.substringBetween(null, *);              // null
//		StringUtils.substringBetween(*, null);              // null
		StringUtils.substringBetween("", "");               // ""
		StringUtils.substringBetween("", "a");             // null
		StringUtils.substringBetween("asdfdf", "df");           //        ""
		StringUtils.substringBetween("asdfas", "as");               // "df"
		StringUtils.substringBetween("dfasdfasdfas", "df");   // "as"
		StringUtils.substringBetween("dfasdfasdfas", "as");   // "df"
		StringUtils.substringBetween("dfasdfasgdf", "df");// "as"
		
//		50.public static String substringBetween(String str, String open, String close)
//		得到str中的在两个字符串open和close中间的字符串，即open和close所夹的串。
//		如果str为null或open为null或close为null，返回null
//		举例(*表示任意)：
//		StringUtils.substringBetween(null, *, *);            // null
//		StringUtils.substringBetween(*, null, *);            // null
//		StringUtils.substringBetween(*, *, null);            // null
//		StringUtils.substringBetween("", "", "");            // ""
		StringUtils.substringBetween("", "", "]");           // null
		StringUtils.substringBetween("", "[", "]");          // null
		StringUtils.substringBetween("[]", "[","]");        // ""
		StringUtils.substringBetween("a[sd]f", "[","]");    // "sd"
		StringUtils.substringBetween("a[sd]f[gh]", "[","]");// "sd"
		StringUtils.substringBetween("a[sd]f", "]","[");      // null
		StringUtils.substringBetween("a[sd]f", "","");           //    ""
		
//		51.public static String[] substringsBetween(String str, String open, String close)
//		得到str中的在两个字符串open和close中间的字符串，即open和close所夹的串，
//		把所有符合的结果放在数组中返回。
//		和50类似，但是返回了所有的结果(50只返回了第一个匹配的结果)。
//		这里不再举例。
		 
//		52.public static String[] split(String str)
//		把字符串拆分成一个字符串数组，用空白符(whitespace)作为分隔符。
//		Whitespace是这样定义的 {@link Character#isWhitespace(char)}
//		如果字符串为null，返回null
//		如果字符串为""，返回空数组{}
//		举例(*表示任意)：
		StringUtils.split(null);                  // null
		StringUtils.split("");                    // {}
		StringUtils.split("as df    yy");          // {"as","df","yy"}
		StringUtils.split(" as df    yy ");         // {"as","df","yy"}
		StringUtils.split("as\ndf\ryy");         // {"as","df","yy"}
		StringUtils.split("as\tdf\fyy");         // {"as","df","yy"}
		StringUtils.split("as       df \fyy");  // {"as","df","yy"}
		StringUtils.split("as\t \r df \f \n yy");// {"as","df","yy"}
		StringUtils.split("as");                 // {"as"}
		StringUtils.split(" as ");               // {"as"}
		
//		53.public static String[] split(String str, char separatorChar)
//		把字符串拆分成一个字符串数组，用指定的字符separatorChar作为分隔符。
//		如果字符串为null，返回null
//		如果字符串为""，返回空数组{}
//		举例(*表示任意)：
//		StringUtils.split(null, *);          // null
//		StringUtils.split("", *);            // {}
		StringUtils.split("as df yy",' ');  // {"as","df","yy"}       
		StringUtils.split(" as df yy ",' ');// {"as","df","yy"}       
		StringUtils.split("asodfoyy",'o');  // {"as","df","yy"}       
		StringUtils.split("as.df.yy",'.');  // {"as","df","yy"}       
		StringUtils.split("as\ndf\nyy",'\n');// {"as","df","yy"}       
		StringUtils.split("as",' ');        // {"as"}       
		StringUtils.split(" as ",' ');      // {"as"}
		
//		54.public static String[] split(String str, String separatorChars)
//		把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符。
//		如果字符串str为null，返回null
//		如果字符串str为""，返回空数组{}
//		如果separatorChars为null，则默认为空白符
//		和53类似。
//		举例(*表示任意)：
		StringUtils.split("as \rdf \t yy",null);// {"as","df","yy"}
		StringUtils.split("as\ndf\fyy",null);    // {"as","df","yy"}
		StringUtils.split("as","");              // {"as"}
		
//		55.public static String[] split(String str, String separatorChars, int max)
//		把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符，
//		数组的最大长度为max。
//		如果字符串str为null，返回null
//		如果字符串str为""，返回空数组{}
//		如果separatorChars为null，则默认为空白符
//		如果max小于等于0，认为是没有限制
//		举例(*表示任意)：
//		StringUtils.split(null, *, *);             // null
//		StringUtils.split("", *, *);               // {}
		StringUtils.split("as df yy",null,0);     // {"as","df","yy"}
		StringUtils.split("as df yy"," ",0);      // {"as","df","yy"}
		StringUtils.split("as.df.yy",".",-1);     // {"as","df","yy"}
		StringUtils.split("as.df.yy",".",4);      // {"as","df","yy"}
		StringUtils.split("as-!-df-!-yy","-!-",0);// {"as","df","yy"}
		StringUtils.split("as.df.yy",".",2);      // {"as","df.yy"}
		StringUtils.split("as","",0);             // {"as"}
		StringUtils.split("as","",2);             // {"as"}
		
//		56.public static String[] splitByWholeSeparator(String str, String separator)
//		个人认为和54功能一样。区别有待发掘。
		
//		57.public static String[] splitByWholeSeparator( String str, String separator, int max )
//		个人认为和55功能一样。区别有待发掘。
		
//		58.public static String[] splitPreserveAllTokens(String str)
//		把字符串str拆分成一个数组，用空白符(whitespace)作为分隔符，保留所有的标识，
//		包括相邻分隔符产生的空的标识。它可作为StringTokenizer的一个替代。
//		Whitespace是这样定义的{@link Character#isWhitespace(char)}。
//		举例(*表示任意)：
		StringUtils.splitPreserveAllTokens(null);            // null
		StringUtils.splitPreserveAllTokens("");              // {}
		StringUtils.splitPreserveAllTokens("as df gh jk");   // {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as\ndf\rgh\fjk");// {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as\tdf gh    jk");  // {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as df gh");     // {"as","","df","gh"}
		StringUtils.splitPreserveAllTokens(" as   df ");    // {"","as","","","df","",""}

//		59.public static String[] splitPreserveAllTokens(String str, char separatorChar)
//		和58类似，只是分隔符为字符separatorChar。
//		举例(*表示任意)：
//		StringUtils.splitPreserveAllTokens(null, *);           // null
//		StringUtils.splitPreserveAllTokens("", *);             // {}
		StringUtils.splitPreserveAllTokens("as df gh jk",' ');// {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as.df.gh.jk",'.');// {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as..df.gh",'.');  // {"as","","df","gh"}
		StringUtils.splitPreserveAllTokens(",as,,,df,,",',');// {"","as","","","df","",""}
		StringUtils.splitPreserveAllTokens("as.df.gh",',');   // {"as.df.gh"}

//		60.public static String[] splitPreserveAllTokens(String str, String separatorChars)
//		和59类似，只是分隔符为字符串separatorChars。
//		举例(*表示任意)：
//		StringUtils.splitPreserveAllTokens(null, *);              // null
//		StringUtils.splitPreserveAllTokens("", *);                // {}
		StringUtils.splitPreserveAllTokens("as df gh jk",null);  // {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as\ndf\rgh\fjk",null);// {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as df gh jk"," ");   // {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as.df.gh.jk",".");   // {"as","df","gh","jk"}
		StringUtils.splitPreserveAllTokens("as..df.gh",".");     // {"as","","df","gh"}
		StringUtils.splitPreserveAllTokens(",as,,,df,,",",");    // {"","as","","","df","",""}
		StringUtils.splitPreserveAllTokens("as.df.gh",",");      // {"as.df.gh"}
		StringUtils.splitPreserveAllTokens("as.df.gh","");       // {"as.df.gh"}
		
//		61.public static String[] splitPreserveAllTokens(String str, String separatorChars, int max)
//		和上面几个类似，只是指定了数组的最大长度。
//		如果max为0或负数，则认为没有限制。
//		这里不再举例。
		
//		62.public static String join(Object[] array)
//		把数组中的元素连接成一个字符串返回。
//		举例(*表示任意)：
		StringUtils.join(null);                       // null
//		StringUtils.join({});                         // ""
		StringUtils.join("as","df","gh","jk");     // "asdfghjk"
		StringUtils.join("as","","df","gh");       // "asdfgh"
		StringUtils.join("","as","","","df","","");// "asdf"
		
//		63.public static String join(Object[] array, char separator)
//		把数组中的元素连接成一个字符串返回，把分隔符separator也加上。
//		举例(*表示任意)：
//		StringUtils.join(null, *);                       // null
//		StringUtils.join({}, *);                         // ""
//		StringUtils.join({null}, *);                     // ""
//		StringUtils.join({"as","df","gh","jk"},' ');    // "as df gh jk"
//		StringUtils.join({"as","df","gh","jk"},'.');    // "as.df.gh.jk"
//		StringUtils.join({"as","","df","gh"},'.');      // "as..df.gh"
//		StringUtils.join({"","as","","","df","",""},',')// ",as,,,df,,"
//		StringUtils.join({"","as","","","df","",""},' ')// " as   df "
//		StringUtils.join({"as.df.gh"},'.');                // "as.df.gh"
//		StringUtils.join({"as.df.gh"},' ');             // "as.df.gh"
		
//		64.public static String join(Object[] array, char separator, int startIndex, int endIndex)
//		把数组中的元素连接成一个字符串返回，把分隔符separator也加上。
//		连接的开始位置为startIndex，结束位置为endIndex。
//		这里不再举例。
		
//		65.public static String join(Object[] array, String separator)
//		与63类似，这里不再举例。
		
//		66.public static String join(Object[] array, String separator, int startIndex, int endIndex)
//		与64类似，这里不再举例。
		 
//		67.public static String deleteWhitespace(String str)
//		删除字符串中的所有空白符(whitespace)，空白符是这样定义的{@link Character#isWhitespace(char)}。
//		举例(*表示任意)：
		StringUtils.deleteWhitespace(null);           // null
		StringUtils.deleteWhitespace("");             // ""
		StringUtils.deleteWhitespace("asd");         // "asd",
		StringUtils.deleteWhitespace("as df");         //    "asdf"
		StringUtils.deleteWhitespace("as\n\r\f\tdf");   //    "asdf"
		StringUtils.deleteWhitespace("as\bdf");           //    "as\bdf"
		StringUtils.deleteWhitespace(" as df ");       //    "asdf"
//		
//		68.public static String removeStart(String str, String remove)
//		如果字符串str是以字符串remove开始，则去掉这个开始，然后返回，否则返回原来的串。
//		举例(*表示任意)：
//		StringUtils.removeStart(null, *);     // null
//		StringUtils.removeStart("", *);       // ""
//		StringUtils.removeStart(*, null);     // *
		StringUtils.removeStart("asdf","");  // "asdf"
		StringUtils.removeStart("asdf","as");   // "df"
		StringUtils.removeStart("asdf","df");   // "asdf"
		StringUtils.removeStart("asdf","gh");   // "asdf"
		
//		69.public static String removeEnd(String str, String remove)
//		如果字符串str是以字符串remove结尾，则去掉这个结尾，然后返回，否则返回原来的串。
//		这里不再举例。
		
//		70.public static String remove(String str, String remove)
//		去掉字符串str中所有包含remove的部分，然后返回。
//		这里不再举例。
		
//		71.public static String remove(String str, char remove)
//		去掉字符串str中所有包含remove的部分，然后返回。
//		这里不再举例。
		
//		72.public static String replaceOnce(String text, String repl, String with)
//		在字符串text中用with代替repl，仅一次。
//		这里不再举例。
		
//		73.public static String replace(String text, String repl, String with)
//		在字符串text中用with代替repl，替换所有。
//		这里不再举例。
		
//		74.public static String replace(String text, String repl, String with, int max)
//		在字符串text中用with代替repl，max为最大替换次数。
//		如果max小于0，则替换所有。
//		这里不再举例。
		
//		75. public static String replaceChars(String str, char searchChar, char replaceChar)
//		在字符串str中用字符replaceChar代替所有字符searchChar，
//		如果字符串为null或""，则返回它本身。
//		这里不再举例。
		
//		76.public static String replaceChars(String str, String searchChars, String replaceChars)
//		用replaceChars代替str中的searchChars。
//		replaceChars的长度应该和searchChars的长度相等，
//		如果replaceChars的长度大于searchChars的长度，超过长度的字符将被忽略，
//		如果replaceChars的长度小于searchChars的长度，超过长度的字符将被删除。
//		举例(*表示任意)：
//		StringUtils.replaceChars(null, *, *);           // null
//		StringUtils.replaceChars("", *, *);             // ""
//		StringUtils.replaceChars("asdf", null, *);      // "asdf"
//		StringUtils.replaceChars("asdf", "", *);        // "asdf"
		StringUtils.replaceChars("asdf","s",null);     // "adf"
		StringUtils.replaceChars("asdf","s","");           // "adf"
		StringUtils.replaceChars("asdsfsg","s","y");   // "aydyfyg"
		StringUtils.replaceChars("asdf","sd","yy");       //    "ayyf"
		StringUtils.replaceChars("asdf","sd","yyy");   //    "ayyf"
		StringUtils.replaceChars("asssdf","s","yyy");   //    "ayyydf"
		StringUtils.replaceChars("asdf","sd","y");       // "ayf"
		StringUtils.replaceChars("assssddddf","sd","y");// "ayyyyf"
//		
//		77.public static String overlay(String str, String overlay, int start, int end)
//		用字符串overlay覆盖字符串str从start到end之间的串。
//		如果str为null，则返回null
//		如果start或end小于0，则设为0
//		如果start大于end，则两者交换
//		如果start或end大于str的长度，则认为等于str的长度
//		举例(*表示任意)：
//		StringUtils.overlay(null, *, *, *);       // null
		StringUtils.overlay("","as",0,0);        // "as"
		StringUtils.overlay("asdfgh","qq",2,5);       //    "asqqh"
		StringUtils.overlay("asdfgh","qq",5,2);       //    "asqqh"
		StringUtils.overlay("asdfgh","qq",-1,3);   //    "qqfgh"
		StringUtils.overlay("asdfgh","qq",-1,-3);   //    "qqasdfgh"
		StringUtils.overlay("asdfgh","qq",7,10);   //    "asdfghqq"
		StringUtils.overlay("asdfgh","qq",0,8);       //    "qq"
		StringUtils.overlay("asdfgh","qq",2,8);       //    "asqq"
		StringUtils.overlay("asdfgh",null,2,5);       //    "ash"
		StringUtils.overlay("asdfgh","",2,5);           //    "ash"
	
//		78.public static String chop(String str)
//		去掉字符串str的最后一个字符。
//		如果字符串以"\r\n"结尾，则去掉它们。
//		这里不再举例。
		
//		79.public static String repeat(String str, int repeat)
//		重复字符串repeat次，组合成一个新串返回。
//		如果字符串str为null或""，则返回它本身
//		如果repeat小于0，则返回""
//		举例(*表示任意)：
//		StringUtils.repeat(null, *);// null
//		StringUtils.repeat("", *);  // ""
		StringUtils.repeat("a", 3);// "aaa"
		StringUtils.repeat("ab", 2);// "abab"
		StringUtils.repeat("a", -2);// ""
		
//		80.public static String rightPad(String str, int size)
//		如果str为null，则返回null
//		如果字符串长度小于size，则在右边补空格使其长度等于size，然后返回
//		如果字符串长度大于等于size，则返回它本身
//		这里不再举例。
		
//		81.public static String rightPad(String str, int size, char padChar)
//		和80类似，只是补的字符为padChar。
//		这里不再举例。
		
//		82.public static String rightPad(String str, int size, String padStr)
//		和80类似，只是补的是字符串padStr。
//		举例(*表示任意)：
//		StringUtils.rightPad(null, *, *);     // null
		StringUtils.rightPad("",0,"");       // ""
		StringUtils.rightPad("",3,"");         //    "   "
		StringUtils.rightPad("",3,"a");           //    "aaa"
		StringUtils.rightPad("",2,"as");       //    "as"
		StringUtils.rightPad("as",-1,"df");       //    "as"
		StringUtils.rightPad("as",0,"df");       //    "as"
		StringUtils.rightPad("as",3,"df");       //    "asd"
		StringUtils.rightPad("as",8,"df");       //    "asdfdfdf"
		StringUtils.rightPad("as",5,null);       //    "as   "
		StringUtils.rightPad("as",5,"");           //    "as   "
		
//		83.public static String leftPad(String str, int size)
//		和80类似，只是补左边。
//		这里不再举例。
		
//		84.public static String leftPad(String str, int size, char padChar)
//		和81类似。
//		这里不再举例。
		
//		85.public static String leftPad(String str, int size, String padStr)
//		和82类似。
//		这里不再举例。
		
//		86.public static String center(String str, int size)
//		产生一个字符串返回，该字符串长度等于size，str位于新串的中心，其他位置补空格。
//		如果str为null，则返回null
//		如果size小于str的长度，则返回str本身
//		举例(*表示任意)：
//		StringUtils.center(null, *);  // null
		StringUtils.center("",1);    // " "
		StringUtils.center("",2);       //    " "
		StringUtils.center("as",-1);   //    "as"
		StringUtils.center("as",2);       //    "as"
		StringUtils.center("as",3);       //    "as "
		StringUtils.center("as",4);       //    " as "
		StringUtils.center("as",10);   //    "    as    "
		
//		87.public static String center(String str, int size, char padChar)
//		和86类似，只是其他位置补padChar。
//		这里不再举例。

//		88.public static String center(String str, int size, String padStr)
//		和86类似，只是其他位置补padStr。
//		这里不再举例。

//		89.public static String swapCase(String str)
//		把字符串中的字符大写转换为小写，小写转换为大写。
//		举例：
		StringUtils.swapCase(null);         // null
		StringUtils.swapCase("");           // ""
		StringUtils.swapCase("Hello Boys");// "hELLO bOYS"
		StringUtils.swapCase("I am 11");       //    "i AM 11"

//		90.public static int countMatches(String str, String sub)
//		计算字符串sub在字符串str中出现的次数。
//		如果str为null或""，则返回0
//		举例(*表示任意)：
//		StringUtils.countMatches(null, *);       // 0
//		StringUtils.countMatches("", *);         // 0
		StringUtils.countMatches("asdf","as");  // 1
		StringUtils.countMatches("asdfas","as");// 2
		StringUtils.countMatches("dfgh","as");  // 0
		StringUtils.countMatches("as","");           // 0
		StringUtils.countMatches("as",null);       // 0
	}
	
	
	@Test
	public void 转换为Null() throws Exception {
		
		String trim1 = StringUtils.trim("");
		String trim2 = StringUtils.trim(null);
		
		System.out.println("trim1:"+trim1);
		System.out.println("trim2:"+trim2);
	}
	
	
	@Test
	public void test01() throws Exception {
			//null 和 ""操作~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//判断是否Null 或者 ""
			System.out.println(StringUtils.isEmpty(null));
			System.out.println(StringUtils.isNotEmpty(null));
			//判断是否null 或者 "" 去空格~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			System.out.println(StringUtils.isBlank("  "));
			System.out.println(StringUtils.isNotBlank(null));
			//去空格.Null返回null~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			System.out.println(StringUtils.trim(null));
			//去空格，将Null和"" 转换为Null
			System.out.println(StringUtils.trimToNull(""));
			//去空格，将NULL 和 "" 转换为""
			System.out.println(StringUtils.trimToEmpty(null));
			//可能是对特殊空格符号去除？？
			System.out.println(StringUtils.strip("大家好  啊  \t"));
			//同上，将""和null转换为Null
			//System.out.println(StringUtils.stripToNull(" \t"));
			//同上，将""和null转换为""
			//System.out.println(StringUtils.stripToEmpty(null));
			//将""或者Null 转换为 ""
			//System.out.println(StringUtils.defaultString(null));
			//仅当字符串为Null时 转换为指定的字符串(二参数)
			//System.out.println(StringUtils.defaultString("", "df"));
			//当字符串为null或者""时，转换为指定的字符串(二参数)
			//System.out.println(StringUtils.defaultIfEmpty(null, "sos"));
			//去空格.去字符~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//如果第二个参数为null去空格(否则去掉字符串2边一样的字符，到不一样为止)
			//System.out.println(StringUtils.strip("fsfsdf", "f"));
			//如果第二个参数为null只去前面空格(否则去掉字符串前面一样的字符，到不一样为止)
			//System.out.println(StringUtils.stripStart("ddsuuu ", "d"));
			//如果第二个参数为null只去后面空格，(否则去掉字符串后面一样的字符，到不一样为止)
			//System.out.println(StringUtils.stripEnd("dabads", "das"));
			//对数组没个字符串进行去空格。
			//ArrayToList(StringUtils.stripAll(new String[]{" 中华 ", "民 国 ", "共和 "}));
			//如果第二个参数为null.对数组每个字符串进行去空格。(否则去掉数组每个元素开始和结尾一样的字符)
			//ArrayToList(StringUtils.stripAll(new String[]{" 中华 ", "民 国", "国共和国"}, "国"));
			//查找,判断~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//判断2个字符串是否相等相等,Null也相等
			//System.out.println(StringUtils.equals(null, null));
			//不区分大小写比较
			//System.out.println(StringUtils.equalsIgnoreCase("abc", "ABc"));
			//查找，不知道怎么弄这么多查找，很多不知道区别在哪？费劲~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//普通查找字符，如果一参数为null或者""返回-1
			//System.out.println(StringUtils.indexOf(null, "a"));
			//从指定位置(三参数)开始查找，本例从第2个字符开始查找k字符
			//System.out.println(StringUtils.indexOf("akfekcd中华", "k", 2));
			//未发现不同之处
			//System.out.println(StringUtils.ordinalIndexOf("akfekcd中华", "k", 2));
			//查找,不区分大小写
			//System.out.println(StringUtils.indexOfIgnoreCase("adfs", "D"));
			//从指定位置(三参数)开始查找,不区分大小写
			//System.out.println(StringUtils.indexOfIgnoreCase("adfs", "a", 3));
			//从后往前查找
			//System.out.println(StringUtils.lastIndexOf("adfas", "a"));
			//未理解,此结果为2
			//System.out.println(StringUtils.lastIndexOf("d饿abasdafs我", "a", 3));
			//未解,此结果为-1
			//System.out.println(StringUtils.lastOrdinalIndexOf("yksdfdht", "f", 2));
			//从后往前查，不区分大小写
			//System.out.println(StringUtils.lastIndexOfIgnoreCase("sdffet", "E"));
			//未解,此结果为1
			//System.out.println(StringUtils.lastIndexOfIgnoreCase("efefrfs看", "F" , 2));
			//检查是否查到，返回boolean,null返回假
			//System.out.println(StringUtils.contains("sdf", "dg"));
			//检查是否查到，返回boolean,null返回假,不区分大小写
			//System.out.println(StringUtils.containsIgnoreCase("sdf", "D"));
			//检查是否有含有空格,返回boolean
			//System.out.println(StringUtils.containsWhitespace(" d"));
			//查询字符串跟数组任一元素相同的第一次相同的位置
			//System.out.println(StringUtils.indexOfAny("absfekf", new String[]{"f", "b"}));
			//查询字符串中指定字符串(参数二)出现的次数
			//System.out.println(StringUtils.indexOfAny("afefes", "e"));
			//查找字符串中是否有字符数组中相同的字符，返回boolean
			//System.out.println(StringUtils.containsAny("asfsd", new char[]{'k', 'e', 's'}));
			//未理解与lastIndexOf不同之处。是否查到，返回boolean
			//System.out.println(StringUtils.containsAny("啡f咖啡", "咖"));
			//未解
			//System.out.println(StringUtils.indexOfAnyBut("seefaff", "af"));
			//判断字符串中所有字符，都是出自参数二中。
			//System.out.println(StringUtils.containsOnly("中华华", "华"));
			//判断字符串中所有字符，都是出自参数二的数组中。
			//System.out.println(StringUtils.containsOnly("中华中", new char[]{'中', '华'}));
			//判断字符串中所有字符，都不在参数二中。
			//System.out.println(StringUtils.containsNone("中华华", "国"));
			//判断字符串中所有字符，都不在参数二的数组中。
			//System.out.println(StringUtils.containsNone("中华中", new char[]{'中', '达人'}));
			//从后往前查找字符串中与字符数组中相同的元素第一次出现的位置。本例为4
			//System.out.println(StringUtils.lastIndexOfAny("中国人民共和国", new String[]{"国人", "共和"}));
			//未发现与indexOfAny不同之处  查询字符串中指定字符串(参数二)出现的次数
			//System.out.println(StringUtils.countMatches("中国人民共和中国", "中国"));
			//检查是否CharSequence的只包含Unicode的字母。空将返回false。一个空的CharSequence（长（）= 0）将返回true
			//System.out.println(StringUtils.isAlpha("这是干什么的2"));
			//检查是否只包含Unicode的CharSequence的字母和空格（''）。空将返回一个空的CharSequence假（长（）= 0）将返回true。
			//System.out.println(StringUtils.isAlphaSpace("NBA直播 "));
			//检查是否只包含Unicode的CharSequence的字母或数字。空将返回false。一个空的CharSequence（长（）= 0）将返回true。
			//System.out.println(StringUtils.isAlphanumeric("NBA直播"));
			//如果检查的Unicode CharSequence的只包含字母，数字或空格（''）。空将返回false。一个空的CharSequence（长（）= 0）将返回true。
			//System.out.println(StringUtils.isAlphanumericSpace("NBA直播"));
			//检查是否只包含ASCII可CharSequence的字符。空将返回false。一个空的CharSequence（长（）= 0）将返回true。
			//System.out.println(StringUtils.isAsciiPrintable("NBA直播"));
			//检查是否只包含数值。
			//System.out.println(StringUtils.isNumeric("NBA直播"));
			//检查是否只包含数值或者空格
			//System.out.println(StringUtils.isNumericSpace("33 545"));
			//检查是否只是空格或""。
			//System.out.println(StringUtils.isWhitespace(" "));
			//检查是否全是英文小写。
			//System.out.println(StringUtils.isAllLowerCase("kjk33"));
			//检查是否全是英文大写。
			//System.out.println(StringUtils.isAllUpperCase("KJKJ"));
	}
	
	@Test
	public void test02() throws Exception {
		//交集操作~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//去掉参数2字符串中在参数一中开头部分共有的部分，结果为:人民共和加油
		//System.out.println(StringUtils.difference("中国加油", "中国人民共和加油"));
		//统计2个字符串开始部分共有的字符个数
		//System.out.println(StringUtils.indexOfDifference("ww.taobao", "www.taobao.com"));
		//统计数组中各个元素的字符串开始都一样的字符个数
		//System.out.println(StringUtils.indexOfDifference(new String[] {"中国加油", "中国共和", "中国人民"}));
		//取数组每个元素共同的部分字符串
		//System.out.println(StringUtils.getCommonPrefix(new String[] {"中国加油", "中国共和", "中国人民"}));
		//统计参数一中每个字符与参数二中每个字符不同部分的字符个数
		//System.out.println(StringUtils.getLevenshteinDistance("中国共和发国人民", "共和国"));
		//判断开始部分是否与二参数相同
		//System.out.println(StringUtils.startsWith("中国共和国人民", "中国"));
		//判断开始部分是否与二参数相同。不区分大小写
		//System.out.println(StringUtils.startsWithIgnoreCase("中国共和国人民", "中国"));
		//判断字符串开始部分是否与数组中的某一元素相同
		//System.out.println(StringUtils.startsWithAny("abef", new String[]{"ge", "af", "ab"}));
		//判断结尾是否相同
		//System.out.println(StringUtils.endsWith("abcdef", "def"));
		//判断结尾是否相同，不区分大小写
		//System.out.println(StringUtils.endsWithIgnoreCase("abcdef", "Def"));
		//字符串截取~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//截取指定位置的字符，null返回null.""返回""
		//System.out.println(StringUtils.substring("国民党", 2));
		//截取指定区间的字符
		//System.out.println(StringUtils.substring("中国人民共和国", 2, 4));
		//从左截取指定长度的字符串
		//System.out.println(StringUtils.left("说点什么好呢", 3));
		//从右截取指定长度的字符串
		//System.out.println(StringUtils.right("说点什么好呢", 3));
		//从第几个开始截取，三参数表示截取的长度
		//System.out.println(StringUtils.mid("说点什么好呢", 3, 2));
		//截取到等于第二个参数的字符串为止
		//System.out.println(StringUtils.substringBefore("说点什么好呢", "好"));
		//从左往右查到相等的字符开始，保留后边的，不包含等于的字符。本例：什么好呢
		//System.out.println(StringUtils.substringAfter("说点什么好呢", "点"));
		//这个也是截取到相等的字符，但是是从右往左.本例结果：说点什么好
		//System.out.println(StringUtils.substringBeforeLast("说点什么好点呢", "点"));
		//这个截取同上是从右往左。但是保留右边的字符
		//System.out.println(StringUtils.substringAfterLast("说点什么好点呢？", "点"));
		//截取查找到第一次的位置，和第二次的位置中间的字符。如果没找到第二个返回null。本例结果:2010世界杯在
		//System.out.println(StringUtils.substringBetween("南非2010世界杯在南非，在南非", "南非"));
		//返回参数二和参数三中间的字符串，返回数组形式
		//ArrayToList(StringUtils.substringsBetween("[a][b][c]", "[", "]"));
		//分割~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//用空格分割成数组，null为null
		//ArrayToList(StringUtils.split("中华 人民  共和"));
		//以指定字符分割成数组
		//ArrayToList(StringUtils.split("中华 ,人民,共和", ","));
		//以指定字符分割成数组，第三个参数表示分隔成数组的长度，如果为0全体分割
		//ArrayToList(StringUtils.split("中华 ：人民：共和", "：", 2));
		//未发现不同的地方,指定字符分割成数组
		//ArrayToList(StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-"));
		//未发现不同的地方,以指定字符分割成数组，第三个参数表示分隔成数组的长度
		//ArrayToList(StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 2));
		//分割，但" "不会被忽略算一个元素,二参数为null默认为空格分隔
		//ArrayToList(StringUtils.splitByWholeSeparatorPreserveAllTokens(" ab   de fg ", null));
		//同上，分割," "不会被忽略算一个元素。第三个参数代表分割的数组长度。
		//ArrayToList(StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null, 3));
		//未发现不同地方,分割
		//ArrayToList(StringUtils.splitPreserveAllTokens(" ab   de fg "));
		//未发现不同地方,指定字符分割成数组
		//ArrayToList(StringUtils.splitPreserveAllTokens(" ab   de fg ", null));
		//未发现不同地方,以指定字符分割成数组，第三个参数表示分隔成数组的长度
		//ArrayToList(StringUtils.splitPreserveAllTokens(" ab   de fg ", null, 2));
		//以不同类型进行分隔
		//ArrayToList(StringUtils.splitByCharacterType("AEkjKr i39:。中文"));
		//未解
		//ArrayToList(StringUtils.splitByCharacterTypeCamelCase("ASFSRules234"));
		//拼接~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//将数组转换为字符串形式
		//System.out.println(StringUtils.concat(getArrayData()));
		//拼接时用参数一得字符相连接.注意null也用连接符连接了
		//System.out.println(StringUtils.concatWith(",", getArrayData()));
		//也是拼接。未发现区别
		//System.out.println(StringUtils.join(getArrayData()));
		//用连接符拼接，为发现区别
		//System.out.println(StringUtils.join(getArrayData(), ":"));
		//拼接指定数组下标的开始(三参数)和结束(四参数,不包含)的中间这些元素，用连接符连接
		//System.out.println(StringUtils.join(getArrayData(), ":", 1, 3));
		//用于集合连接字符串.用于集合
		//System.out.println(StringUtils.join(getListData(), ":"));
		//移除，删除~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//删除所有空格符
		//System.out.println(StringUtils.deleteWhitespace(" s 中 你 4j"));
		//移除开始部分的相同的字符
		//System.out.println(StringUtils.removeStart("www.baidu.com", "www."));
		//移除开始部分的相同的字符,不区分大小写
		//System.out.println(StringUtils.removeStartIgnoreCase("www.baidu.com", "WWW"));
		//移除后面相同的部分
		//System.out.println(StringUtils.removeEnd("www.baidu.com", ".com"));
		//移除后面相同的部分，不区分大小写
		//System.out.println(StringUtils.removeEndIgnoreCase("www.baidu.com", ".COM"));
		//移除所有相同的部分
		//System.out.println(StringUtils.remove("www.baidu.com/baidu", "bai"));
		//移除结尾字符为"\n", "\r", 或者 "\r\n".
		//System.out.println(StringUtils.chomp("abcrabc\r"));
		//也是移除，未解。去结尾相同字符
		//System.out.println(StringUtils.chomp("baidu.com", "com"));
		//去掉末尾最后一个字符.如果是"\n", "\r", 或者 "\r\n"也去除
		//System.out.println(StringUtils.chop("wwe.baidu"));
		//替换~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//替换指定的字符，只替换第一次出现的
		//System.out.println(StringUtils.replaceOnce("www.baidu.com/baidu", "baidu", "hao123"));
		//替换所有出现过的字符
		//System.out.println(StringUtils.replace("www.baidu.com/baidu", "baidu", "hao123"));
		//也是替换，最后一个参数表示替换几个
		//System.out.println(StringUtils.replace("www.baidu.com/baidu", "baidu", "hao123", 1));
		//这个有意识，二三参数对应的数组，查找二参数数组一样的值，替换三参数对应数组的值。本例:baidu替换为taobao。com替换为net
		//System.out.println(StringUtils.replaceEach("www.baidu.com/baidu", new String[]{"baidu", "com"}, new String[]{"taobao", "net"}));
		//同上，未发现不同
		//System.out.println(StringUtils.replaceEachRepeatedly("www.baidu.com/baidu", new String[]{"baidu", "com"}, new String[]{"taobao", "net"}));
		//这个更好，不是数组对应，是字符串参数二和参数三对应替换.(二三参数不对应的话，自己看后果)
		//System.out.println(StringUtils.replaceChars("www.baidu.com", "bdm", "qo"));
		//替换指定开始(参数三)和结束(参数四)中间的所有字符
		//System.out.println(StringUtils.overlay("www.baidu.com", "hao123", 4, 9));
		//添加，增加~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//复制参数一的字符串，参数二为复制的次数
		//System.out.println(StringUtils.repeat("ba", 3));
		//复制参数一的字符串，参数三为复制的次数。参数二为复制字符串中间的连接字符串
		//System.out.println(StringUtils.repeat("ab", "ou", 3));
		//如何字符串长度小于参数二的值，末尾加空格补全。(小于字符串长度不处理返回)
		//System.out.println(StringUtils.rightPad("海川", 4));
		//字符串长度小于二参数，末尾用参数三补上，多于的截取(截取补上的字符串)
		//System.out.println(StringUtils.rightPad("海川", 4, "河流啊"));
		//同上在前面补全空格
		//System.out.println(StringUtils.leftPad("海川", 4));
		//字符串长度小于二参数，前面用参数三补上，多于的截取(截取补上的字符串)
		//System.out.println(StringUtils.leftPad("海川", 4, "大家好"));
		//字符串长度小于二参数。在两侧用空格平均补全（测试后面补空格优先）
		//System.out.println(StringUtils.center("海川", 3));
		//字符串长度小于二参数。在两侧用三参数的字符串平均补全（测试后面补空格优先）
		//System.out.println(StringUtils.center("海川", 5, "流"));
		//只显示指定数量(二参数)的字符,后面以三个点补充(参数一截取+三个点=二参数)
		//System.out.println(StringUtils.abbreviate("中华人民共和国", 5));
		//2头加点这个有点乱。本例结果: ...ijklmno
		//System.out.println(StringUtils.abbreviate("abcdefghijklmno", 12, 10));
		//保留指定长度，最后一个字符前加点.本例结果: ab.f
		//System.out.println(StringUtils.abbreviateMiddle("abcdef", ".", 4));
		//转换,刷选~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//转换第一个字符为大写.如何第一个字符是大写原始返回
		//System.out.println(StringUtils.capitalize("Ddf"));
		//转换第一个字符为大写.如何第一个字符是大写原始返回
		//System.out.println(StringUtils.uncapitalize("DTf"));
		//反向转换，大写变小写，小写变大写
		//System.out.println(StringUtils.swapCase("I am Jiang, Hello"));
		//将字符串倒序排列
		//System.out.println(StringUtils.reverse("中国人民"));
		//根据特定字符(二参数)分隔进行反转
		//System.out.println(StringUtils.reverseDelimited("中:国:人民", ':'));
	}
	

}
