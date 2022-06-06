package com.example.RevisionApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RevisionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevisionAppApplication.class, args);

		boolean flag = false;
		Quiz quiz = new Quiz("Test");
		Scanner scanner = new Scanner(System.in);

		while (!flag) {
			System.out.println("Available Options: " +
			"\n" + "1) Create a new Quiz" +
					"\n" + "2) List all Quiz's" +
					"\n" + "3) Play a Quiz");
			System.out.println("Please Enter a Command");
			String input = scanner.nextLine();

			switch (input) {
				case "1":

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


					break;
				case "2":
					System.out.println("List of Quizzes:");
					quiz.readQuizQuestions();
					break;

				case "3":
					System.out.println("Choose a Quiz:");
					quiz.readQuizQuestions();

					input = scanner.nextLine();


					break;
			}

		}


	}

}
