package com.forum.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
//@NamedQueries({ @NamedQuery(name = "", query = "") })
public class Section extends BaseEntity {

	@OneToMany
	private List<Branch> branches = new ArrayList<Branch>();

	public Section() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the branches
	 */
	public List<Branch> getBranches() {
		return branches;
	}

	/**
	 * @param branches
	 *            the branches to set
	 */
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
}
