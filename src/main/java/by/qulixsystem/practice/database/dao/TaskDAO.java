package by.qulixsystem.practice.database.dao;

import by.qulixsystem.practice.TaskInner;
import by.qulixsystem.practice.database.models.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TaskDAO extends ItemDAO<Task>  {

    public List<TaskInner> setListContentInner();
}
