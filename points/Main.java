package points;

import java.util.Scanner;

public class Main {

	public static final int TURNBALL = 6;
	public static final int DOUBLE_TURNBALL = 14;
	public static final int DEFENSIVE_GRUMPLING = 2;
	public static final int EXTRA_POINT = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfGames = sc.nextInt();
		for (int n = 0; n < numberOfGames; n++) {
			int totalScore = sc.nextInt();
			int combinations = 0;
			String output = "";

			for (int doubleTurnballs = 0; DOUBLE_TURNBALL * doubleTurnballs <= totalScore; doubleTurnballs++) {
				for (int turnballs = 0; DOUBLE_TURNBALL * doubleTurnballs
						+ TURNBALL * turnballs <= totalScore; turnballs++) {
					for (int grumplings = 0; DEFENSIVE_GRUMPLING * grumplings
							+ DOUBLE_TURNBALL * doubleTurnballs + TURNBALL
							* turnballs <= totalScore; grumplings++) {
						for (int extraPoints = 0; extraPoints <= turnballs
								&& DEFENSIVE_GRUMPLING * grumplings
										+ DOUBLE_TURNBALL * doubleTurnballs
										+ TURNBALL * turnballs <= totalScore; extraPoints++) {
							if (extraPoints * EXTRA_POINT + DEFENSIVE_GRUMPLING
									* grumplings + DOUBLE_TURNBALL
									* doubleTurnballs + TURNBALL * turnballs == totalScore
									&& extraPoints <= turnballs) {
								combinations++;
								output += combinations + "\t" + doubleTurnballs
										+ "\t" + turnballs + "\t" + grumplings
										+ "\t" + extraPoints + "\n";
							}
						}
					}
				}
			}
			System.out.println("Game #1\t" + totalScore
					+ " total points  Number of possible combinations: "
					+ combinations);
			System.out.print(output);

		}
		sc.close();
	}
}
