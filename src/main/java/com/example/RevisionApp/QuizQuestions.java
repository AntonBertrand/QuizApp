package com.example.RevisionApp;

import java.util.ArrayList;

public class QuizQuestions {
    String name;
    ArrayList<Questions> questions = new ArrayList<>();
    ArrayList<Answers> answers = new ArrayList<>();

    public QuizQuestions() {
        this.name = name;
        this.questions = questions;
        this.answers = answers;
    }

    public void setQuestions(Questions question, Answers answer) {
        questions.add(question);
        answers.add(answer);
    }

    public void readQuestions() {
        for (Questions question: questions) {
            System.out.println(question.getQuestion());
        }
    }

    public int getSize() {
        return questions.size();
    }

    public String readQuestion(int number) {
        return questions.get(number).getQuestion();
    }


    public String readAnswer(int number) {
        return answers.get(number).getAnswer();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }



}
