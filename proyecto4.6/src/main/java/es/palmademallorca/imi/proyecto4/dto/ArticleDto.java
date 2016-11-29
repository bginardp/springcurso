package es.palmademallorca.imi.proyecto4.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.palmademallorca.imi.proyecto4.model.Article;
import es.palmademallorca.imi.proyecto4.model.Label;

public class ArticleDto {
	
	private Long id;
	
	@NotNull
	@Size(min=5,max=80)
	private String title;
	
	@NotNull
	@Size(min=5,max=140)
	private String shortDescription;
	
	@NotNull
	@Size(min=15,max=65000)
	private String content;
	
	@NotNull
	private Long authorId;

	private String authorName;
	
	@NotNull
	@Size(min = 3, max = 200)
	private String labels;
	
	private List<String> labelList;
	
	private boolean visible;
	
	private String creationDate;
	private String modificationDate;

	public ArticleDto() {
	}

	
	public ArticleDto(Article article) {
		this.id = article.getId();
		this.visible = article.isVisible();
		this.authorId = article.getAuthor().getId();
		this.authorName = article.getAuthor().getName();
		this.content = article.getContent();
		this.shortDescription = article.getShortDescription();
		this.title = article.getTitle();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.creationDate = sdf.format(article.getCreationDate());
		this.modificationDate = sdf.format(article.getModificationDate());
		initLabels(article);
	}

	private void initLabels(Article article) {
		String labelsAsString = "";
		List<String> labelList = new ArrayList<>();
		Set<Label> labelSet = article.getLabels();
		int i = 0;
		for (Label label : labelSet){
			labelList.add(label.getText());
			labelsAsString += label.getText();
			if (i<labelSet.size()-1){
				labelsAsString +=", ";
			}
			i++;
		}
		this.labels = labelsAsString;
		this.labelList = labelList;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getModificationDate() {
		return modificationDate;
	}
	
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}


	public List<String> getLabelList() {
		return labelList;
	}


	public void setLabelList(List<String> labelList) {
		this.labelList = labelList;
	}


}
