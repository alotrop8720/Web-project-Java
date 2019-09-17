package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;
import by.qulixsystem.practice.database.models.TaskList;
import by.qulixsystem.practice.database.models.Worker;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class TaskListDataBaseDAOTest {

    private static Logger logger = Logger.getLogger(DataBaseConfiguration.class.getName());
    DataBaseConfiguration connect;
    TaskList task_list;

    @Before
    public void init(){
        connect = DataBaseConfiguration.getInstance();
        task_list = new TaskList();

        Worker worker = new Worker();
        worker.setSurname("test");
        worker.setName("test");
        worker.setThrid_name("test");
        worker.setPost("test");
        new WorkerDataBaseDAO(connect).createData(worker);
        worker.setId(new WorkerDataBaseDAO(connect).getID(worker));

        Task task = new Task();
        task.setTitle("test");
        task.setTime(0);
        task.setStart("2000-12-12");
        task.setFinish("2000-12-12");
        task.setStatus("test");


        Project project = new Project();
        project.setTitle("test");
        project.setAbbreviate("test");
        project.setInformation("test");
        new ProjectDataBaseDAO(connect).createData(project);
        project.setId(new ProjectDataBaseDAO(connect).getID(project));
        task.setProject(project);

        new TaskDataBaseDAO(connect).createData(task);
        task.setId(new TaskDataBaseDAO(connect).getID(task));

        task_list.setTask(task);
        task_list.setWorker(worker);
    }

    @Test
    public void checkPraceList() {
        assertTrue(new TaskListDataBaseDAO(connect).createData(task_list));
    }


    @Test
    public void createModel() {
        new TaskListDataBaseDAO(connect).createData(task_list);
        task_list.setId(new TaskListDataBaseDAO(connect).getID(task_list));
        assertTrue(new TaskListDataBaseDAO(connect).createData(task_list));
    }
}