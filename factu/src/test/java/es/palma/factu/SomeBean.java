package es.palma.factu;

import java.util.Date;

import es.palmademallorca.factu.utils.InDateRange;

public class SomeBean {
    @InDateRange
    private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
