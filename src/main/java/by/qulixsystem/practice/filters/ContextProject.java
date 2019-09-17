package by.qulixsystem.practice.filters;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class ContextProject implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        List<Project> projects = new ProjectDataBaseDAO(DataBaseConfiguration.getInstance()).setListContent();
        request.setAttribute("listProject", projects);
        request.setAttribute("govno", "govno");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
