package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class TaskDataBaseDAOTest {
    private static Logger logger = Logger.getLogger(DataBaseConfiguration.class.getName());
    DataBaseConfiguration connect;
    Task task;

    @Before
    public void init(){
        connect = DataBaseConfiguration.getInstance();
        task = new Task();
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
    }

    @Test
    public void createData() {
        assertTrue(new TaskDataBaseDAO(connect).createData(task));
    }

    @Test
    public void updateData() {
        new TaskDataBaseDAO(connect).createData(task);
        task.setId(new TaskDataBaseDAO(connect).getID(task));
        Task task_test = new Task();
        task_test.setTitle("test");
        task_test.setTime(0);
        task_test.setStart("2000-12-12");
        task_test.setFinish("2000-12-12");
        task_test.setStatus("test");

        Project project = new Project();
        project.setTitle("test");
        project.setAbbreviate("test");
        project.setInformation("test");
        new ProjectDataBaseDAO(connect).createData(project);
        project.setId(new ProjectDataBaseDAO(connect).getID(project));
        task_test.setProject(project);

        assertTrue(new TaskDataBaseDAO(connect).updateData(task,task_test));
    }

    @Test
    public void deleteData() {
        new TaskDataBaseDAO(connect).createData(task);
        task.setId(new TaskDataBaseDAO(connect).getID(task));
        assertTrue(new TaskDataBaseDAO(connect).deleteData(task));
    }


}