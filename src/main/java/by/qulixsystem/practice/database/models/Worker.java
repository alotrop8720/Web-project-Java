package by.qulixsystem.practice.database.models;


//create table Worker(
//        id_worker int key auto_increment,
//        surname_worker varchar(30),
//        name_worker varchar(30),
//        thrid_name_worker varchar(30),
//        post_worker varchar(30));

public class Worker extends Model {
    String surname;
    String name;
    String thrid_name;
    String post;

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getThrid_name() {
        return thrid_name;
    }
    public void setThrid_name(String thrid_name) {
        this.thrid_name = thrid_name;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public Worker() {
        super();
    }

    public Worker(Long id) {
        super(id);
    }
}
