package ru.job4j.io.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j2 {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j2.class.getName());


    public static void main(String[] args) {
        String name = "Mikhail Pushkarev";
        int age = 25;
        double sum = 84.5;
        char ch = '1';
        long lg = 23L;
        LOG.debug("User info name : {}, age {}, sum {}, ch {}, lg {}", name, age, sum, ch, lg);
    }
}
