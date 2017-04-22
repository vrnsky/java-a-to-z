package ru.vrnsky.robots;

import ru.vrnsky.interfaces.Body;
import ru.vrnsky.interfaces.Hand;
import ru.vrnsky.interfaces.Head;

/**
 * @author vrnsky.
 * @version 0.1
 *
 * This is implementation of robot.
 */
public class Robot {

    /**
     * Head of the robot.
     */
    private Head head;

    /**
     * Body of the robot.
     */
    private Body body;

    /**
     * Hand of the robot.
     */
    private Hand hand;

    /**
     * Default constructor.
     */
    public Robot() {
    }

    /**
     * Create a new roobot with given params.
     * @param head of robot.
     * @param body of robot.
     * @param hand of robot.
     */
    public Robot(Head head, Body body, Hand hand) {
        this.head = head;
        this.body = body;
        this.hand = hand;
    }

    /**
     * Turn body.
     */
    public void turn() {
        this.body.turn();
    }

    /**
     * Return head of this robot.
     * @return head of robot.
     */
    public Head getHead() {
        return head;
    }

    /**
     * Set new head of robot.
     * @param head of robot.
     */
    public void setHead(Head head) {
        this.head = head;
    }

    /**
     * Return body of robot.
     * @return body of robot.
     */
    public Body getBody() {
        return body;
    }

    /**
     * Set new body for this robot.
     * @param body new version of body.
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Return hand of this robot.
     * @return hand of this robot.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Set new head of robot.
     * @param hand new version of robot.
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
