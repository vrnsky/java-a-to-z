package model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.12.2016
 * Unit test for Board.java
 */
public class BoardTest {

    /**
     * When try create board should check that all is ok.
     */
    @Test
    public void whenTryCreateBoardShouldCheckThatAllIsOK() {
        Board board = new Board(10, 10);
        assertThat(board, is(notNullValue()));
    }

    /**
     * When try get height of board should check that all is ok.
     * @throws Exception if error happened.
     */
    @Test
    public void whenTryGetHeightOfBoardShouldCheckThatAllIsOk() throws Exception {
        Board board = new Board(10, 10);
        assertThat(board.getHeight(), is(10));
    }

    /**
     * When try get width of board should check that all is ok.
     * @throws Exception if error happened.
     */
    @Test
    public void whenTryGetWidthOfBoardShouldCheckThatAlIsOk() throws Exception {
        Board board = new Board(10, 10);
        assertThat(board.getWidth(), is(10));
    }

    /**
     * When try get block should check that all is ok.
     */
    @Test
    public void whenTryGetBlockShouldCheckThatAllIsOk() {
        Board board = new Board(10, 10);
        assertThat(board.getBlock(5, 5), is(notNullValue()));
    }

    /**
     * When try get not valid block should check that method return null.
     * @throws Exception if error happened.
     */
    @Test
    public void whenTryGetNotValidBlockShouldCheckThatMethodReturnNull() throws Exception {
        Board board = new Board(3, 3);
        assertThat(board.getBlock(5, 5), is(nullValue()));
    }
}