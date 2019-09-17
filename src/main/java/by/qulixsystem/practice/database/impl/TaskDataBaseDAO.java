package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.TaskInner;
import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.dao.TaskDAO;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;
import by.qulixsystem.practice.database.models.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class TaskDataBaseDAO extends ImplModel
        implements TaskDAO {

    public TaskDataBaseDAO(DataBaseConfiguration baseConfiguration) {
        super(baseConfiguration);
    }
    private static Logger logger = Logger.getLogger(ProjectDataBaseDAO.class.getName());

    @Override
    public boolean createData(Task model) {
        String query = null;
        DateFormat outputFormst = new SimpleDateFormat("yyyy-MM-dd");
        try {
            query = String.format("INSERT INTO Task VALUES (default,'%s',%d,'%s','%s','%s',%d)",
                    model.getTitle(), model.getTime(),
                    outputFormst.format(outputFormst.parse(model.getStart())),
                    outputFormst.format(outputFormst.parse(model.getFinish())),
                    model.getStatus(), model.getProject().getId());
        } catch (ParseException e) {
            logger.info("Date write error");
            e.printStackTrace();
        }
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
    public boolean deleteData(Task model) {
        String query = String.format("DELETE FROM Task WHERE id_task = %d",
                model.getId());
        try {
            getStatement().executeQuery(query);
            return true;
        }catch (SQLException ex)
        {
            logger.info("SQL reques DELETE not RESOLVED");
            ex.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateData(Task old_model, Task new_Model) {
        String query = String.format("UPDATE Task SET " +
                        "name_task = '%s', " +
                        "time_task = '%s'," +
                        "date_start = '%s', " +
                        "date_finish = '%s', " +
                        "status_task = '%s'," +
                        "id_project = '%s' " +
                        "WHERE id_task = %d",
                new_Model.getTitle(), new_Model.getTime(),
                new_Model.getStart(), new_Model.getFinish(),
                new_Model.getStatus(), new_Model.getProject().getId(),
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
    public List<Task> setListContent() {
        String query = String.format("SELECT * FROM Task");
        try {
            return  setList(getStatement().executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getID(Task model) {
        String query = String.format("SELECT id_task FROM Task where " +
                        "(name_task = '%s') and " +
                        "(time_task = '%s') and " +
                        "(date_start = '%s') and " +
                        "(status_task = '%s') and " +
                        "(id_project = %d) ",
                model.getTitle(), model.getTime(), model.getStart(), model.getStatus(), model.getProject().getId());

        try {
            ResultSet resultSet = getStatement().executeQuery(query);
            resultSet.next();
            return  resultSet.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    static public List<Task> setList(ResultSet resultSet) {
        List<Task> listTask = null;
        try {
            listTask = new ArrayList<>();

            while (resultSet.next()) {
                Task tmpTask = new Task();
                tmpTask.setId(resultSet.getLong(1));
                tmpTask.setTitle(resultSet.getString(2));
                tmpTask.setTime(resultSet.getInt(3));
                tmpTask.setStart(resultSet.getString(4));
                tmpTask.setFinish(resultSet.getString(5));
                tmpTask.setStatus(resultSet.getString(6));
                Project x = new Project();
                x.setId(resultSet.getLong(7));
                tmpTask.setProject(x);
                listTask.add(tmpTask);
            }

            return  listTask;
        }catch (SQLException ex)
        {
            logger.info("SQL reques SELECT Task not RESOLVED");
            ex.getStackTrace();
        }
        return  listTask;
    }

    @Override
    public List<TaskInner> setListContentInner() {
        String query = String.format("select t.id_task, t.name_task, t.time_task, t.date_start, t.date_finish, t.status_task, " +
                " t.id_project, p.name_project , w.id_worker, w.surname_worker " +
                " from Task as t " +
                " inner join Project as p on t.id_project = p.id_project " +
                "  inner join TaskList as tl on t.id_task = tl.id_task " +
                "  inner join Worker as w on tl.id_worker = w.id_worker ");

        List<TaskInner> listTaskInner = null;
        try {
            ResultSet resultSet =  getStatement().executeQuery(query);
            listTaskInner = new ArrayList<>();

            while (resultSet.next()) {
                TaskInner tmpTask = new TaskInner();
                Task task = new Task();
                Project project = new Project();
                Worker worker = new Worker();

                task.setId(resultSet.getLong(1));
                task.setTitle(resultSet.getString(2));
                task.setTime(resultSet.getInt(3));
                try {
                    task.setStart(new SimpleDateFormat("yyyy-mm-dd")
                            .format(new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss")
                            .parse(resultSet.getString(4))));
                    task.setFinish(new SimpleDateFormat("yyyy-mm-dd")
                            .format(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss")
                                    .parse(resultSet.getString(5))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                task.setStatus(resultSet.getString(6));
                project.setId(resultSet.getLong(7));
                project.setTitle(resultSet.getString(8));
                task.setProject(project);
                worker.setId(resultSet.getLong(9));
                worker.setSurname(resultSet.getString(10));
                tmpTask.setTask(task);
                tmpTask.setWorker(worker);
                listTaskInner.add(tmpTask);
            }

            return  listTaskInner;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
