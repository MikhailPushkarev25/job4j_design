package ru.job4j.collection;

import java.util.*;
import java.util.List;

/**
 * @author Milhail Pushkarev
 * @since 01.04.2021
 * @version 2.2
 * В классе произведен анализ изменений за время O(n)
 */
public class Analise {
    /**
     * Для начала я создаю обьект класса Info,
     * создаю мапу
     * пробегаюсь по циклу существующих элементов
     * добавляю их в мапу
     * далее пробегаюсь по циклу в котором происходят изменения
     * в условии проверяю id нет - тогда добавляю
     * если имя и id не равны то произошли изменения
     * далее удаляю элемент из мапы и добавляю его в переменную delete по id
     * возвращаю информацию
     * @param previous - имеющийся элемент
     * @param current - измененный элемент
     * @return - вернуть результат
     */
    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> map = new HashMap<>();

        for (User users : previous) {
            map.put(users.getId(), users.getName());
        }
        for (User user : current) {
            if (map.get(user.getId()) == null) {
                info.added++;
            } else if (!user.getName().equals(map.get(user.getId()))) {
                info.changed++;
            }
            map.remove(user.getId());
        }

        info.deleted = map.size();
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static class Info {

        private int added;
        private int changed;
        private int deleted;

        @Override
        public String toString() {
            return "Info{" + "added=" + added + ", changed=" + changed + ", deleted=" + deleted + '}';
        }
    }
}
