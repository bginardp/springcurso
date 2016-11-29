package es.palmademallorca.imi.proyecto4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article_label")
public class Label {
	
	@Id
	@Column(name="content")
	private String text;

	
	public Label() {
		super();
	}

	public Label(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
