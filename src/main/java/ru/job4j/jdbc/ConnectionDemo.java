package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mikhail Pushkarev
 * @since 17.04.2021
 * @version 2.2
 * В плагин я добави зависимость так называемый драйвер который позволяет работать с Базой данных
 * PostgresSQL.
 * далее регистрирую драйвер в системе
 * далее подключение- для этго нужны логин, пароль и URL
 * в классе также я привожу пример как нужно правильно читать из файла эти логин, пароль и url
 * для это я использовал ClassLoader, он удобен тем что если  другой разработчик будет использовать этот
 * код то он без проблем найдет этот файл.
 */
public class ConnectionDemo {
    private final Properties prs = new Properties();

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        ConnectionDemo demo = new ConnectionDemo();
        ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            demo.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
