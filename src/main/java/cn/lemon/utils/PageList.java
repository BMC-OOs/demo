package cn.lemon.utils;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-02 14:31
 */
public class PageList {
    /**
     * 利用subList方法进行分页
     * @param list 分页数据
     * @param pagesize  页面大小
     * @param currentPage   当前页面
     */
    public static List<?> pageBySubList(List list, int pagesize, int currentPage) {
        int totalcount = list.size();
        int pagecount = 0;
        List<?> subList;
        int m = totalcount % pagesize;
        if (m > 0) {
            pagecount = totalcount / pagesize + 1;
        } else {
            pagecount = totalcount / pagesize;
        }
        if (m == 0) {
            subList = list.subList((currentPage - 1) * pagesize, pagesize * (currentPage));
        } else {
            if (currentPage == pagecount) {
                subList = list.subList((currentPage - 1) * pagesize, totalcount);
            } else {
                subList = list.subList((currentPage - 1) * pagesize, pagesize * (currentPage));
            }
        }
        return subList;
    }

}
