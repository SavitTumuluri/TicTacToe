import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicsMain extends Applet implements ActionListener {
	// inspired from https://www.youtube.com/watch?v=Fn--9sWNoOE
	// and
	// https://archives.evergreen.edu/webpages/curricular/1998-1999/java/applet_input.HTM
	int x;
	int y;
	String playerNameOne = " ";
	String playerNameTwo = " ";
	TextField inputNameOne;
	TextField inputNameTwo;
	TicTacToe newBoard = new TicTacToe(playerNameOne, playerNameTwo);
	Button newGameButton;
	String currentPlayer = " ";
	String winnerOfGame = "no one";

	public void init() {
		inputNameOne = new TextField();
		add(inputNameOne);
		inputNameTwo = new TextField();
		add(inputNameTwo);
		addMouseListener(new mymouselistener());
		newGameButton = new Button("Start Game");
		add(newGameButton);
		newGameButton.addActionListener(this);

	}

	public void paint(Graphics g) {
		// g.drawRect(50, 50, 100, 100);
		// g.drawRect(50, 150, 100, 100);
		// g.drawRect(50, 250, 100, 100);
		// g.drawRect(150, 50, 100, 100);
		// g.drawRect(250, 50, 100, 100);
		// g.drawRect(150, 150, 100, 100);
		// g.drawRect(150, 250, 100, 100);
		// g.drawRect(250, 250, 100, 100);
		// g.drawRect(250, 150, 100, 100);
		g.drawString(currentPlayer + "'s Turn", 400, 50);
		g.drawString("The Winner is: " + winnerOfGame, 400, 150);
		g.drawString("Input Player One's Name: " + playerNameOne, 400, 250);
		g.drawString("Input Player Two's Name: " + playerNameTwo, 400, 350);
		for (int i = 0; i < 3; i++) {
			System.out.println("Value i =" + i);
			for (int j = 0; j < 3; j++) {
				System.out.println("Value j =" + j);
				g.drawRect(50 + 50 * i, 50 + 50 * j, 50, 50);
				g.drawString(newBoard.board[i][j], 75 + 50 * i, 75 + 50 * j);
			}
		}

	}

	public boolean action(Event e, Object o) {
		playerNameOne = inputNameOne.getText();
		playerNameTwo = inputNameTwo.getText();
		newBoard = new TicTacToe(playerNameOne, playerNameTwo);
		System.out.println(e);
		repaint();
		return true;
	}

	// https://www.yourowncodes.com/get-mouse-clicked-location-position-in-java-applet/
	public class mymouselistener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			int[] positionArray = convertCoordsToPosition(x, y);
			if (positionArray[0] == -1) {
				System.out.println("ignore the click");
			} else {
				newBoard.recordPlayerChoice(currentPlayer, positionArray[1], positionArray[0]);
				newBoard.printBoard();
				boolean ifTie = newBoard.isTie();
				if (ifTie == false) {
					boolean ifWin = newBoard.checkWin();
					if (ifWin == true) {
						winnerOfGame = newBoard.winner;

					}

				} else {
					winnerOfGame = "No one. The game is a tie";
				}

				if (currentPlayer.equals(playerNameOne)) {

					currentPlayer = playerNameTwo;

				} else {
					currentPlayer = playerNameOne;
				}
			}
			System.out.println(x + " " + y);

			repaint();
		}
	}

	private int[] convertCoordsToPosition(int x, int y) {
		if (x >= 50 && x <= 100) // first col
		{
			if (y >= 50 && y <= 100) {
				return new int[] { 0, 0 };
			} else if (y > 100 && y <= 150) {
				return new int[] { 1, 0 };
			} else if (y > 150 && y <= 200) {
				return new int[] { 2, 0 };
			}
		} else if (x > 100 && x <= 150) // second col
		{
			if (y >= 50 && y <= 100) {
				return new int[] { 0, 1 };
			} else if (y > 100 && y <= 150) {
				return new int[] { 1, 1 };
			} else if (y > 150 && y <= 200) {
				return new int[] { 2, 1 };
			}
		} else if (x > 150 && x <= 200) // third col
		{
			if (y >= 50 && y <= 100) {
				return new int[] { 0, 2 };
			} else if (y > 100 && y <= 150) {
				return new int[] { 1, 2 };
			} else if (y > 150 && y <= 200) {
				return new int[] { 2, 2 };
			}
		}

		return new int[] { -1, -1 };
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("this is happening");
		if (e.getSource() == newGameButton) {
			currentPlayer = playerNameOne;
			newBoard = new TicTacToe(playerNameOne, playerNameTwo);
			winnerOfGame = "no one";

		}
		repaint();
	}
}
