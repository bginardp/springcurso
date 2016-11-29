package es.palmademallorca.imi.proyecto3.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buyOrder")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date buyDate;
    private Double total;
	public Long getId() {
		return id;
	}
	
	public Double getTotal() {
		return total;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}


}
