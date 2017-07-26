package org.meng.tdd.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by meng_ on 7/23/2017.
 */
public class TicTacToeSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testWhenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }


    @Test
    public void testWhenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void testWhenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void testGivenFirstTurnWhenNextPlayerThenX() {
        assertThat("X should be the first turn player", ticTacToe.nextPlayer(), equalTo('X'));
    }

    @Test
    public void testGivenLastTurnXWhenNextPlayerThenT() {
        ticTacToe.play(1, 1);
        assertThat("T should be the next player", ticTacToe.nextPlayer(), equalTo('T'));
    }

    @Test
    public void testWhenPlayThenNoWinner() {
        String actual = ticTacToe.play(1, 1);
        assertThat(actual, equalTo("No Winner"));
    }

    @Test
    public void testWhenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 2);
        String actual = ticTacToe.play(3, 1);
        assertThat(actual, equalTo("X is the winner"));
    }

    @Test
    public void testWhenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(2, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(3, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(3, 3);
        String actualT = ticTacToe.play(1, 3);
        assertThat(actualT, equalTo("T is the winner"));
    }

    @Test
    public void testWhenPlayAndBottomTopDiagonalLineThenWinner() {
        ticTacToe.play(1, 3);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 1);
        String actualX = ticTacToe.play(3, 1);
        assertThat(actualX, equalTo("X is the winner"));
    }

    @Test
    public void testWhenAllBoxesFilledThenDraw() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(1, 3);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 3);
        ticTacToe.play(2, 2);
        ticTacToe.play(3, 1);
        ticTacToe.play(3, 3);
        String actualDraw = ticTacToe.play(3, 2);
        assertThat(actualDraw, equalTo("The result is draw"));
    }
}
