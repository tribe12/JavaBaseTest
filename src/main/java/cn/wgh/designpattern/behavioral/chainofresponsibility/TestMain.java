package cn.wgh.designpattern.behavioral.chainofresponsibility;

import org.junit.Test;

/**
 * 责任链模式
 * <p>
 * Created by wgh on 2021/1/18.
 */
public class TestMain {
    @Test
    public void test1() throws Exception {
        Request request = new Request();
        request.str = "大家好，<hello>，我们的目标是996！";
        Response response = new Response();
        response.str = "收到~~~。。。";
        FilterChain filterChain = new FilterChain();
        /*添加顺序不一样，处理顺序就不一样*/
//        filterChain.add(new HtmlFilter()).add(new SensitiveFilter());
        filterChain.add(new SensitiveFilter()).add(new HtmlFilter());
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}
