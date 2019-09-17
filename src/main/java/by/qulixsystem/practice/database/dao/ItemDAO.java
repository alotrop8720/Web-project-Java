package by.qulixsystem.practice.database.dao;

import by.qulixsystem.practice.database.models.Model;

import java.util.List;

public interface ItemDAO<T extends Model> {

    public boolean createData(T model);

    public boolean deleteData(T model);

    public boolean updateData(T old_model, T new_Model);

    public List<T> setListContent();

    public long getID(T model);



}
