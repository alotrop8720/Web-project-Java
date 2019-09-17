package by.qulixsystem.practice.filters;

import by.qulixsystem.practice.TaskInner;
import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.impl.TaskDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;

import javax.servlet.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

public class ContextTask implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        List<TaskInner> tasks = new TaskDataBaseDAO(DataBaseConfiguration.getInstance()).setListContentInner();
        request.setAttribute("listTask", tasks);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
