package com.solvd.farm.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TextAnalyzer {

    public static void analyze(String inputPath, String outputPath) {

        try {
            InputStream inputStream = TextAnalyzer.class.getClassLoader().getResourceAsStream(inputPath);

            if (inputStream == null){
                throw new RuntimeException("File not found: " + inputPath);
            }

            String content = new  String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            List<String> specialWords = List.of("farm", "animal", "food", "profit");

            StringBuilder result = new StringBuilder("\n=== ANALYSIS ===\n");

            for (String word : specialWords) {
                int count = StringUtils.countMatches(content.toLowerCase(), word);
                result.append(word).append(": ").append(count).append("\n");
            }

            File file = new File("src/main/resources/output.txt");
            FileUtils.writeStringToFile(file, String.valueOf(result), StandardCharsets.UTF_8, true);

        } catch (Exception e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}