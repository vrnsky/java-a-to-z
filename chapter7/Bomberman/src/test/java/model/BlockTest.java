package model;

import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Unit test for Block.java.
 * @author evrnsky
 * @version 0.1
 * @since 17.04.2017
 */
public class BlockTest {

    /**
     * When try create a block should check that is created.
     */
    @Test
    public void whenTryCreateABlockShouldCheckThatAllIsOk() {
        Block block = new Block(BlockType.EMPTY);
        assertThat(block, is(notNullValue()));
    }

    /**
     * When try create a block and attach actor should check that all is ok.
     */
    @Test
    public void whenTryCreateBlockAndAttachActorShouldCheckThatAllIsOk() {
        Block block = new Block(BlockType.EMPTY);
        Actor actor = new Player(new Board(10, 10), 0, 0);
        block.attachActor(actor);
        assertThat(block.getActor(), is(actor));
    }

    /**
     * When try detach actor should check that actor is null.
     */
    @Test
    public void whenTryDetachActorShouldCheckThatActorIsNull() {
        Block block = new Block(BlockType.EMPTY);
        Actor actor = new Player(new Board(10, 10), 0, 0);
        block.attachActor(actor);
        block.detachActor();
        assertThat(block.getActor(), is(nullValue()));
    }

    /**
     * When try get type of block should check that is correct type.
     */
    @Test
    public void whenTryGetTypeOfBlockShouldCheckThatIsCorrectType() {
        Block block = new Block(BlockType.EMPTY);
        assertThat(block.getType(), is(BlockType.EMPTY));
    }
}