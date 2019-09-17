package by.qulixsystem.practice.filters;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.impl.WorkerDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Worker;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class UpdateTask implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("title", request.getParameter("title"));
        request.setAttribute("time", request.getParameter("time"));
        request.setAttribute("start_1", request.getParameter("start"));
        request.setAttribute("finish", request.getParameter("finish"));
        request.setAttribute("status", request.getParameter("status"));
        request.setAttribute("id_w", request.getParameter("id_w"));
        request.setAttribute("surname", request.getParameter("surname"));
        request.setAttribute("id_p", request.getParameter("id_p"));
        request.setAttribute("title_p", request.getParameter("title_p"));
        request.setAttribute("listWorker", new WorkerDataBaseDAO(DataBaseConfiguration.getInstance()).setListContent());
        request.setAttribute("listProject", new ProjectDataBaseDAO(DataBaseConfiguration.getInstance()).setListContent());
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
