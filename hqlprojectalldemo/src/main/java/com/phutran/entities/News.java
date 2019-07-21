package com.phutran.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "news", catalog = "testsql", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, table = "news", unique = true, nullable = false)
	private int id;
	@Column(name = "name", length = 150, table = "news", unique = true, nullable = false)
	private String name;
	@ManyToOne(optional = true)
	@JoinColumn(name = "cat_id", nullable = false, table = "news", unique = false)
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
