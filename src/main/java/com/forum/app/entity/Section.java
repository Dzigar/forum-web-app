package com.forum.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = Section.ALL, query = "Select s from Section s"),
		@NamedQuery(name = Section.BY_NAME, query = "Select s from Section s where s.name = :name") })
public class Section extends BaseEntity {

	public static final String ALL = "Section.ALL";
	public static final String BY_NAME = "Section.ByName";

	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> branches = new ArrayList<Branch>();

	public Section() {
	}

	public Section(String name) {
		super(name);
		setCreationTime(new Date());
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

	public void addBranch(Branch branch) {
		this.branches.add(branch);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + getId() + ", name=" + getName() + ", count of branches="
				+ getBranches().size() + "]";
	}
}
