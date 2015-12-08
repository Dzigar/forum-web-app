package com.forum.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = Topic.BY_NAME, query = "Select t from Topic t where t.name = :name") })
public class Topic extends BaseEntity {

	public static final String BY_NAME = "Topic.ByName";

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Branch branch;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Comment> comments = new ArrayList<Comment>();

	public Topic() {
		// TODO Auto-generated constructor stub
	}

	public Topic(String name) {
		super(name);
	}

	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * Add comment to topic
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + getId() + ", name=" + getName() + ", branch="
				+ getBranch().getName() + ", comments count=" + getComments().size() + "]";
	}
}
