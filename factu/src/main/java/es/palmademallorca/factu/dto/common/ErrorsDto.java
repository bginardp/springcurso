package es.palmademallorca.factu.dto.common;

import java.util.ArrayList;
import java.util.List;

public class ErrorsDto {
	
	
	private List<ErrorDto> errors; 
	
	public ErrorsDto (List<ErrorDto> errors) {

		this.errors = errors;
	}
	
	public ErrorsDto(){
		
	}

	public boolean hasErrors(){
		return errors!=null && errors.size()>0;
	}
	
	public List<ErrorDto> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDto> errors) {
		this.errors = errors;
	}
	
	public void addError(ErrorDto error) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(error);
	}
	
	@Override
	public String toString() {
		return "ErrorsDto [errors=" + errors + "]";
	}
}
