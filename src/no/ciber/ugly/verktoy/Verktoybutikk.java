package no.ciber.ugly.verktoy;

import java.util.ArrayList;
import java.util.List;

/**
 * Dette er klassen for Verktøybutikken vår.
 */
public class Verktoybutikk {

	private static final List<Verktoy> vListe = new ArrayList<Verktoy>();

	// initialiser verktøy som er til salgs i butikken
	static {
		vListe.add(new Verktoy(1, "Skiftenøkkel 10mm", 49.90d));
		vListe.add(new Verktoy(1, "Skiftenøkkel 14mm", 69.90d));
		vListe.add(new Verktoy(1, "Skiftenøkkel 18mm", 89.90d));
		vListe.add(new Verktoy(1, "Skiftenøkkel 22mm", 109.90d));
		vListe.add(new Verktoy(2, "Hammer liten", 112.50d));
		vListe.add(new Verktoy(2, "Hammer stor", 112.50d));
		vListe.add(new Verktoy(3, "Sag enhånds", 399.90d));
		vListe.add(new Verktoy(3, "Sag tohånds", 599.90d));
	}

	/**
	 * Henter alle skiftenøkler
	 * @return liste over skiftenøkler
	 */
	public List<Verktoy> getAlleType1() {
		// liste som skal samle opp skiftenøkler
		List<Verktoy> v = new ArrayList<Verktoy>();
		for (Verktoy x : vListe) {
			// om skiftenøkkel
			if (x.getType() == 1) {
				// legger til i liste som returneres
				v.add(x);
			}
		}
		return v;
	}

}
