package cn.wgh.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.util.Assert;

/**
 * JavaBean和XML相互转换的工具<br><br>
 * <b>在需要转换的JavaBean上添加注解@XmlRootElement</b>
 * 
 * @author lshaci
 */
public class JavaBeanUtil {

	/**
	 * 将JavaBean对象转换为XML文件
	 * 
	 * @param t		需要转换的JavaBean对象
	 * @param file	转换后保存XML的文件
	 * @throws JAXBException
	 * @throws IOException 
	 */
	public static <T> void bean2XmlFile(T t, File file) throws JAXBException, IOException {
		Assert.notNull(t, "JavaBean对象为null");
		Assert.notNull(file, "XML文件为null");
		
		JAXBContext context = JAXBContext.newInstance(t.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(t, file);
	}
	
	/**
	 * 将JavaBean对象转换为XML
	 * 
	 * @param t			需要转换的JavaBean对象
	 * @param filePath	转换后保存XML的文件路径
	 * @throws JAXBException
	 * @throws IOException 
	 */
	public static <T> void bean2XmlFile(T t, String filePath) throws JAXBException, IOException {
		Assert.notNull(filePath, "文件路径为null");
		
		bean2XmlFile(t, new File(filePath));
	}
	
	/**
	 * 将JavaBean对象转换为XML字符串
	 * 
	 * @param t		需要转换的JavaBean对象
	 * @return		返回XML格式的字符串
	 */
	public static <T> String bean2XmlString(T t) {
		Assert.notNull(t, "JavaBean对象为null");
		
		StringWriter writer = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(t.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(t, writer);
			
			return writer.toString().replace(" standalone=\"yes\"", "");
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 将XML转换为JavaBean对象
	 * 
	 * @param filePath	需要转换为JavaBean对象的XML文件路径
	 * @param clazz		JavaBean对象的字节码
	 * @return	clazz对应的JavaBean实例
	 */
	public static <T> T xml2Bean(String filePath, Class<T> clazz) {
		return (T) xml2Bean(clazz, new File(filePath));
	}
	
	/**
	 * 将XML转换为JavaBean对象
	 * 
	 * @param clazz		JavaBean对象的字节码
	 * @param file		需要转换为JavaBean对象的XML文件
	 * @return	clazz对应的JavaBean实例
	 */
	public static <T> T xml2Bean(Class<T> clazz, File file) {
		try {
			return (T) xml2Bean(clazz, new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将XML转换为JavaBean对象
	 * @param clazz		JavaBean对象的字节码
	 * @param xmlStr	需要转换为JavaBean对象的XML格式的字符串
	 * @return	clazz对应的JavaBean实例
	 */
	public static <T> T xml2Bean(Class<T> clazz, String xmlStr) {
		return (T) xml2Bean(clazz, new StringReader(xmlStr));
	}
	
	/**
	 * 将XML转换为JavaBean对象
	 * 
	 * @param clazz		JavaBean对象的字节码
	 * @param reader	需要转换为JavaBean对象的XML字符流
	 * @return	clazz对应的JavaBean实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2Bean(Class<T> clazz, Reader reader) {
		Assert.notNull(clazz, "JavaBean对象的字节码为null");
		Assert.notNull(reader, "数据源为null");
		
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (T) unmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

