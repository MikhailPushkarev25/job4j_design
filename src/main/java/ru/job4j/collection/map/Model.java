package ru.job4j.collection.map;

import java.util.Objects;

/**
 * @author Mikhail Pushkarev
 * @since 30.03.2021
 * @version 2.2
 * В классе я демонстрирую работу метода hashCode
 * плюс описание внизу
 */
public class Model {
    private String name;
    private int age;

    public Model(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Model model = (Model) o;
        return age == model.age && Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    /**
     * Источником ошибок является то что нет распределения метода hashcode, где переопределен метод
     *
     * equals там должен быть переопределен метод hashcode. Иначе это приведет к исключению и не позволит работать в сочетании с коллекциями.
     *
     * Хорошая хэш функция для не равных объектов стремится генерировать различные хэш коды.
     *
     * 1 - Присвойте пременной тип int ненулевое значение 17.
     *
     * 2 - для каждого значимого поля f в вашем объекте выполним  следующее
     *
     * вычислите для этого поля хэшкод тип int
     *
     * если тип boolean то (f ? 1 : 0)
     *
     * если поле имеет тип byte, char, short то выполнить (int)f
     *
     * если поле имеет тип Long то выполнить (int)(f^(f>>>32))
     *
     * если поле имеет тип float выполнить floatToIntBits
     *
     * если double то doubleToLongBits(f)
     *
     * затем преобразовать полученное значение
     *
     * если поле является ссылкой на объект а eqauls сравнивает это поле рекурсивно вызывая другие методы так же нужно рекурсивно вызывать метод hashcode
     *
     * если поле является массивом то обрабатывать его элемент как отдельным полем
     *
     * объедините хэшкод вычисляющий на этапе с текущим значением поля
     *
     * result = 31 * result + c
     *
     * вернуть значение result
     */
}
