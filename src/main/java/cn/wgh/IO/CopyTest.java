package cn.wgh.IO;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

/**
 * Created by wgh on 2021/3/4.
 */
public class CopyTest {

    @Test
    public void test1() throws Exception {
        File srcFile = new File("F:\\javatest\\Filetest\\文件夹1\\文件夹2\\2-1.txt");
        File destDir = new File("F:\\javatest\\Filetest\\文件夹1");
        FileUtils.copyFileToDirectory(srcFile, destDir);
    }

    /**
     * 把某个文件夹里所有文件都移动到某个文件夹里
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        File src = new File("F:\\javatest\\Filetest\\文件夹1");
        File destDir = new File("F:\\javatest\\Filetest\\文件夹4");

        /*File src = new File("J:\\OPPOA7\\video");
        File destDir = new File("J:\\OPPOA7\\video");*/
        cn.wgh.IO.FileUtils.copyAllFileToDirectory(src, destDir);
    }



}
