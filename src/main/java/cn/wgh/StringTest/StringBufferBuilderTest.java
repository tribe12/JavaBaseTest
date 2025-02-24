package cn.wgh.StringTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBufferBuilderTest {
	@Test
	public void testName() throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("壹");
		stringBuffer.append("贰");
		stringBuffer.append("叁");
		System.out.println(stringBuffer);
	}

	@Test
	public void testName2() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("壹");
		stringBuilder.append("贰");
		stringBuilder.append("叁");
		System.out.println(stringBuilder);
	}

	@Test
	public void testName3() throws Exception {
		StringPojo stringPojo = new StringPojo();

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("壹");
		stringPojo.setIdBuf(stringBuffer);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("贰");

		stringPojo.setIdStr("007");
		stringPojo.setIdBuf(stringBuffer);
		stringPojo.setIdBud(stringBuilder);

		System.out.println(stringPojo.getIdStr());
		System.out.println(stringPojo.getIdBuf());
		System.out.println(stringPojo.getIdBud());
	}

	/**
	 * StringBuffer常用方法
	 * 
	 * （由于StringBuffer和StringBuilder在使用上几乎一样，所以只写一个，以下部分内容网络各处收集，不再标注出处）
	 * StringBuffer s = new StringBuffer(); 这样初始化出的StringBuffer对象是一个空的对象，
	 * StringBuffer sb1=new StringBuffer(512); 分配了长度512字节的字符缓冲区。 StringBuffer
	 * sb2=new StringBuffer(“how are you?”)
	 * 创建带有内容的StringBuffer对象，在字符缓冲区中存放字符串“how are you?”
	 */
	@Test
	public void newtestName() throws Exception {
		StringBuffer s = new StringBuffer(); // 这样初始化出的StringBuffer对象是一个空的对象，
		StringBuffer sb1 = new StringBuffer(512); // 分配了长度512字节的字符缓冲区。
		StringBuffer sb2 = new StringBuffer("how are you?");
	}

	/**
	 * a、append方法 public StringBuffer append(boolean b)
	 * 该方法的作用是追加内容到当前StringBuffer对象的末尾，类似于字符串的连接，调用该方法以后，StringBuffer对象的内容也发生改
	 * 变，例如： StringBuffer sb = new StringBuffer(“abc”); sb.append(true);
	 * 则对象sb的值将变成”abctrue” 使用该方法进行字符串的连接，将比String更加节约内容，经常应用于数据库SQL语句的连接。
	 */
	@Test
	public void appendtestName() throws Exception {
		StringBuffer sb = new StringBuffer("abc");
		sb.append(true);
		System.out.println(sb);
	}

	/**
	 * b、deleteCharAt方法 public StringBuffer deleteCharAt(int index)
	 * 该方法的作用是删除指定位置的字符，然后将剩余的内容形成新的字符串。例如： StringBuffer sb = new
	 * StringBuffer(“KMing”); sb. deleteCharAt(1);
	 * 该代码的作用删除字符串对象sb中索引值为1的字符，也就是删除第二个字符，剩余的内容组成一个新的字符串。所以对象sb的值变 为”King”。
	 * 还存在一个功能类似的delete方法： public StringBuffer delete(int start,int end)
	 * 该方法的作用是删除指定区间以内的所有字符，包含start，不包含end索引值的区间。例如： StringBuffer sb = new
	 * StringBuffer(“TestString”); sb. delete (1,4);
	 * 该代码的作用是删除索引值1(包括)到索引值4(不包括)之间的所有字符，剩余的字符形成新的字符串。则对象sb的值是”TString”。
	 */

	@Test
	public void deleteCharAt() throws Exception {
		StringBuffer sb = new StringBuffer("KMing");
		sb.deleteCharAt(1);
		System.out.println(sb);
	}

	/**
	 * c、insert方法 public StringBuffer insert(int offset, boolean b),
	 * 该方法的作用是在StringBuffer对象中插入内容，然后形成新的字符串。例如： StringBuffer sb = new
	 * StringBuffer(“TestString”); sb.insert(4,false);
	 * 该示例代码的作用是在对象sb的索引值4的位置插入false值，形成新的字符串，则执行以后对象sb的值是”TestfalseString”。
	 */
	@Test
	public void insert() throws Exception {
		StringBuffer sb = new StringBuffer("TestString");
		sb.insert(4, false);
		System.out.println(sb);
	}

	/**
	 * d、reverse方法 public StringBuffer reverse()
	 * 该方法的作用是将StringBuffer对象中的内容反转，然后形成新的字符串。例如： StringBuffer sb = new
	 * StringBuffer(“abc”); sb.reverse(); 经过反转以后，对象sb中的内容将变为”cba”。
	 */
	@Test
	public void reverse() throws Exception {
		StringBuffer sb = new StringBuffer("abc");
		sb.reverse();
		System.out.println(sb);
	}
	
	/**
	 * e、setCharAt方法 public void setCharAt(int index, char
	 * ch)该方法的作用是修改对象中索引值为index位置的字符为新的字符ch。例如： StringBuffer sb = new
	 * StringBuffer(“abc”); sb.setCharAt(1,’D’); 则对象sb的值将变成”aDc”。
	 */
	@Test
	public void setCharAt() throws Exception {
		StringBuffer sb = new StringBuffer("abc"); 
		sb.setCharAt(1,'D');
		System.out.println(sb);
	}
	
	
	/**
	 * f、trimToSize方法 public void trimToSize()
	 * 该方法的作用是将StringBuffer对象的中存储空间缩小到和字符串长度一样的长度，减少空间的浪费，和String的trim()是一样的作用，
	 * 不在举例。
	 */
	@Test
	public void trimToSize() throws Exception {
		StringBuffer sb = new StringBuffer("abc"); 
		sb.deleteCharAt(1);
		sb.trimToSize();
	}
	
	
	/**
	 * g、length方法 该方法的作用是获取字符串长度 ，不用再说了吧。
	 */
	@Test
	public void length() throws Exception {
		StringBuffer sb = new StringBuffer("abcdefg"); 
		System.out.println(sb.length());
	}
	
	/**
	 * h、setlength方法 该方法的作用是设置字符串缓冲区大小。 StringBuffer sb=new StringBuffer();
	 * sb.setlength(100); 如果用小于当前字符串长度的值调用setlength()方法，则新长度后面的字符将丢失。
	 */
	@Test
	public void setlength() throws Exception {
		 StringBuffer sb=new StringBuffer("abcdefg");
		 System.out.println(sb);
		 sb.setLength(3); 
		 System.out.println(sb);
	}
	
	
	/**
	 * i、sb.capacity方法 该方法的作用是获取字符串的容量。 StringBuffer sb=new
	 * StringBuffer(“string”); int i=sb.capacity();
	 */
	@Test
	public void capacity() throws Exception {
		StringBuffer sb=new
		StringBuffer("abcdefg");
		int i=sb.capacity();
		System.out.println(i);
	}
	
	
	/**
	 * j、ensureCapacity方法 该方法的作用是重新设置字符串容量的大小。 StringBuffer sb=new
	 * StringBuffer(); sb.ensureCapacity(32); //预先设置sb的容量为32
	 */
	@Test
	public void ensureCapacity() throws Exception {
		 StringBuffer sb=new StringBuffer();
		 sb.ensureCapacity(32);
		 System.out.println(sb.length());
		 System.out.println(sb.capacity());
	}
	
	/**
	 * k、getChars方法 该方法的作用是将字符串的子字符串复制给数组。
	 *  getChars(int start,int end,char chars[],int charStart); 
	 *  StringBuffer sb = new StringBuffer("I love You");
	 * int begin = 0; 
	 * int end = 5; //注意ch字符数组的长度一定要大于等于begin到end之间字符的长度
	 *             //小于的话会报ArrayIndexOutOfBoundsException 
	 *             //如果大于的话，大于的字符会以空格补齐 
	 * char[] ch = new char[end-begin];
	 * sb.getChars(begin, end, ch, 0);
	 * System.out.println(ch);
	 *  结果：I lov
	 * 
	 */
	@Test
	public void getChars() throws Exception {
		 StringBuffer sb = new StringBuffer("I love You");
		 int begin = 0; 
		 int end = 5;
		 char[] ch = new char[end-begin];
		 sb.getChars(begin, end, ch, 0);
		 System.out.println(ch);
	}

}
