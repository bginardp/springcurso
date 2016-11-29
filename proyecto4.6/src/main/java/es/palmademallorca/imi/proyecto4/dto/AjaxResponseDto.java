package es.palmademallorca.imi.proyecto4.dto;

public class AjaxResponseDto {
	
	private long timestamp;
	private String message;
	
	
	public AjaxResponseDto(long timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
