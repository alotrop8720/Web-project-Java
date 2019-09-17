package by.qulixsystem.practice.database;

import org.apache.commons.io.IOUtils;
import org.hsqldb.jdbcDriver;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public final class DataBaseConfiguration {
    private static Logger logger = Logger.getLogger(DataBaseConfiguration.class.getName());

    private static volatile DataBaseConfiguration instance;
    private Connection connect;
    private List<String> arrSQLcommands;

    public Connection getConnect() {
        return connect;
    }


    public static DataBaseConfiguration getInstance() {
        if (instance == null) {
            synchronized (DataBaseConfiguration.class){
                if (instance == null)
                    instance = new DataBaseConfiguration();
            }
        }
        return instance;
    }

    private DataBaseConfiguration() {
        String sep = System.getProperty("file.separator");

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("commandsSQL.sql");
        String content = "";
        try {
            content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.arrSQLcommands = Arrays.asList(content.split("\\n"));
        createConnect();
    }
    private void createConnect(){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException ex){
            logger.info("not found jdbcDriver");
            ex.getStackTrace();
        }

        try {
            String sep = System.getProperty("file.separator");
            String pathScript = System.getProperty("user.home")+ sep + "Database" + sep + "script";

            connect = DriverManager.getConnection(
                    "jdbc:hsqldb:file:" + pathScript + ";hsqldb.lock_file=false",
                    "admin", "admin");

            setDataBaseContent();

        } catch (SQLException e) {
            logger.info("Not connect");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Выполняет команды из скрипта. Добовляет таблицы и записи.
     */
    private void setDataBaseContent(){

        Statement statement;
            try{
                statement = connect.createStatement();
                for (String command: arrSQLcommands) {
                    statement.executeUpdate(command);
                }
                statement.close();
            }catch (SQLException e){
                logger.info("sql error");
            }// если таблица уже существует
    }
}
