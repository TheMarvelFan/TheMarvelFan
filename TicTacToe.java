import java.util.*;
public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(char[] row : board){
            Arrays.fill(row, ' ');
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " choice: ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            if(board[row][col] != ' '){
                System.out.println("Invalid move.");
            }
            else {
                board[row][col] = player;
                gameOver = isWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " has won.");
                    break;
                }
                else{
                    player = (player == 'X') ? 'O' : 'X';
                }
                gameOver = noMoves(board);
                if (gameOver) {
                    System.out.println("Oops! No more moves.");
                    break;
                }
            }
        }
        printBoard(board);
    }

    public static boolean isWon(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }
        for (int i = 0; i < 3; i++) {
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player )
            return true;
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    public static void printBoard(char[][] board) {
        for(char[] row : board){
            for (char c : row) {
                System.out.print(c + " | ");
            }
            System.out.println();
        }
    }

    public static boolean noMoves (char[][] board) {
        int count = 0;
        for (char[] row : board) {
            for (char ch : row) {
                if (ch == ' ')
                    count ++;
            }
        }
        return count == 0;
    }

    //Interesting code snippet: -
    /*
        int a = 9;
        int b = 17;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    */
    //this will swap 2 numbers
}