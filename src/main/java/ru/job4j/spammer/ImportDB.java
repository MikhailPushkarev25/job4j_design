package ru.job4j.spammer;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(line -> {
                String[] str = line.split(";");
                if (str.length == 2) {
                    users.add(new User(str[0], str[1]));
                }
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into users(name, mail) values (?, ?) ")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.mail);
                    ps.execute();
                }
            }
        }
    }


    private static class User {
        String name;
        String mail;

        public User(String name, String mail) {
            this.name = name;
            this.mail = mail;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        ClassLoader loader = ImportDB.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./dump.txt");
        db.save(db.load());
    }
}
