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
}
