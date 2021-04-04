package ru.job4j.io;

import java.io.*;

/**
 * @author Mikhail Pushkarev
 * @since 04.04.2021
 * @version 2.2
 */
public class Analizy {
    /**
     * Метод принимает два файла, суть в том что метод примает сначала один файл с запросоми
     * сервера и времени выполнения, в нем есть ошибочный тип  это 500 и 400,
     * второй параметр это уже только те запросы в сервере котрорые успещно прошли
     * то есть 200 или 300.
     * я этим алгоритмом показываю это.
     * @param source - запросы с багами
     * @param target - запросы без багов
     */
    public void unavailable(String source, String target) {
       try (BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(target)))
       ) {
           String line = null;
           boolean b = false;
           while ((line = reader.readLine()) != null) {
               String[] str = line.split(" ");
               if (!b && (str[0].equals("400") || str[0].equals("500"))) {
                   writer.print(str[1] + ";");
                   b = true;
               } else if(b && (str[0].equals("200") || str[0].equals("300"))) {
                   writer.println(str[1]);
                   b = false;
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            pw.println("15:01:30;15:02:32");
            pw.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
