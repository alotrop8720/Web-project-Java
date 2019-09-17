package by.qulixsystem.practice.filters;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;

import javax.servlet.*;
import java.io.IOException;

public class UpdateProject implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setAttribute("title_project", request.getParameter("title"));
        request.setAttribute("abbreviated", request.getParameter("abbrev"));
        request.setAttribute("information", request.getParameter("inf"));
        request.setAttribute("old_project_id", request.getParameter("id"));

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
