package cn.wgh.thread.threadlocal;

/**
 * 需求：用 3 名画家在同一个画布上各自绘制一种颜色，并打印出其绘制的颜色。
 * <p>
 * 现有 2 种解决方案：
 * 一种是在 run 方法中加入 synchronized 同步代码块，
 * 另一种是使用 ThreadLocal 改造 Canvas 类型。
 *
 * @author: tribe
 * @time: 2023/2/12 8:44
 */
public class Demo {
    public static void main(String[] args) {
        // 创建画布
        Canvas canvas = new Canvas();

        Painter painter1 = new Painter("小强", canvas, "红色");
        Painter painter2 = new Painter("旺财", canvas, "黄色");
        Painter painter3 = new Painter("狗蛋", canvas, "蓝色");

        painter1.start();
        painter2.start();
        painter3.start();
    }
}

/**
 * 画家类
 */
class Painter extends Thread {
    private String name;
    private Canvas canvas;
    private String color;

    public Painter(String name, Canvas canvas, String color) {
        this.name = name;
        this.canvas = canvas;
        this.color = color;
    }

    @Override
    public void run() {
        canvas.setContent(color);
        System.out.println(this.name + "在画板绘制" + canvas.getContent());
    }
}

/**
 * 画布类
 * (有线程问题)
 */
/*class Canvas {
    private String content;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}*/

/**
 * 画家类
 * 用ThreadLocal改造Canvas类为如下
 */
class Canvas {
    private ThreadLocal<String> map = new ThreadLocal();
    public String getContent() {
        return map.get();
    }
    public void setContent(String content) {
        map.set(content);
    }
}
