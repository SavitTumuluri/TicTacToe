import java.util.Arrays;

public class TicTacToe {
	public String[][] board = new String[3][3];
	public String PlayerOne;
	public String PlayerTwo;
	public String winner = null;
	public TicTacToe(String playerNameOne, String playerNameTwo)
	{
		this.PlayerOne = playerNameOne;
		this.PlayerTwo = playerNameTwo;
		
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				board[i][j] = " ";
			}
		}
		
	}
	public boolean checkWin()
	{
		if ((!board[0][0].equals(" ")) && board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
		{
			winner = board[0][0];
			return true;
		}
		else if ((!board[1][0].equals(" ")) && board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]))
		{
			winner = board[1][0];
			return true;
		}
		else if ((!board[2][0].equals(" ")) && board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]))
		{
			winner = board[2][0];
			return true;
		}
		else if((!board[0][0].equals(" ")) && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){
			winner = board[0][0];
			return true;
		}
		else if((!board[0][0].equals(" ")) && board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0])){
			winner = board[0][0];
			return true;
		}
		else if((!board[0][1].equals(" ")) && board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1])){
			winner = board[0][1];
			return true;
		}
		else if((!board[0][2].equals(" ")) && board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2])){
			winner = board[0][2];
			return true;
		}else if((!board[0][2].equals(" ")) && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])){
			winner = board[0][2];
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isTie()
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if (board[i][j] == " ")
				{
					return false;
				}
			}
		}
		if (checkWin() == false)
		{
			return true;
		}
		return false;
	}
	public void clearBoard()
	{
		board = new String[2][2];
		PlayerOne = null;
		PlayerTwo = null;
		winner = null;
	}
	public void recordPlayerChoice(String player, int posX, int posY)
	{
		board[posX][posY] = player;
		printBoard();
	}
	public void printBoard()
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
			System.out.println("-----------------------------------");
			
		}
	}
}
