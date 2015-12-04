package com.forum.app.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@NamedQueries({ @NamedQuery(name = "", query = "") })
public class Topic extends BaseEntity {

	@ManyToOne
	private Branch branch;

	public Topic() {
		// TODO Auto-generated constructor stub
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
}
