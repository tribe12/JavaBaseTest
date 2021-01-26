package cn.wgh.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * ZIP压缩输入/输出流
 * ZipInputStream/ZipOutStream
 * <p>
 * Created by wgh on 2021/1/11.
 */
public class ZipTest {
    @Test
    public void zipTest() throws Exception {
        MyZip myZip = new MyZip();
        try {
            myZip.zip("F:\\test\\io\\zip\\z1.zip", new File("F:\\test\\io\\zip\\z1"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unZipTest() throws Exception {
        MyZip myZip = new MyZip();
        try {
            myZip.unZip("F:\\test\\io\\zip\\z1.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
