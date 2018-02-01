package es.palmademallorca.factu.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorDto {
	private Long con;
	private String tip;
	private String dem;
	private Object[] args;

	public ErrorDto() {
	}

	public ErrorDto(Long con, String tip, String dem, Object[] args) {
		super();
		this.con = con;
		this.tip = tip;
		this.dem = dem;
		this.args = args;
	}
	
	public ErrorDto(Long con, String tip, String dem) {
		super();
		this.con = con;
		this.tip = tip;
		this.dem = dem;
	}

	public ErrorDto(Long con, String dem) {
		super();
		this.con = con;
		this.tip = "E";
		this.dem = dem;
	}

	public ErrorDto(String dem) {
		super();
		this.tip = "E";
		this.dem = dem;
	}
	public Long getCon() {
		return con;
	}

	public void setCon(Long con) {
		this.con = con;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getDem() {
		return dem;
	}

	public void setDem(String dem) {
		this.dem = dem;
	}
	
	@JsonIgnore
	public Object[] getArgs() {
		return args;
	}

	@JsonIgnore
	public void setArgs(Object[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "ErrorDto [con=" + con + ", tip=" + tip + ", dem=" + dem + "]";
	}

}
