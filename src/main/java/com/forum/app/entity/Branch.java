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
@NamedQueries({ @NamedQuery(name = Branch.BY_NAME, query = "Select b from Branch b where b.name = :name") })
public class Branch extends BaseEntity {

	public static final String BY_NAME = "Branch.ByName";

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Section section;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Topic> topics = new ArrayList<Topic>();

	public Branch() {
	}

	public Branch(String name) {
		super(name);
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

	public void addTopic(Topic topic) {
		this.topics.add(topic);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + getId() + ", name=" + getName() + ", section="
				+ getSection().getName() + ", count of topics" + getTopics().size() + "]";
	}

}
