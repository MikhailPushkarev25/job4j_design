package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mikhail Pushkarev
 * @since 18.03.2021
 * @version 2.2
 *
 * В классе реализован итератор
 * прохождение по двумерному массиву
 */
public class MatrixIt implements Iterator<Integer> {

    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * в методе создан цикл while
     * в условии я проверяю что указатель меньше массива и указатель больше или равно длины массива
     * далее я итерирую row++
     * @return возвращаю если указатель меньше массива
     */
    @Override
    public boolean hasNext() {
        while (row < data.length - 1 && column >= data[row].length) {
            row++;
            column = 0;
        }
        return column < data[row].length;
    }

    /**
     * в методе я проверяю в условии на нул, иначе падает исключение
     * @return - возвращаю массив по которому проходит итератор по элементно.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
