package by.qulixsystem.practice.servlets;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateProjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Project old = new Project();
        old.setId(Long.valueOf(request.getParameter("id")));

        ProjectDataBaseDAO projectDataBaseDAO = new ProjectDataBaseDAO(DataBaseConfiguration.getInstance());
        Project project = new Project();
        project.setTitle(request.getParameter("title_project_imp"));
        project.setAbbreviate(request.getParameter("abbreviated_imp"));
        project.setInformation(request.getParameter("information_imp"));

        projectDataBaseDAO.updateData(old, project);
        request.setAttribute("listProject", projectDataBaseDAO.setListContent());
        request.getRequestDispatcher("/pages/projects.jsp").forward(request,response);
    }
}
