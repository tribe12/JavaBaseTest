package cn.wgh.IO;

import org.junit.Test;

import java.io.*;

/**
 * 带缓存的输入/输出流
 * BufferedInputStream/BufferedOutStream
 * <p>
 * Created by wgh on 2021/1/11.
 */
public class BufferedStreamTest {
    @Test
    public void test1() throws Exception {
        //定义字符串数组
        String content[] = {"好久不见", "你好吗", "常联系"};
        File file = new File("word.txt");
        try {
            //创建FileWriter对象
            FileWriter fw = new FileWriter(file);
            //创建BufferedWriter对象
            BufferedWriter bufw = new BufferedWriter(fw);
            //循环遍历数组
            for (int i = 0; i < content.length; i++) {
                //将字符串数组中的元素写入到哦磁盘文件中
                bufw.write(content[i]);
                //将数组中的单个元素以单行的形式写入文件
                bufw.newLine();
            }
            bufw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            FileReader fr = new FileReader(file);
            //创建BufferedReader类对象
            BufferedReader bufr = new BufferedReader(fr);
            String s = null;
            int i = 0;
            //如果文件的文本行数部位null，则进入循环
            while ((s=bufr.readLine())!=null){
                i++;
                System.out.println("第"+i+"行："+s);
            }
            bufr.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
