package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Pushkarev
 * @since 21.03.2021
 * @version 2.2
 * В классе в проекте я сделал контейнер для обьектов
 * @param <T>
 */
public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    /**
     * метод добавляет элемент
     * @param model - принимает модель
     */
    @Override
    public void add(T model) {
        mem.add(model);
    }

    /**
     * Метод меняет элемент.
     * @param id - текущий элемент
     * @param model - новый
     * @return - возвращаем результат
     */
    @Override
    public boolean replace(String id, T model) {
        boolean b = false;
        int i = indexOf(id);
        if (i != -1) {
            mem.set(i, model);
            b = true;
        }
        return b;
    }

    /**
     * метод удаляет элемент
     * @param id - принимает элемент
     * @return - возвращает результат
     */
    @Override
    public boolean delete(String id) {
        boolean b = false;
        int i = indexOf(id);
        if (i != -1) {
            mem.remove(i);
            b = true;
        }
        return b;
    }

    /**
     * Метод возвращает элемент
     * @param id - принимает элемент
     * @return - возвращает результат
     */
    @Override
    public T findById(String id) {
        T rsl = null;
        for (T t : mem) {
            if (id.equals(t.getId())) {
                rsl = t;
            }
        }
        return rsl;
    }

    /**
     * Метод проходит по элементам сравнивает их возвращает результат, нужен для исключения копипаста
     * @param id - принимает элемент
     * @return - возвращает результат
     */
    private int indexOf(String id) {
        int j = 0;
        for (int i = 0; i < mem.size(); i++) {
            if (id.equals(mem.get(i).getId())) {
                j = i;

            }
        }
        return j;
    }
}
