package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mikhail Pushkarev
 * @since 18.03.2021
 * @version 2.2
 *
 * В классе я сделал итератор обратного перебора элементов
 */
public class BackwardArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int count = 0;

    /**
     * В конструкторе я записал в переменную длину массива
     * @param data - принимает массив
     */
    public BackwardArrayIt(int[] data) {
        this.data = data;
        count = data.length - 1;
    }

    /**
     * в условии метода я указал что переменная больше нуля для обратного порядка
     * @return - вернуть результат
     */
    @Override
    public boolean hasNext() {
        return count >= 0;
    }

    /**
     * В методе я указал в массиве data обратный порядок с помощью оператора --
     * @return - вернуть результат
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[count--];
    }
}
