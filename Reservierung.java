
/**
 * Diese Klasse behandelt sich um Resevierung einer Raum mit der Beginnzeit und Endezeit.
 *
 * @author (Mofadhal Al-Manari und Leen AlKhadraa)
 * @version (27.04.2021)
 */
public class Reservierung
{
    private Mitarbeiter mitarbeiter ; // Info des Mitarbeiters (vorname , nachname , email)
    private Raum raum ; //(etageNummer , gebaudeNummer , raumNummer )
    private String bemerkung ; // fuer notizen .
    private Uhrzeit beginn ; // beginn der Resevierung (stunde , minute)
    private Uhrzeit ende ; // ende der Resevierung (stunde , minute)

    /**
     * ist der konstruktor dieser Klasse .
     * @param beginn // beginn der Resevierung (stunde , minute)
     * @param ende // beginn der Resevierung (stunde , minute)
     */
    public Reservierung (Uhrzeit beginn , Uhrzeit ende )
    {   //check , ob die Paramen null sind .
        if(beginn == null || ende == null )
        {
            throw new IllegalAccessError("Die Eimgaben sind falsch");
        }
        this.beginn = beginn ;
        this.ende = ende ;
        this.bemerkung = null;
        this.raum = null;
        this.mitarbeiter = null;
    }

    /**
     * lässt sich die Info des Mitarbeiters geaendert werden können
     * @param mitarbeiter
     * @return neu Mitarbeiter (vorname , nachname , email)
     */
    public Mitarbeiter setMitarbeiter(Mitarbeiter mitarbeiter)
    {
        if(mitarbeiter == null)throw new IllegalArgumentException("Die Eingegebene Datei ist null");
        return this.mitarbeiter = mitarbeiter;
    }


    /**
     * lässt sich die Info des Raums geaendert werden können .
     * @param raum //(etageNummer , gebaudeNummer , raumNummer ) 
     */
    public void setRaum (Raum raum)
    {
        //check , ob das eingegebene Raum null ist .
        if(raum == null)throw new IllegalArgumentException("Die Eingegebene Datei ist null");
        this.raum = raum;
    }

     /**
     * get die Info des Raums (etageNummer , gebaudeNummer , raumNummer ) 
     * @return das gespeicherte raum in der Klasse .
     */
    public Raum getRaum()
    {
        return this.raum;
    }  

    /**
     * 
     * @return das gespeicherte Mitarbeiter  .
     */
    public Mitarbeiter getMitarbeiter()
    {
        return this.mitarbeiter;
    }

    /**
     * 
     * @return die gespeicherte bemerkung in dieser Klasse .
     */
    public String getBemerkung(){ 
        return this.bemerkung;
    }

    /**
     * 
     * @return der gespeicherte Beginnzeit der Resevierung eines Raums .
     */
    public Uhrzeit getBeginn (){ 
        return this.beginn;
     }

     /**
      * 
      * @return der gespeicherte Endezeit der Resevierung eines Raums .
      */
    public Uhrzeit getEnde (){ 
        return this.ende; 
    }
    
    /**
     * lässt sich die bemerkung geaendert werden können .
     * @param bemerkung 
     * @return  bemerkung in dieser Klass = eingegebene bemerkung .
     */
    public String setBemerkung(String bemerkung)
    {
        //check , ob die Param null oder Leer ist .
        if(bemerkung == null || bemerkung.isEmpty())
        {
            throw new IllegalAccessError("Die Bemerkung ist falsch eingegeben");
        }
        return this.bemerkung = bemerkung;
    }
    
    @Override
    public String toString() {

        return super.toString()+" "+beginn +" "+ ende + " " + bemerkung;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reservierung other = (Reservierung) obj;
        if (beginn == null) {
            if (other.beginn != null)
                return false;
        } else if (!beginn.equals(other.beginn))
            return false;
        if (bemerkung == null) {
            if (other.bemerkung != null)
                return false;
        } else if (!bemerkung.equals(other.bemerkung))
            return false;
        if (ende == null) {
            if (other.ende != null)
                return false;
        } else if (!ende.equals(other.ende))
            return false;
        return true;
    }
}
