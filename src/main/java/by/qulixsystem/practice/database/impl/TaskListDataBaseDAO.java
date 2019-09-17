package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.dao.TaskListDAO;
import by.qulixsystem.practice.database.models.Task;
import by.qulixsystem.practice.database.models.TaskList;
import by.qulixsystem.practice.database.models.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class TaskListDataBaseDAO  extends ImplModel
        implements TaskListDAO{

    private static Logger logger = Logger.getLogger(ProjectDataBaseDAO.class.getName());
    public TaskListDataBaseDAO(DataBaseConfiguration baseConfiguration) {
        super(baseConfiguration);
    }


    @Override
    public boolean createData(TaskList model) {
        String query = String.format("INSERT INTO TaskList VALUES (default,'%d','%d')",
                model.getTask().getId(), model.getWorker().getId());
        try {
            getStatement().executeQuery(query);
            return true;
        }catch (SQLException ex)
        {
            logger.info("SQL request INSERT not RESOLVED");
            ex.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteData(TaskList model) {
        String query = String.format("DELETE FROM TaskList WHERE (id_task = %d) and (id_worker = %d)",
                model.getTask().getId(), model.getWorker().getId());
        try {
            getStatement().executeQuery(query);
            return true;
        }catch (SQLException ex)
        {
            logger.info("SQL reques DELETE t not RESOLVED");
            ex.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateData(TaskList old_model, TaskList new_Model) {
        String query = String.format("UPDATE TaskList SET " +
                " id_task = %d , id_worker = %d where id_taskList = %d",
                new_Model.getTask().getId(), new_Model.getWorker().getId(),
                old_model.getId());
        try {
            getStatement().executeQuery(query);
            return true;
        }catch (SQLException ex)
        {
            logger.info("SQL request UPDATE not RESOLVED");
            ex.getStackTrace();
            return false;
        }
    }

    @Override
    public List<TaskList> setListContent() {
       return null;
    }

    @Override
    public long getID(TaskList model) {
        String query = String.format("SELECT id_taskList FROM TaskList where " +
                "(id_task = %d) and (id_worker = %d)",
        model.getTask().getId(), model.getWorker().getId());

        try {
            ResultSet resultSet = getStatement().executeQuery(query);
            resultSet.next();
            return  resultSet.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<Worker> setListWorker(Task task) {
        String query = String.format("SELECT * FROM Worker WHERE id_task = %d", task.getId());
        try {
            return  WorkerDataBaseDAO.setList(getStatement().executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Task> setListTask(Worker worker) {
        String query = String.format("SELECT * FROM Task WHERE id_worker = %d", worker.getId());
        try {
            return  TaskDataBaseDAO.setList(getStatement().executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
