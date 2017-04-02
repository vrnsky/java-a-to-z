package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 *
 * Represent model of item.
 */
@Entity
@Table(name = "items")
public class Item {

    /**
     * Unique number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Description of this item.
     */
    @Column(name = "description")
    private String description;

    /**
     * User which create this item.
     */
    @ManyToOne(targetEntity = User.class)
    private User author;

    /**
     * List of comments for this item.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private List<Comment> comments;

    /**
     * Default constructor.
     */
    public Item() {
    }

    /**
     * Return id of this comment.
     * @return id of this comment.
     */
    public int getId() {
        return id;
    }

    /**
     * Set new id.
     * @param id new version of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return description of this item.
     * @return description of this item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set new description.
     * @param description new version of description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return author of this item.
     * @return author of this item.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Set new author of this item.
     * @param author new version of author, instance of author class.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Return list of comments for this item.
     * @return list of comments for this item.
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Set new comments.
     * @param comments list of new comments.
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Return text view of this item.
     * @return text view of this item.
     */
    @Override
    public String toString() {
        return String.format("%s create next: %s", this.author, this.description);
    }
}
