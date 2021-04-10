package ru.job4j.io.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j3 {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j3.class.getName());

    public static void main(String[] args) {
        try {
            throw new Exception("Not support code");
        } catch (Exception e) {
            LOG.error("Exception in log example ", e);
        }
    }
}
