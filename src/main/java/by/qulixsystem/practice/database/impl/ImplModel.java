package by.qulixsystem.practice.database.impl;

import by.qulixsystem.practice.database.DataBaseConfiguration;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ImplModel {
    private DataBaseConfiguration baseConfiguration;
    private Statement statement;

    public Statement getStatement() {
        return statement;
    }



    public DataBaseConfiguration getBaseConfiguration() {
        return baseConfiguration;
    }

    public ImplModel(DataBaseConfiguration baseConfiguration) {
        this.baseConfiguration = baseConfiguration;
        try {
            statement = getBaseConfiguration().getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
