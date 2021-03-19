package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mikhail Pushkarev
 * @since 19.03.2021
 * @version 2.2
 */
public class EventIt implements Iterator<Integer> {

    private final int[] data;
    private int count = 0;

    public EventIt(final int[] data) {
        this.data = data;
    }

    /**
     * в методе я создал цикл, проходим по массиву и в условии указываем
     * деления значения на два для поиска целых чисел. присваиваем в переменную count
     * @return - возыращаем логический результат
     */
    @Override
    public boolean hasNext() {
        boolean b = false;
        for (int i = count; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                b = true;
                count = i;
                break;
            }
        }
       return b;
    }

    /**
     * Метод возвращает масив целых чисел.
     * @return
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[count++];
    }
}
