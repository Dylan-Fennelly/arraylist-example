public class TicTacToeMain
{
    public static void main(String[] args)
    {
        TicTacToe myGame = new TicTacToe();
        boolean gameOver = false;

        myGame.pickPlayer();

        do
        {
            myGame.updateBoard();
            myGame.printBoard();

            if (myGame.checkForWinner())
            {
                myGame.announceWinner();
                gameOver = true;
            }

            if (myGame.isBoardFull() == true)
            {
                System.out.println("We have a draw");
                gameOver = true;
            }

            myGame.changePlayer();
        }while (gameOver == false);
    }
}