package com.forum.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
// @NamedQueries({ @NamedQuery(name = "", query = "") })
public class Branch extends BaseEntity {

	@ManyToOne
	private Section section;

	@OneToMany
	private List<Topic> topics = new ArrayList<Topic>();

	public Branch() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the section
	 */
	public Section getSection() {
		return section;
	}

	/**
	 * @param section
	 *            the section to set
	 */
	public void setSection(Section section) {
		this.section = section;
	}

	/**
	 * @return the topics
	 */
	public List<Topic> getTopics() {
		return topics;
	}

	/**
	 * @param topics
	 *            the topics to set
	 */
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

}
