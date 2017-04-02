package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 *
 * This model describe comment at system.
 */
@Entity
@Table(name = "comments")
public class Comment {

    /**
     * Unique number among all comments for this item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Author of this comment.
     */
    @ManyToOne(targetEntity = User.class)
    private User author;

    /**
     * Text of comment.
     */
    @Column(name = "text")
    private String text;

    /**
     * Default constructor.
     */
    public Comment() {
    }

    /**
     * Return id of this comment.
     * @return id of this comment.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new version of id.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return author of this comment.
     * @return author of this comment.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Set new author for this comment.
     * @param author new version of author, instance of author class.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Return text of this comment.
     * @return text of this comment.
     */
    public String getText() {
        return text;
    }

    /**
     * Set new text of this comment.
     * @param text new version of text for this comment.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Return text view of this comment.
     * @return text view of this comment.
     */
    @Override
    public String toString() {
        return String.format("%s comment this item: %s", this.author, this.text);
    }
}
