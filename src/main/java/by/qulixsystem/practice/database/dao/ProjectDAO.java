package by.qulixsystem.practice.database.dao;

import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;

import java.util.List;

public interface ProjectDAO extends ItemDAO<Project>  {

    public List<Task> setListTaskByProgect(Project model);
}
