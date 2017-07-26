# tic-tac-toe
TDD demo

#Red-Green-Refactoring
1. create test and make it red

```java
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

}

```
2. add least code to make the test green(pass)

```java
public class TicTacToe {
    public void play(int i1, int i2) {
        throw new RuntimeException();
    }
}

```

3. refactoring code(optional
```java
public class TicTacToe {
    public void play(int x, int y) {
        throw new RuntimeException();
    }
}

```


Coverage Report:
gradle clean test jacocoTestReport
