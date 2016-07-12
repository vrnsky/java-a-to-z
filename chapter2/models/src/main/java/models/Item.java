package models;

import java.util.Random;

/**
 * Implementation of common item in tracker app.
 */
public class Item {

	/**
	 * Unique string for each item.
	 */
	protected String id;
	/**
	 * Name of item.
	 */
	protected String name;

	/**
	 * Description of item.
	 */
	protected String description;

	/**
	 * Time when item was created.
	 */
	protected long createTime;

	/**
	 * Comments for item.
	 */
	protected Comment[] comments;

	/**
	 * For correct adding new comment should use pointer.
	 */
	protected int commentPointer;

	/**
	 * For generate random number for id.
	 */
	private static final Random RN = new Random();


	/**
	 * Default constructor.
	 */
	public Item() {
		this("Edit me now", "Empty item");
	}

	/**
	 * Create a item with given params.
	 * @param name name of item.
	 * @param desc description of item.
     */
	public Item(String name, String desc) {
		id = generateId();
		this.name = name;
		this.description = desc;
		comments = new Comment[10];
		commentPointer = 0;
		createTime = System.currentTimeMillis();
	}

	/**
	 * Return id of current item.
	 * @return it is unique string for each item.
     */
	public String getId() {
		return this.id;
	}
	
	/**
		Return a name of item.
		@return name of current item
	*/
	public String getName() {
		return this.name;
	}
	
	/**

	*/
	/**
	 * Set a name of item.
	 * @param name new name of item.
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return a description of item.
	 * @return description of current item.
     */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set a description of item.
	 * @param description new desc for item.
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Return a time of creating.
	 * @return time when item will be created.
     */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * Add a comment to this item.
	 * @param comment comment instance of comment model.
     */
	public void addComment(Comment comment) {
		comments[commentPointer++] = comment;
	}

	/**
	 * Return all comment which not null for current item.
	 * @return array of comments.
     */
	public Comment[] getComments()
	{
		Comment[] result;
		int size = 0;
		
		for(Comment comment : comments) {
			if(comment != null)
				size++;
		}
		
		result = new Comment[size];
	
		for(int index = 0; index < size; index++) {
			Comment current = comments[index];
			if(current != null)
				result[index] = current;
			
		}
		
		return result;
	}


	/**
	 * Generate a unique string.
	 * @return unique value string.
     */
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

	/**
	 * Use this method if you want display data about item.
	 * @return important data about item.
     */
	@Override
	public String toString() {
		return String.format("Id:%s\tName:%s\nDesc:%s",this.id, this.name, this.description);
	}
}