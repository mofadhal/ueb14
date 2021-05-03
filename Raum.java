import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse handelt sich um eines Raum und das Ort des Raums.
 *
 * @author (Mofadhal Al-Manari)
 * @version (03.05.2021)
 */
public class Raum {

    private int geb;
    private int etage;
    private int raum;
    private List<Reservierung> Liste; // ArrayListe
    private final int ZERO = 0;

    /**
     * ist der konstruktor dieser Klasse .
     * 
     * @param geb   // Gebude Nummer
     * @param etage // Etage Nummer
     * @param raum  // Raum Nummer
     */
    public Raum(int geb, int etage, int raum) {
        // check , ob die Paramen grosser als 0 sind
        if (geb < ZERO || raum < ZERO)
            throw new IllegalArgumentException("Die Eingaben mussen grosser als 0 sein");

        this.etage = etage;
        this.geb = geb;
        this.raum = raum;
        Liste = new ArrayList<Reservierung>();
    }

    /**
     * Diese Methode addiert die neue Resevierung in einer List : ArrayList .
     * 
     * @param reservierung // (beginn , ende) : Uhrzeit
     */
    public void addResevierung(Reservierung reservierung) {
        for (Reservierung r : Liste) {
            // check , ob Param in der List vorhanden ist .
            if (r.equals(reservierung)) {
                throw new IllegalArgumentException("Es ist schon reserviert");
            }
        }
        // addiert der Param in der Liste .
        Liste.add(reservierung);
    }

    /**
     * 
     * @param index
     * @return die Reservierung in der Liste an Position index
     */
    public Reservierung getReservierung(int index) { // check , ob die Param grosser als 0 ist . sowie ,ob index in der
                                                     // Liste existiert .
        if (index < ZERO || index >= Liste.size()) {
            throw new IllegalArgumentException("index existiert nicht");
        }
        return Liste.get(index);
    }

    /**
     * liefert Information , wieviel Elemente gespeichert wurde .
     * 
     * @return Anzahl die Elemente in der Liste : ArrayList .
     */
    public int getAnzahlReservierung() {
        return Liste.size();
    }

    /**
     * 
     * @return das gespeicherte gebaude in dieser Klasse .
     */
    public int getGeb() {
        return this.geb;
    }

    /**
     * 
     * @return die gespeicherte etage in dieser Klasse .
     */
    public int getEtage() {
        return this.etage;
    }

    /**
     * 
     * @return das gespeicherte raum in dieser Klasse .
     */
    public int getRaum() {
        return this.raum;
    }

    @Override
    public String toString() {
        String temp = "Raum " + geb + "-" + etage + "." + raum + "\n";

        for (Reservierung res : Liste) {
            temp += "gebucht von " + res.getMitarbeiter().toString() + "von " + res.getBeginn().toString() + " Uhr "
                    + "bis " + res.getEnde().toString() + " Uhr für " + res.getBemerkung() + "\n";
        }
        return temp;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Raum other = (Raum) obj;
        if (etage != other.etage)
            return false;
        if (geb != other.geb)
            return false;
        if (raum != other.raum)
            return false;
        return true;
    }

    
}
