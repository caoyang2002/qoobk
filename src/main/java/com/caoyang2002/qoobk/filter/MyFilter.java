package com.caoyang2002.qoobk.filter;

import com.caoyang2002.qoobk.pojo.vo.UserVO;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter", urlPatterns = {"/admin.html","/insertProduct.html"}) // 必须以 / 开头, 如果书写错误会导致工程无法启动
public class MyFilter implements Filter {
    // 过滤器初始化方法
    public void init(FilterConfig config) throws ServletException {
    }
    // 过滤器销毁方法
    public void destroy() {
    }

    @Override // 当请求经过过滤器执行的方法
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 创建session对象
        HttpServletRequest rt = (HttpServletRequest) request;
        HttpServletResponse re = (HttpServletResponse) response;
        // 从请求对象中获取session
        HttpSession session = rt.getSession();
        // 获取session中的用户对象
        UserVO user = (UserVO) session.getAttribute("user");
        if (user!=null){
            chain.doFilter(request, response);// 放行
        }else {
            re.sendRedirect("/login.html");// 重定向
        }

    }
}
