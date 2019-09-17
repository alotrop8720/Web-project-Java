package by.qulixsystem.practice.servlets;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.WorkerDataBaseDAO;
import by.qulixsystem.practice.database.models.Worker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteWorkerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Worker worker = new Worker();
        worker.setId(Long.valueOf(request.getParameter("id")));
        WorkerDataBaseDAO workerDataBaseDAO = new WorkerDataBaseDAO(DataBaseConfiguration.getInstance());
        workerDataBaseDAO.deleteData(worker);
        request.setAttribute("listWorker", workerDataBaseDAO.setListContent());
        request.getRequestDispatcher("/pages/workers.jsp").forward(request,response);
    }

}
