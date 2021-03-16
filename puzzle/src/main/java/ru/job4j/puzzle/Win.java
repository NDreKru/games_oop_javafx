package ru.job4j.puzzle;

public class Win {

    public static boolean check(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                result = checkHorizontal(board, i) || checkVertical(board, i);
                break;
            }
        }
        return result;
    }

    public static boolean checkHorizontal(int[][] board, int index) {
        boolean result = true;
        for (int i = 0; i < board[index].length; i++) {
            if (board[index][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkVertical(int[][] board, int index) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
