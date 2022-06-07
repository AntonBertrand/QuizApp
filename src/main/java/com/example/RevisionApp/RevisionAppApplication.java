package com.example.RevisionApp;

import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.example.RevisionApp.Quiz.quizAPI;
import static com.example.RevisionApp.Quiz.startPremadeQuiz;

@SpringBootApplication
public class RevisionAppApplication {

	static Quiz quiz = new Quiz("Test");


	public static void main(String[] args) {
		SpringApplication.run(RevisionAppApplication.class, args);

		boolean flag = false;

		Scanner scanner = new Scanner(System.in);

		while (!flag) {
			System.out.println("Available Options: " +
					"\n" + "1) Create a new Quiz" +
					"\n" + "2) List all Quiz's" +
					"\n" + "3) Play a Custom Quiz" +
					"\n" + "4) Play a Pre-Made Quiz" +
					"\n" + "5) Quit");
			System.out.println("Please Enter a Command");
			String input = scanner.nextLine();

			switch (input) {

				     //Create a new Quiz
				case "1":
					createQuiz();
					break;

					//List Of Custom Quiz's
				case "2":
					System.out.println("List of Quizzes:");
					quiz.readQuizQuestions();
					break;

					//Play a Custom Quiz
				case "3":
					System.out.println("Choose a Quiz:");
					quiz.readQuizQuestions();
					input = scanner.nextLine();
					quiz.startQuiz(Integer.parseInt(input));


					break;

					//Play a Pre-made Quiz
				case "4":
					JSONArray test = quizAPI();
					startPremadeQuiz(test);
					break;

					//Quit the application
				case "5":
					System.exit(0);
					break;
			}

		}


	}

	public static void createQuiz () {
		Scanner scanner = new Scanner(System.in);
		QuizQuestions quizQuestions = new QuizQuestions();
		boolean flag2 = true;
		while (flag2) {

			System.out.println("Enter your question");
			String input2 = scanner.nextLine();
			Questions question = new Questions(input2);

			System.out.println("Enter the answer");
			input2 = scanner.nextLine();
			Answers answer = new Answers(input2);

			quizQuestions.setQuestions(question, answer);

			System.out.println("Questions:");
			quizQuestions.readQuestions();

			System.out.println("Add another question? Y/N");
			input2 = scanner.nextLine();

			if (input2.equals("N")) {
				System.out.println("Enter a Quiz Name");
				input2 = scanner.nextLine();
				quizQuestions.setName(input2);

				quiz.addQuizQuestions(quizQuestions);
				break;
			}

		}
	}


}
