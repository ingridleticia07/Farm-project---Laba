package com.solvd.farm.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ReportGenerator<T> {

    private static final Logger logger = LogManager.getLogger(ReportGenerator.class);

    public void print(List<T> items) {
        logger.info("===== REPORT =====");

        for (T item : items) {
            logger.info(item.toString());
        }
    }
}