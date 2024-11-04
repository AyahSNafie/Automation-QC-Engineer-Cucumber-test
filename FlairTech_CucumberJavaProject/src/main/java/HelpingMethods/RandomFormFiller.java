package HelpingMethods;

import java.util.Random;


public class RandomFormFiller {


	private static Random random = new Random();

	public static int random1_2()
	{
		int tmp = (int) ( Math.random() * 2 + 1);
		return tmp;
	}

	public static String username()
	{
		String[] names = {"Ahmed", "Kareem", "Mohamed", "Youssef", "Khaled", "Amina", "Fatma", "Laila", "Noura", "Sarah"};
		return names[random.nextInt(names.length)];


	}

	public static char employeeName()
	{
		Random random = new Random();

		// Generate a random uppercase letter
		char randomUppercase = (char) ('A' + random.nextInt(26));

		return randomUppercase;

	}

	public static String password() {

		//Password and confirm Password
		String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*!123456789"; // Include special characters
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < 12; i++) { // Password length of 12
			password.append(passwordChars.charAt(random.nextInt(passwordChars.length())));
		}
		return password.toString();

	}



}
