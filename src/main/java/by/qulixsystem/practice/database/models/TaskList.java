package by.qulixsystem.practice.database.models;

public class TaskList extends Model {

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

    public TaskList() {
        super();
    }
    public TaskList(Long id) {
        super(id);
    }

}
