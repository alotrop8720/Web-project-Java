package by.qulixsystem.practice.servlets;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.impl.TaskDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = new Task();
        task.setId(Long.valueOf(request.getParameter("id")));
        TaskDataBaseDAO taskDataBaseDAO = new TaskDataBaseDAO(DataBaseConfiguration.getInstance());
        taskDataBaseDAO.deleteData(task);
        request.setAttribute("listTask", taskDataBaseDAO.setListContentInner());
        request.getRequestDispatcher("/pages/tasks.jsp").forward(request,response);
    }
}
