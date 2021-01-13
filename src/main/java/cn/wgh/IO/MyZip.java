package cn.wgh.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * ZIP压缩输入/输出流
 * ZipInputStream/ZipOutStream
 * <p>
 * Created by wgh on 2021/1/11.
 */
public class MyZip {

    /**
     * 压缩成Zip文件
     *
     * @param zipFileName
     * @param inputFile
     * @throws Exception
     */
    public void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
        String path = inputFile.getPath();
        System.out.println("压缩中...");
        zip(zipOutputStream, inputFile, "");
        System.out.println("压缩完成");
        zipOutputStream.close();
    }

    /**
     * @param zipOutputStream
     * @param inputFile
     * @param base
     * @throws Exception
     */
    private void zip(ZipOutputStream zipOutputStream, File inputFile, String base) throws Exception {
        if (inputFile.isDirectory()) {
            //获取路径数组
            File[] fl = inputFile.listFiles();
            //写入此目录的entry
            zipOutputStream.putNextEntry(new ZipEntry(
                    base + "/"
            ));
            //判断是否为空
            base = base.length() == 0 ? "" : base + "/";
            //循环遍历数组中的文件
            for (int i = 0; i < fl.length; i++) {
                zip(zipOutputStream, fl[i], base + fl[i]);
            }
        } else {
            //创建新的进入点
            zipOutputStream.putNextEntry(new ZipEntry(base));
            FileInputStream inputStream = new FileInputStream(inputFile);
            //定义int型变量
            int b;
            System.out.println(base);
            while ((b = inputStream.read()) != -1) {
                zipOutputStream.write(b);
            }
            inputStream.close();
        }
    }

    public void unZip(String zipFileName) throws Exception {

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFileName))) {
            //实例化对象，指明要进行解压的文件
            ZipEntry entry = zipInputStream.getNextEntry();
            while ((entry = zipInputStream.getNextEntry()) != null && !entry.isDirectory()) {
                //如果entry不为空，并不在同一目录下
                File file = new File("F:\\" + entry.getName());
                System.out.println(file);
                if (!file.exists()) {
                    file.mkdirs();
                    file.createNewFile();
                }
                zipInputStream.closeEntry();
                System.out.println(entry.getName() + "解压成功");
            }
            zipInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
