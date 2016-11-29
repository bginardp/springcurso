package es.palmademallorca.imi.proyecto4.dto;

public class ItemDto {
	private String label;
	private String value;
	
	
	
	public ItemDto(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
