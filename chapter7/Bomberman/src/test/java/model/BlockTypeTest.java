package model;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.12.2016
 * Unit test for BlockType enum.
 */
public class BlockTypeTest {

    /**
     * When try to create block type empty should check that all is ok.
     */
    @Test
    void whenTryCreateBlockTypeEmptyShouldCheckThatAllIsOk() {
        BlockType empty = BlockType.EMPTY;
        assertThat(empty, is(BlockType.EMPTY));
    }

    /**
     * When try to create block type fill should check that all is ok.
     */
    @Test
    public void whenTryCreateBlockTypeFillShouldCheckThatAllIsOk() {
        BlockType empty = BlockType.FILL;
        assertThat(empty, is(BlockType.FILL));
    }
}