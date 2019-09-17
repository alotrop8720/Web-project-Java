package by.qulixsystem.practice;

import by.qulixsystem.practice.database.models.Project;
import by.qulixsystem.practice.database.models.Task;
import by.qulixsystem.practice.database.models.Worker;


/**
 * Класс модели для красивого отображения таблицы TASK.
 */
public class TaskInner {
    Task task;
    Worker worker;


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }


}
