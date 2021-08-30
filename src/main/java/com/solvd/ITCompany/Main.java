package com.solvd.ITCompany;

import com.solvd.ITCompany.utils.words.Word;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        ITCompany company = new ITCompany();
//        company.initProject("Project");

        try {
            Word w = new Word("src/main/resources/word_input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
