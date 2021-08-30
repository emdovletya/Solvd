package com.solvd.ITCompany.utils.words;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Word {
    private Map<String, Integer> wordSet;

    public Word(String inputFileURL) throws IOException {
        analyze(inputFileURL, "UTF-8");
        writeToFile("src/main/resources/word_out.txt");
    }

    private void analyze(String fileURL, String encoding) throws IOException {
        File file = new File(fileURL);
        String punctuationRegex = "[\"\\.,:;\\s]+";
        String content = StringUtils.lowerCase(FileUtils.readFileToString(file, encoding));

        wordSet = CollectionUtils.getCardinalityMap(Arrays.asList(content.split(punctuationRegex)));
    }

    private void writeToFile(String outputFileURL) {
        File file = new File(outputFileURL);
        if (file.exists()) file.delete();
        wordSet.forEach((key, value) -> {
            try {
                FileUtils.writeStringToFile(file, key + " : " + value + "\n", "UTF-8", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}