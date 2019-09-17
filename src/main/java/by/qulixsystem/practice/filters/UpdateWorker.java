package by.qulixsystem.practice.filters;

import javax.servlet.*;
import java.io.IOException;

public class UpdateWorker implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setAttribute("id_worker", request.getParameter("id"));
        request.setAttribute("surname_worker", request.getParameter("surname"));
        request.setAttribute("name_worker", request.getParameter("name"));
        request.setAttribute("third_name_worker", request.getParameter("third_name"));
        request.setAttribute("post_worker", request.getParameter("post"));
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
