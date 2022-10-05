import java.util.Scanner;

public class TicTacToe
{
    private char[][] board;
    private char currentPlayer;
    private int rows = 3;
    private int columns = 3;
    private Scanner keyboard = new Scanner(System.in);

    public TicTacToe()
    {
        this.board = new char[rows][columns];

        currentPlayer = 'x';
        initialiseBoard();
    }

    private void initialiseBoard()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard()
    {
        System.out.println("-----------------");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (j == columns - 1)
                {
                    System.out.print(board[i][j]);
                }
                else
                {
                    System.out.print(board[i][j] + " | ");
                }
            }

            System.out.println();
        }
        System.out.println("-----------------");
    }

    public boolean isBoardFull()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (board[i][j] == '-')
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkForWinner()
    {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    public void announceWinner()
    {
        System.out.println("Player " + currentPlayer + " won!");
    }

    private boolean checkRows()
    {
        for (int i = 0; i < rows; i++)
        {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2])
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns()
    {
        for (int j = 0; j < columns; j++)
        {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[0][j] == board[2][j])
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals()
    {
        return (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
                || (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]);
    }

    public void changePlayer()
    {
        //The short way -> currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        if (currentPlayer == 'x')
        {
            currentPlayer = 'o';
        }
        else
        {
            currentPlayer = 'x';
        }
    }

    public void updateBoard()
    {
        boolean validInput = false;
        do
        {
            System.out.println("Player " + currentPlayer + ", enter your move 1 1 -> 3 3: ");
            /*if (currentPlayer == 'x')
            {
                System.out.println("Player " + currentPlayer + ", enter your move 1 1 -> 3 3: ");
            }
            else
            {
                System.out.println("Player " + currentPlayer + ", enter your move 1 1 -> 3 3: ");
            }*/

            int row = keyboard.nextInt() - 1;
            int column = keyboard.nextInt() - 1;

            if (row >= 0 && row < rows && column >= 0 && column < columns && board[row][column] == '-')
            {
                board[row][column] = currentPlayer;
                validInput = true;
            }
            else
            {
                System.out.println("Sorry, the move at " + (row + 1) + " " + (column + 1) + " is not valid. Try again");
            }
        }while (!validInput);
    }

    public void pickPlayer()
    {
        char choice;

        do
        {
            System.out.println("Please enter either 'x' or 'o' to pick your symbol: ");
            choice = keyboard.nextLine().charAt(0);

            if (choice != 'x' && choice != 'o')
            {
                System.out.println("Not a correct symbol");
            }
        }while (choice != 'x' && choice != 'o');

        if (choice == 'x')
        {
            currentPlayer = 'x';
        }
        else
        {
            currentPlayer = 'o';
        }
    }
}