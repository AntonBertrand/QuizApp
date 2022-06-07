package com.example.RevisionApp;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void startQuiz(int quizNum) {
        QuizQuestions quizQuestion;
        String question;
        String answer;
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        String input;


       for (int i = 0; i < quizQuestions.get(quizNum-1).getSize();  i++) {

          System.out.println("Quiz Size: " + quizQuestions.get(quizNum-1).getSize());

           quizQuestion = quizQuestions.get(quizNum-1);
           answer = quizQuestion.readAnswer(i);
           question = quizQuestion.readQuestion(i);
           System.out.println("Question " + i+1 +": " + question);

           input = scanner.nextLine();
           if(input.equals(answer)) {
               System.out.println("Correct!");
               score++;
           } else {
               System.out.println("WRONG! - Correct answer was: " + answer);
           }
       }

        System.out.println("Quiz Over! Your final score was: " + score + "/" + quizQuestions.get(0).getSize());
    }

    public void addQuizQuestions(QuizQuestions quizQuestions) {
        this.quizQuestions.add(quizQuestions);
    }

}

