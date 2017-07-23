package org.meng.tdd.tictactoe;

/**
 * Created by meng_ on 7/23/2017.
 */
public class TicTacToe {
    private Character[][] board = {
            {'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}
    };

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException();
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("X is outside board");
        }
    }
}
