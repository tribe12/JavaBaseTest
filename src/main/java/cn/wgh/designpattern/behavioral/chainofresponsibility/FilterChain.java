package cn.wgh.designpattern.behavioral.chainofresponsibility;

import java.util.List;
import java.util.ArrayList;

/**
 * 过滤器链
 * <p>
 * Created by wgh on 2021/1/18.
 */
public class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }


    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size()) {
            return false;
        }

        Filter filter = filters.get(index);
        index++;

        return filter.doFilter(request, response, this);
    }
}
