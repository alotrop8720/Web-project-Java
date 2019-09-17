package by.qulixsystem.practice.servlets;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteProjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Project project = new Project();
        project.setId(Long.valueOf(request.getParameter("id")));
        ProjectDataBaseDAO projectDataBaseDAO = new ProjectDataBaseDAO(DataBaseConfiguration.getInstance());
        projectDataBaseDAO.deleteData(project);
        request.setAttribute("listProject", projectDataBaseDAO.setListContent());
        request.getRequestDispatcher("/pages/projects.jsp").forward(request,response);
    }

}
