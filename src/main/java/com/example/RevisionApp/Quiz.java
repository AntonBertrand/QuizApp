package com.example.RevisionApp;

import java.util.ArrayList;

public class Quiz {
    String name;
    ArrayList<QuizQuestions> quizQuestions = new ArrayList<>();

    public Quiz(String name) {
        this.name = name;
        this.quizQuestions = quizQuestions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void readQuizQuestions() {
        int i = 1;
        for (QuizQuestions quizQuestions : quizQuestions) {
            System.out.println(i + ") " + quizQuestions.getName());
            i++;
        }
    }

    public void addQuizQuestions(QuizQuestions quizQuestions) {
        this.quizQuestions.add(quizQuestions);
    }

}

