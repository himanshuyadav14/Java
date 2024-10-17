import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;  // Change n for a larger board (e.g. n = 8 for 8-Queens)
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
    }

    // Function to solve the N-Queens problem
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Start backtracking
        solve(result, board, 0, n);
        return result;
    }

    // Helper function for backtracking
    private static void solve(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';  // Place queen
                solve(result, board, row + 1, n);  // Move to the next row
                board[row][col] = '.';  // Backtrack: Remove queen
            }
        }
    }

    // Function to check if placing a queen is safe
    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Helper function to construct the board as a list of strings
    private static List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}
