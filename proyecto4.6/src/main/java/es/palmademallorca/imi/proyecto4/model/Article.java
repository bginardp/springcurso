package es.palmademallorca.imi.proyecto4.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.imi.proyecto4.dto.ArticleDto;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private boolean visible = false;
		
	public Article() {
		super();
	}

	public Article(boolean visible, String title, Date creationDate, Date modificationDate, Author author,
			String shortDescription, String content, Set<Label> labels) {
		super();
		this.visible = visible;
		this.title = title;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.author = author;
		this.shortDescription = shortDescription;
		this.content = content;
		this.labels = labels;
	}

	public Article(ArticleDto article, Set<Label> labels, Author author) {
		this.id = article.getId();
		this.visible = article.isVisible();
		this.labels = labels;
		this.author = author;
		this.content = article.getContent();
		this.shortDescription = article.getShortDescription();
		this.title = article.getTitle();
		this.modificationDate = new Date();
	}

	@NotNull
	@Size(min=5,max=80)
	private String title;
	
	@Column(insertable=true, updatable=false)
	private Date creationDate = new Date();
	
	@NotNull
	private Date modificationDate = new Date();
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Author author;
	
	@NotNull
	@Size(min=5,max=140)
	private String shortDescription;

	@NotNull
	@Size(min=15,max=65000)
	private String content;
	
	@Size(min=1)
	@ManyToMany
	@OrderBy("text asc")
	private Set<Label> labels;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}
	
	
}
