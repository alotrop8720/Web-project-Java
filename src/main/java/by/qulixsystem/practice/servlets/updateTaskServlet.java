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

public class updateTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task old = new Task();
        old.setId(Long.valueOf(request.getParameter("id")));

        TaskDataBaseDAO taskDataBaseDAO = new TaskDataBaseDAO(DataBaseConfiguration.getInstance());
        Task task = new Task();
        task.setTitle(request.getParameter("title"));
        task.setTime(Integer.valueOf(request.getParameter("time")));
        task.setStart(request.getParameter("start"));
        task.setFinish(request.getParameter("finish"));
        task.setStatus(request.getParameter("status"));
        Project project = new Project();
        if (request.getParameter("project").split(" ").length == 1){
            project.setId(Long.valueOf(request.getParameter("id_p")));
        } else {
            project.setTitle(request.getParameter("project").split(" ")[0]);
            project.setAbbreviate(request.getParameter("project").split(" ")[1]);
            project.setId(new ProjectDataBaseDAO(DataBaseConfiguration.getInstance()).getID(project));
        }
        task.setProject(project);
        taskDataBaseDAO.updateData(old, task);

        Worker worker = new Worker();
        if (request.getParameter("worker").split(" ").length == 1){
            worker.setId(Long.valueOf(request.getParameter("id_w")));
        } else {
            worker.setSurname(request.getParameter("worker").split(" ")[0]);
            worker.setName(request.getParameter("worker").split(" ")[1]);
            worker.setId(new WorkerDataBaseDAO(DataBaseConfiguration.getInstance()).getID(worker));
        }

        TaskList old_taskList = new TaskList();
        Worker w = new Worker();
        w.setId(Long.valueOf(request.getParameter("id_w")));
        old_taskList.setWorker(w);
        old_taskList.setTask(old);
        TaskListDataBaseDAO taskListDataBaseDAO = new TaskListDataBaseDAO(DataBaseConfiguration.getInstance());
        old_taskList.setId(taskListDataBaseDAO.getID(old_taskList));

        task.setId(old.getId());

        TaskList taskList = new TaskList();
        taskList.setTask(task);
        taskList.setWorker(worker);
        taskListDataBaseDAO.updateData(old_taskList, taskList);

        request.setAttribute("listTask", taskDataBaseDAO.setListContentInner());
        request.getRequestDispatcher("/pages/tasks.jsp?1").forward(request,response);
    }
}
