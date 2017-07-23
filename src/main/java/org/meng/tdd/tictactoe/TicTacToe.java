package org.meng.tdd.tictactoe;

/**
 * Created by meng_ on 7/23/2017.
 */
public class TicTacToe {
    private Character[][] board = {
            {'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}
    };

    private Character lastPlayer = '\0';

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException();
        } else {
            board[x - 1][y - 1] = 'X';
        }
        lastPlayer = this.nextPlayer();
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("X is outside board");
        }
    }

    public Character nextPlayer() {
        if (lastPlayer == 'X') {
            return 'T';
        }
        return 'X';
    }
}
