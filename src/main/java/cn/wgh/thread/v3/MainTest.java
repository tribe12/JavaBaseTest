package cn.wgh.thread.v3;

/**
 * Created by wgh on 2021/4/5.
 */
public class MainTest {


    /**
     * 输出器
     * 把字母一个个打出来
     */
    class Outputer{
        public void output(String name){
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.println(name.charAt(i));
            }
            System.out.println("");
        }
    }
}
