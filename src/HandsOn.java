import java.util.Scanner;

public class HandsOn {

	public static void main(String[] args) {

		String[][] ticket = { { "Student", "Child", "Regular", "Senior" },
				{ "8", "8", "10", "7" } }; /* Type and then cost */

		int[] discountAge = { 13, 65 }; // child, senior citizen
		// https://stackoverflow.com/questions/26576909/how-to-format-string-output-so-that-columns-are-evenly-centered
		String colWidth = "%-13s%-13s%-10s\n";
		String header = "%-10s%-13s%-13s\n";
		System.out.printf(header, "Type:", "Age Range:", "Price:");
		System.out.printf(header, "-----", "----------", " ------");
		System.out.printf(colWidth, ticket[0][0], "N/A", ticket[1][0]);
		System.out.printf(colWidth, ticket[0][1], "0-" + (discountAge[0] - 1), ticket[1][1]);
		System.out.printf(colWidth, ticket[0][2], discountAge[0] + "-" + (discountAge[1] - 1), ticket[1][2]);
		System.out.printf(colWidth, ticket[0][3], discountAge[1] + " & Above", ticket[1][3]);

		String price;
		Scanner input = new Scanner(System.in);
		System.out.print("\nWhat is your age? ");
		int age = input.nextInt();

		if (age > 0 && age <= 117) { // It is a valid age

			if (age < discountAge[0]) {
				System.out.println("You are a " + ticket[0][1] + ". You only pay: $" + ticket[1][1]);
				input.close();
				return;
			} else if (age >= discountAge[1]) {
				System.out.println("You are a " + ticket[0][3] + ". You only pay: $" + ticket[1][3]);
				input.close();
				return;
			}

			Scanner input2 = new Scanner(System.in);
			System.out.print("You are a student. true/false: ");
			boolean isStudent = input2.nextBoolean();

			if (isStudent) {
				price = ticket[1][0];
				System.out.print("You get the " + ticket[0][0] + " discount: ");
			} else {
				price = ticket[1][2];
				System.out.print(ticket[1][2] + " price: ");
			}
			input2.close();
			input.close();
			System.out.println("You pay: $" + price);

		} else {
			System.out.println("Invalid age");
		}

	}
}
