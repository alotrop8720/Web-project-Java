package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.dao.WorkerDAO;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WorkerDataBaseDAO  extends ImplModel
        implements WorkerDAO {

    private static Logger logger = Logger.getLogger(ProjectDataBaseDAO.class.getName());
    public WorkerDataBaseDAO(DataBaseConfiguration baseConfiguration) {
        super(baseConfiguration);
    }


    @Override
    public boolean createData(Worker model) {
        String query = String.format("INSERT INTO Worker VALUES (default,'%s','%s','%s','%s')",
                model.getSurname(), model.getName(), model.getThrid_name(), model.getPost());
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
    public boolean deleteData(Worker model) {
        String query = String.format("DELETE FROM Worker WHERE id_worker = %d",
                model.getId());
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
    public boolean updateData(Worker old_model, Worker new_Model) {
        String query = String.format("UPDATE Worker SET " +
                        "surname_worker = '%s', " +
                        "name_worker = '%s'," +
                        "thrid_name_worker = '%s', " +
                        "post_worker = '%s' " +
                        "WHERE id_worker = %d",
                new_Model.getSurname(), new_Model.getName(),
                new_Model.getThrid_name(), new_Model.getPost(),old_model.getId());
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
    public List<Worker> setListContent() {
        String query = String.format("SELECT * FROM Worker");
        try {
            return  setList(getStatement().executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getID(Worker model) {
        String query = String.format("SELECT id_worker FROM Worker where " +
                "('%s' = surname_worker) and " +
                "('%s' = name_worker)", model.getSurname(), model.getName());

        try {
            ResultSet resultSet = getStatement().executeQuery(query);
            resultSet.next();
            return  resultSet.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    static public List<Worker> setList(ResultSet resultSet) {
        List<Worker> listWorker = null;
        try {
            listWorker = new ArrayList<>();

            while (resultSet.next()) {
                Worker tmpWorker = new Worker();
                tmpWorker.setId(resultSet.getLong(1));
                tmpWorker.setSurname(resultSet.getString(2));
                tmpWorker.setName(resultSet.getString(3));
                tmpWorker.setThrid_name(resultSet.getString(4));
                tmpWorker.setPost(resultSet.getString(5));
                listWorker.add(tmpWorker);
            }
            return  listWorker;
        }catch (SQLException ex)
        {
            logger.info("SQL request SELECT not RESOLVED");
            ex.getStackTrace();
        }
        return listWorker;
    }
}
