package org.meng.tdd.tictactoe;

import org.omg.SendingContext.RunTime;

/**
 * Created by meng_ on 7/23/2017.
 */
public class TicTacToe {
    public void play(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("runtime exception");
        }else if(y < 1 || y >3){
            throw new RuntimeException("runtime exception");
        }
    }
}
