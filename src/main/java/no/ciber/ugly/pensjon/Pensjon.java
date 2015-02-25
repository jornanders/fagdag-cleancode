package no.ciber.ugly.pensjon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Klasse for Pensjon
public class Pensjon {

	private List<Hendelse> h = new ArrayList<Hendelse>(); 	// historikk for
															// beregning av
															// pensjon

	// pensjonspoeng
	private int p = 0;

	/**
	 * @param ald alder
	 * @param kjnn kjønn
	 * @param inntkt inntekt
	 * @param antBrnUnd18 antallBarnUnder18
	 * @param alenefors aleneforsørger
	 */
	public Pensjon(int ald, int kjnn, int inntkt, int antBrnUnd18, int alenefors) {

		// legger til pensjonspoeng for alder
		if (ald >= 18 && ald < 30) {
			p = p + 10;
		} else if (ald >= 30 && ald < 50) {
			p = p + 20;
		} else if (ald >= 50) {
			p = p + 25;
		}

		// lagre Historikk Etter Alders Poeng Beregning
		h.add(new Hendelse(HendelsesType.LAGT_TIL_ALDERSPOENG, "Totalt poeng etter beregning " + p + " poeng, " + ald + " år", new Date()));

		// legger til pensjonspoeng for kjønn
		if (kjnn == 1) { // dersom kjønn ...
			p = p * 3;
		} else {
			p = p * 2;
		}
		// lagre Historikk Etter Kjonn Poeng Beregning
		h.add(new Hendelse(HendelsesType.LAGT_TIL_KJONNS_POENG, "Totalt poeng etter beregning " + p + "poeng, Kjønn= " + kjnn + "", new Date()));

		// legger til pensjonspoeng for at man er aleneforsørger
		if (alenefors == 1) { // dersom aleneforsørger
			if (antBrnUnd18 == 1) {
				p = p + 20;
			} else if (antBrnUnd18 == 2) {
				p = p + 35;
			} else if (antBrnUnd18 > 2) {
				// justerer for lav alder
				if (ald < 18) {
					p = p + 50;
				} else {
					p = p + 42;
				}
			}
		}

		// lagre Historikk Etter Aleneforsorgers Poeng For Barn Beregning
		h.add(new Hendelse(HendelsesType.LAGT_TIL_POENG_FOR_ALENEFORSORGER, "Totalt poeng etter beregning " + p + " poeng, aleneforsørger= "
		        + alenefors + " antallbarnUnder18", new Date()));

		// justerer for lønn
		if (inntkt < 200000) {
			p = p + 100;
		} else {
			p = p + 150;
		}

		// lagre Historikk Etter Poeng For Innteksjustering Beregning
		h.add(new Hendelse(HendelsesType.LAGT_TIL_LONNS_POENG, "Totalt poeng etter beregning " + p + "Lønn= " + inntkt + "", new Date()));
	}

	/**
	 * @return pensjon i kroner
	 */
	public int hentPensjonIKroner() {
		return p * 1000;
	}

	/**
	 * @return pensjon i euro
	 */
	public int hentPensjonIEuro() {
		return p * 100;
	}

	/**
	 * @return Liste over historikk
	 */
	public List<Hendelse> getHistorikk() {
		return h;
	}

	/**
	 * @return
	 */
	public int getPensjonspoeng() {
	    return p;
    }

}
