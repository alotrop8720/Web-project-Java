package by.qulixsystem.practice.filters;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.WorkerDataBaseDAO;
import by.qulixsystem.practice.database.models.Worker;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class ContextWorker implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        List<Worker> workers = new WorkerDataBaseDAO(DataBaseConfiguration.getInstance()).setListContent();
        request.setAttribute("listWorker", workers);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
