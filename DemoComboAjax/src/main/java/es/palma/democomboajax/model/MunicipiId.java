package es.palma.democomboajax.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;

@Embeddable
public class MunicipiId implements Serializable{
	private static final long serialVersionUID = 5146577381249074471L;
	
	@Column(name="pro_con")	
	@Max(99)
	private Long proCon;
	@Max(999)
	private Long con;
	
	public MunicipiId() { }
	public MunicipiId(Long proCon, Long con) {
		super();
		this.proCon = proCon;
		this.con = con;
	}

	public Long getProCon() {
		return proCon;
	}
	public void setProCon(Long proCon) {
		this.proCon = proCon;
	}
	public Long getCon() {
		return con;
	}
	public void setCon(Long con) {
		this.con = con;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((con == null) ? 0 : con.hashCode());
		result = prime * result + ((proCon == null) ? 0 : proCon.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MunicipiId other = (MunicipiId) obj;
		if (con == null) {
			if (other.con != null)
				return false;
		} else if (!con.equals(other.con))
			return false;
		if (proCon == null) {
			if (other.proCon != null)
				return false;
		} else if (!proCon.equals(other.proCon))
			return false;
		return true;
	}
	
	public String toString() {
		return new StringBuilder().append("{ proCon: ").append(getProCon())
			.append(", con: ").append(getCon()).append(" }").toString();
	}
}