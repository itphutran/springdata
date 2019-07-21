package com.phutran.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "categories", catalog = "testsql", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@NamedQuery(name = "get_all", query = "FROM Category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "category")
	private List<News> news;

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

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public Category(int id, String name, List<News> news) {
		super();
		this.id = id;
		this.name = name;
		this.news = news;
	}

	public Category() {
		super();
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", news=" + news + "]";
	}

}
