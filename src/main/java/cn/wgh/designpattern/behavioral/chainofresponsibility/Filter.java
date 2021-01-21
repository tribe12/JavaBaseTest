package cn.wgh.designpattern.behavioral.chainofresponsibility;


/**
 * Created by wgh on 2021/1/18.
 */
public interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}
