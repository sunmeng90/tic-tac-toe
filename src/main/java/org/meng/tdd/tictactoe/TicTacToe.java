package org.meng.tdd.tictactoe;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by meng_ on 7/23/2017.
 */
public class TicTacToe {
    private static final int SIZE = 3;
    private Character[][] board = {
            {'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}
    };

    private Character lastPlayer = '\0';

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = this.nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin(x, y)) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        }
        return "No Winner";
    }

    private boolean isDraw() {
        return !Arrays.stream(board).flatMap(Stream::of).anyMatch(point -> point == '\0');
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException();
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }

    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * SIZE;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int idx = 0; idx < 3; idx++) {
            horizontal += board[idx][y - 1];
            vertical += board[x - 1][idx];
            diagonal1 += board[idx][idx];
            diagonal2 += board[idx][SIZE - idx - 1];
        }
        if (horizontal == playerTotal || vertical == playerTotal || diagonal1 == playerTotal || diagonal2 == playerTotal) {
            return true;
        }
        return false;
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
