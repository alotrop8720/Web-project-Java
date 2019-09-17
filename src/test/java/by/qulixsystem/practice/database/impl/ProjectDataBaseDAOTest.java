package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.models.Project;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ProjectDataBaseDAOTest {
    private static Logger logger = Logger.getLogger(DataBaseConfiguration.class.getName());
    DataBaseConfiguration connect;
    Project project;

    @Before
    public void init(){
        connect = DataBaseConfiguration.getInstance();
        project = new Project();
        project.setTitle("test");
        project.setAbbreviate("test");
        project.setInformation("test");
    }

    @Test
    public void createData() {
        assertTrue(new ProjectDataBaseDAO(connect).createData(project));
    }

    @Test
    public void updateData() {
        new ProjectDataBaseDAO(connect).createData(project);
        project.setId(new ProjectDataBaseDAO(connect).getID(project));
        Project test_project = new Project();
        test_project.setTitle("test1");
        test_project.setAbbreviate("test1");
        test_project.setInformation("test1");
        assertTrue(new ProjectDataBaseDAO(connect).updateData(project,test_project));
    }

    @Test
    public void deleteData() {
        new ProjectDataBaseDAO(connect).createData(project);
        project.setId(new ProjectDataBaseDAO(connect).getID(project));
        assertTrue(new ProjectDataBaseDAO(connect).deleteData(project));
    }
}