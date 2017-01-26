package es.palmademallorca.factu.dto;
/**
 * classe que ens ajuda a fer servir la funcionalitat de autocomplete de jquery
 * necessariament ha de tener aquest dos atributs amb aquests noms. 
 * (label i value)
 * opcionalmen es poden afegir atributs per retornar a
 * 
 * @author BERNAT1
 *
 */
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
