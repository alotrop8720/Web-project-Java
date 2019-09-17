package by.qulixsystem.practice.filters;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.impl.WorkerDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Worker;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class AddTask implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        List<Worker> listWorker = new WorkerDataBaseDAO(DataBaseConfiguration.getInstance()).setListContent();
        List<Project> listProject = new ProjectDataBaseDAO(DataBaseConfiguration.getInstance()).setListContent();
        request.setAttribute("listWorker", listWorker);
        request.setAttribute("listProject", listProject);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
