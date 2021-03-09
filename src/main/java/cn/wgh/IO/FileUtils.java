package cn.wgh.IO;

import java.io.File;
import java.io.IOException;

/**
 * 文件，文件夹复制工具
 * <p>
 * Created by wgh on 2021/3/4.
 */
public class FileUtils {

    public static long copyAllFileToDirectory(File src, File destDir) {
        long copyCount = copyAllFileToDirectory(src, destDir, 0l);
        System.out.println("copy file count:" + copyCount);
        return copyCount;
    }

    private static long copyAllFileToDirectory(File src, File destDir, long copyCount) {
        System.out.println(src.getName());
        if (src.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = src.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹，递归获取里面的文件、文件夹
                if (files[i].isDirectory()) {
                    copyCount = copyAllFileToDirectory(files[i], destDir, copyCount);
                } else {
                    // 如果是文件就直接拷贝
                    try {
                        org.apache.commons.io.FileUtils.copyFileToDirectory(files[i], destDir);
                        copyCount++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // 如果是文件就直接拷贝
            try {
                org.apache.commons.io.FileUtils.copyFileToDirectory(src, destDir);
                copyCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return copyCount;
    }
}
