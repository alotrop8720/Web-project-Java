package by.qulixsystem.practice.database.dao;

import by.qulixsystem.practice.database.models.Task;
import by.qulixsystem.practice.database.models.TaskList;
import by.qulixsystem.practice.database.models.Worker;

import java.util.List;

public interface TaskListDAO extends ItemDAO<TaskList> {

    public List<Worker> setListWorker(Task task);

    public List<Task> setListTask(Worker worker);
}
