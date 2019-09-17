package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Worker;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class WorkerDataBaseDAOTest {

    private static Logger logger = Logger.getLogger(DataBaseConfiguration.class.getName());
    DataBaseConfiguration connect;
    Worker worker;

    @Before
    public void init(){
        connect = DataBaseConfiguration.getInstance();
        worker = new Worker();
        worker.setSurname("test");
        worker.setName("test");
        worker.setThrid_name("test");
        worker.setPost("test");
    }

    @Test
    public void createData() {
        assertTrue(new WorkerDataBaseDAO(connect).createData(worker));
    }

    @Test
    public void updateData() {
        new WorkerDataBaseDAO(connect).createData(worker);
        worker.setId(new WorkerDataBaseDAO(connect).getID(worker));
        Worker test_worker = new Worker();
        test_worker.setSurname("test1");
        test_worker.setName("test1");
        test_worker.setThrid_name("test1");
        test_worker.setPost("test1");
        assertTrue(new WorkerDataBaseDAO(connect).updateData(worker,test_worker));
    }

    @Test
    public void deleteData() {
        new WorkerDataBaseDAO(connect).createData(worker);
        worker.setId(new WorkerDataBaseDAO(connect).getID(worker));
        assertTrue(new WorkerDataBaseDAO(connect).deleteData(worker));
    }
}