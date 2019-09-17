package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;
import by.qulixsystem.practice.database.dao.ProjectDAO;
import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProjectDataBaseDAO extends ImplModel
        implements ProjectDAO{

    private static Logger logger = Logger.getLogger(ProjectDataBaseDAO.class.getName());

    public ProjectDataBaseDAO(DataBaseConfiguration baseConfiguration) {
        super(baseConfiguration);
    }

    @Override
    public boolean createData(Project model) {

        String query = String.format("INSERT INTO Project VALUES (default,'%s','%s','%s')",
                model.getTitle(), model.getAbbreviate(), model.getInformation());
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
    public boolean deleteData(Project model) {
        String query = String.format("DELETE FROM Project WHERE id_project = %d",
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
    public boolean updateData(Project old_model, Project new_Model) {
        String query = String.format("UPDATE Project SET " +
                        "name_project = '%s', " +
                        "abbreviate_project = '%s'," +
                        "information = '%s' " +
                        "WHERE id_project = %d",
                new_Model.getTitle(), new_Model.getAbbreviate(),
                new_Model.getInformation(), old_model.getId());
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
    public List<Project> setListContent() {
        String query = String.format("SELECT * FROM Project");
        try {
            return  setList(getStatement().executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getID(Project model) {
        String query = String.format("SELECT id_project FROM Project where " +
                "('%s' = name_project) and " +
                "('%s' = abbreviate_project)", model.getTitle(), model.getAbbreviate());

        try {
            ResultSet resultSet = getStatement().executeQuery(query);
            resultSet.next();
            return  resultSet.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    static public List<Project> setList(ResultSet resultSet) {
        List<Project> listProject = null;
        try {
            listProject = new ArrayList<>();


            while (resultSet.next()){
                Project tmpProject = new Project();
                tmpProject.setId(resultSet.getLong(1));
                tmpProject.setTitle(resultSet.getString(2));
                tmpProject.setAbbreviate(resultSet.getString(3));
                tmpProject.setInformation(resultSet.getString(4));
                listProject.add(tmpProject);
            }

            return  listProject;
        }catch (SQLException ex)
        {
            logger.info("SQL request SELECT not RESOLVED");
            ex.getStackTrace();
        }
        return listProject;
    }

    @Override
    public List<Task> setListTaskByProgect(Project model) {
        String query = String.format("SELECT * FROM Task WHERE id_project = %d",
                model.getId());
        try {
            return  TaskDataBaseDAO.setList(getStatement().executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
