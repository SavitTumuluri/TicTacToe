import java.util.Scanner;

public class ConsoleMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input name of Player One: ");
		String playerOneName = scanner.next();
		System.out.println("Player One Name is " + playerOneName);
		System.out.println("input name of Player Two: ");
		String playerTwoName = scanner.next();
		System.out.println("Player Two Name is " + playerTwoName);
		TicTacToe newGame = new TicTacToe(playerOneName, playerTwoName);
		boolean endGame = false;
		while (endGame == false) {
			/////////////////////////
			System.out.println("Where do you want to place x-coordinate (starting from 0) " + playerOneName + "?");
			int playerOneXPostition = scanner.nextInt();
			System.out.println("Where do you want to place y-coordinate (starting from 0) " + playerOneName + "?");
			int playerOneYPostition = scanner.nextInt();
			newGame.recordPlayerChoice(playerOneName, playerOneXPostition, playerOneYPostition);
			boolean ifTie = newGame.isTie();
			if (ifTie == false) {
				boolean ifWon = newGame.checkWin();
				if (ifWon == true) {
					String winnerOfGame = newGame.winner;
					System.out.println("Congratulations! " + winnerOfGame + " has won. Press anything else to close.");
					endGame = true;
					String keyValue = scanner.next();
					if (keyValue.equalsIgnoreCase(keyValue)) {
						System.exit(0);
					}
				}

			} else {
				System.out.println("Nobody has won as the game resulted in a tie. Press anything else to close.");
				endGame = true;
				String keyValue = scanner.next();
				if (keyValue.equalsIgnoreCase(keyValue)) {
					System.exit(0);
				}
			}

			//////////////////////////////
			if (endGame == false) {
				System.out.println("Where do you want to place x-coordinate (starting from 0) " + playerTwoName + "?");
				int playerTwoXPostition = scanner.nextInt();
				System.out.println("Where do you want to place y-coordinate (starting from 0) " + playerTwoName + "?");
				int playerTwoYPostition = scanner.nextInt();
				newGame.recordPlayerChoice(playerTwoName, playerTwoXPostition, playerTwoYPostition);
				ifTie = newGame.isTie();
				if (ifTie == false) {
					boolean ifWon = newGame.checkWin();
					if (ifWon == true) {
						String winnerOfGame = newGame.winner;
						System.out.println(
								"Congratulations! " + winnerOfGame + " has won. Press anything else to close.");
						endGame = true;
						String keyValue = scanner.next();
						if (keyValue.equalsIgnoreCase(keyValue)) {
							System.exit(0);
						}
					}

				}

				else {
					System.out.println("Nobody has won as the game resulted in a tie. Press anything else to close.");
					endGame = true;
					String keyValue = scanner.next();
					if (keyValue.equalsIgnoreCase(keyValue)) {
						System.exit(0);
					}
				}
			}
		}

	}
}
