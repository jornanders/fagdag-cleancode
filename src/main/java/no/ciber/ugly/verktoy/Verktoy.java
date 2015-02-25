package no.ciber.ugly.verktoy;

/**
 *
 */
public class Verktoy {
    //type verktøy
    private final int type;
    //beskrivelse av verktøyet
    private final String beskrivelse;
    //angir prisen for verktøyet
    private final double pris;

    public Verktoy(int type, String beskrivelse, double pris) {
        this.type = type;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }

    /**
     * Returnerer hva slags type verktøy dette er.
     *
     * @return typen
     */
    public int getType() {
        return type;
    }

    /**
     * Gir en beskrivelse av verktøyet
     *
     * @return beskrivelsen
     */
    public String getBeskrivelse() {
        return beskrivelse;
    }

    /**
     * Gir prisen på verktøyet
     *
     * @return prisen
     */
    public double getPris() {
        return pris;
    }
}
