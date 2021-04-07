package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikhail Pushkarev
 * @since 07.04.2021
 * @version 2.2
 *  Класс принимает массив параметров и разбивает их на пары ключ значение
 */
public class ArgsName {
    
    private final Map<String, String> values = new HashMap<>();

    /**
     * Метод возвращает ключ мапы
     * @param key - принимает ключ
     * @return - вернуть результат
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * Мктод проверяет есть ли ключ значение в мапе
     * далее проходимся в цикле создаем массив и спомощью сплит делим строку и записываем в него
     * далее проверяю что в мапе есть ключ но нет значения или наоборот тогда падает исключение
     * далее записываю в перменную массив от нулевого значения до одного с помощью сабстринг
     * во вторую переменную массив с 1 элементом  - это значение
     * и добваляю обе переменные в мапу.
     * @param args
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Error");
        }
        for (String str : args) {
            String[] s = str.split("=");
            if (s.length < 2) {
                throw new IllegalArgumentException("Error");
            }
            String key = s[0].substring(1);
            String value = s[1];
            values.put(key, value);
        }
    }

    /**
     * метод принимает массив
     * создаю обьект
     * записываю результат метода parse c аргументом
     * и возвращаю
     * @param args
     * @return
     */
    public static ArgsName of(String[] args) {
        ArgsName argsName = new ArgsName();
        argsName.parse(args);
        return argsName;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName out = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(out.get("out"));
    }
}
