package com.example.RevisionApp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
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

    public static JSONArray quizAPI() {

        System.out.println("Choose a Quiz Topic:" +
                "\n" + "1) Geography" +
                "\n" + "2) Sports" +
                "\n" + "3) History");

        Scanner scanner2 = new Scanner(System.in);
        int category = 0;
        int size = 0;
        String input = scanner2.nextLine();

        switch(input) {
            case "1":
                category = 22;
                break;
            case "2":
                category = 21;
                break;
            case "3":
                category = 23;
                break;
        }

        System.out.println("Choose a quiz size (Number of questions)");
        size = scanner2.nextInt();



        try {

            URL url = new URL("https://opentdb.com/api.php?amount="+size+"&category="+category+"&difficulty=easy&type=boolean");


            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                informationString.delete(0,29);
                informationString.delete(informationString.length()-1,informationString.length());

                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                return dataObject;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //To Stop method throwing an error for missing return statement
        JSONArray array = null;
        return array;
    }

    public static void startPremadeQuiz(JSONArray premadeQuiz) {
//testing commit
        String question;
        String answer;
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Quiz Size: " + premadeQuiz.size());

        for (int i = 0; i < premadeQuiz.size();  i++) {
            JSONObject premadeQuiz2 = (JSONObject) premadeQuiz.get(i);
            System.out.println("Question " + (i+1) +": " + premadeQuiz2.get("question"));
            System.out.println("True or False?");

            input = scanner.nextLine();
            if(input.equals(premadeQuiz2.get("correct_answer"))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("WRONG! - Correct answer was: " + premadeQuiz2.get("correct_answer"));
            }
        }

        System.out.println("Quiz Over! Your final score was: " + score + "/" + premadeQuiz.size());
    }

}

