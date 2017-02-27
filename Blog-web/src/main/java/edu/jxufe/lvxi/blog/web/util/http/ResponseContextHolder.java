package edu.jxufe.lvxi.blog.web.util.http;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lvxi on 2017/2/18.
 */
public class ResponseContextHolder {
    private static final ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();
    public static void setResponse(HttpServletResponse response) {
        responseLocal.set(response);
    }
    public static HttpServletResponse getResponse() {
        return (HttpServletResponse)responseLocal.get();
    }
    public static void removeResponse(){
        responseLocal.remove();
    }
}
