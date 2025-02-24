package cn.wgh.designpattern.behavioral.chainofresponsibility;

/**
 * Created by wgh on 2021/1/18.
 */
public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("996", "965") + " --SensitiveFilter()前置处理";
        chain.doFilter(request, response, chain);
        response.str = response.str.replaceAll("~", "`") + " --SensitiveFilter()后置处理";
        return true;
    }
}
