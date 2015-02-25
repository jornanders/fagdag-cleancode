package no.ciber.ugly.pensjon;

import java.util.Date;

public class Hendelse {

	private HendelsesType type;

	private String informasjon;

	private Date date;

	Hendelse(HendelsesType type, String informasjon, Date dato) {
		this.date = dato;
		this.informasjon = informasjon;
		this.type = type;
	}

	public HendelsesType getType() {
		return type;
	}

	public String getInformasjon() {
		return informasjon;
	}

	public Date getDate() {
		return date;
	}

}
