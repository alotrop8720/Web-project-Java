package by.qulixsystem.practice.servlets;

import by.qulixsystem.practice.TaskInner;
import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.impl.ProjectDataBaseDAO;
import by.qulixsystem.practice.database.impl.TaskDataBaseDAO;
import by.qulixsystem.practice.database.impl.TaskListDataBaseDAO;
import by.qulixsystem.practice.database.impl.WorkerDataBaseDAO;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;
import by.qulixsystem.practice.database.models.TaskList;
import by.qulixsystem.practice.database.models.Worker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class addTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDataBaseDAO taskDataBaseDAO = new TaskDataBaseDAO(DataBaseConfiguration.getInstance());
        Task task = new Task();
        task.setTitle(request.getParameter("title"));
        task.setTime(Integer.valueOf(request.getParameter("time")));
        task.setStart(request.getParameter("start"));
        task.setFinish(request.getParameter("finish"));
        task.setStatus(request.getParameter("status"));


        Project project = new Project();
        project.setTitle(request.getParameter("project").split(" ")[0]);
        project.setAbbreviate(request.getParameter("project").split(" ")[1]);
        project.setId(new ProjectDataBaseDAO(DataBaseConfiguration.getInstance()).getID(project));
        task.setProject(project);
        taskDataBaseDAO.createData(task);

        TaskList taskList = new TaskList();

        Worker worker = new Worker();
        worker.setSurname(request.getParameter("worker").split(" ")[0]);
        worker.setName(request.getParameter("worker").split(" ")[1]);
        worker.setId(new WorkerDataBaseDAO(DataBaseConfiguration.getInstance()).getID(worker));

        task.setId(taskDataBaseDAO.getID(task));
        taskList.setTask(task);
        taskList.setWorker(worker);
        new TaskListDataBaseDAO(DataBaseConfiguration.getInstance()).createData(taskList);

        request.setAttribute("listTask", taskDataBaseDAO.setListContentInner());
        request.getRequestDispatcher("/pages/tasks.jsp").forward(request,response);
    }
}
