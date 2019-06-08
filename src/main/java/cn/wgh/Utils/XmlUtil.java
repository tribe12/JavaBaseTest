package cn.wgh.Utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * String和Xml相互转换工具
 * @author wgh
 * 还没成功
 *https://zhidao.baidu.com/question/305439198.html?qbl=relate_question_4&word=java%B0%D1%CF%C2%D4%D8%CE%C4%BC%FE%D7%AA%B3%C9%C1%F7
 */
public class XmlUtil {
	/**
	 * 将xml文件转换成String
	 * @param XmlFileName
	 * @return
	 */
	public static String xmlChangeString(String XmlFileName) {
		try {
			SAXReader saxReader = new SAXReader();// 新建一个解析类
			Document tempDocument = saxReader.read(XmlUtil.class.getClassLoader().getResourceAsStream(XmlFileName));// 读入一个文件
			return tempDocument.asXML();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  将字符串string类型转换成xml文件
	 * @param str
	 * @throws IOException
	 */
	public static void strChangeXML(String str,String XmlFileName) throws IOException {
		System.err.println("hahahahah");
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(new ByteArrayInputStream(str.getBytes("UTF-8")));
			OutputFormat format = OutputFormat.createPrettyPrint();
			/** 将document中的内容写入文件中 */
			File file = new File(XmlFileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			XMLWriter writer = new XMLWriter(new FileWriter(file), format);
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}
