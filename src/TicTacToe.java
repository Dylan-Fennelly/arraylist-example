public class TicTacToe
{
    private char[][] board;
    private char currentPlayer;
    private int rows = 3;
    private int cols = 3;

    public TicTacToe()
    {
        this.board = new char[rows][cols];
        currentPlayer ='x';
        initializeBoard();
    }

    private void initializeBoard()
    {
        for(int i =0; i < rows; i++)
        {
            for(int j = 0; j < cols;j++)
            {
                board[i][j]='-';
            }
        }
    }
    public void printBoard()
    {
        System.out.println("----------------------");
        for(int i = 0; i< rows;i++)
        {
            System.out.print("| ");
            for(int j = 0;j<cols;j++)
            {
                if(j == cols -1)
                {
                    System.out.print(board[i][j]);
                }
                System.out.print(board[i][j]+ " | ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
    private boolean isBoardFull()
    {
        for(int i =0;i<rows;i++)
        {
            for (int j = 0 ;j<cols; j++)
            {
                if(board[i][j]=='-')
                {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkForWinner()
    {
        return (checkRows() || checkColumns() || checkDiagonal());
    }

    private boolean checkRows()
    {
        for (int i = 0;i<rows;i++)
        {
            if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2])
            {
                return true;
            }
        }
        return false;
    }
    private boolean checkColumns()
    {
        for (int i = 0;i<cols;i++)
        {
            if(board[0][i] != '-' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
            {
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonal()
    {
        return (board[0][0] != '-' && board[0][0]== board[1][1] && board[0][0] == board[2][2]
                || board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]);
    }
    private void changePlayer()
    {
        //currentPlayer = (currentPlayer == 'x') ? 'o':'x';
        if(currentPlayer == 'x')
        {
            currentPlayer = 'o';
        }
        else
        {
            currentPlayer ='x';
        }
    }
    /*Ask the user for the row and col where they want to put their move
     and update the board with the currentPlayer's character at the row and col
     */
    private void updateBoard()
    {
        boolean validInput = false;
        do
        {
            if(currentPlayer == 'x')
            {
                System.out.println("Player X,enter your move(1,1)->(3,3): ");
            }
            else
            {
                System.out.println("Player O,enter your move(1,1)->(3,3): ");
            }
            int row = keyboard.nextInt() - 1;
            int col = keyboard.nextInt() - 1;
            //finish me please !!
        }while{!validInput);
    }
}
