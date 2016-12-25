package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.12.2016
 * Simple block class which provide place for holding actor.
 */
public class Block {

    /**
     * Type of the block.
     */
    private final BlockType type;

    /**
     * Actor which placed at this block.
     */
    private Actor actor;

    /**
     * Create a new block.
     * @param type of block.
     */
    public Block(final BlockType type) {
        this.type = type;
    }

    /**
     * Attach actor to this block.
     * @param actor instance of actor class.
     */
    public synchronized void attachActor(Actor actor) {
        this.actor = actor;
    }

    /**
     * Detach actor from this block.
     */
    public synchronized void detachActor() {
        this.actor = null;
    }

    /**
     * Return current actor.
     * @return null if actor is not exist at this block, otherwise instance of actor.
     */
    public synchronized Actor getActor() {
        return this.actor;
    }

    /**
     * Return type of block.
     * @return type of block.
     */
    public BlockType getType() {
        return type;
    }
}
