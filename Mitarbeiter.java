
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse behandelt sich um einen Mitarbeiter und seine Resevierung in einer Liste einzufuegen.
 *
 * @author (Mofadhal Al-Manari und Leen AlKhadraa) 
 * @version (27.04.2021)
 */
public class Mitarbeiter extends Person  
{
    private String email; // E-Mail Adresse .
    private List<Raum> reservieteRaumList;
    /**
     *  ist der konstruktor dieser Klasse .
     * @param vorname //  Vorname des Mitarbeiters .
     * @param nachname //  Nachname des Mitarbeiters .
     * @param email // E-Mail Adresse des Mitarbeiters .
     */

    public Mitarbeiter (String vorname , String nachname , String email)
    {
        super(vorname, nachname);//ruft die Konstruktor der Kalsse-Person .
        if(email == null || email.isEmpty())//check ob die variablen null oder Leer sind .
        {
            throw new IllegalArgumentException("Email darf nicht leer sein" );
        }
        this.email = email ;
        reservieteRaumList = new ArrayList<>(); // resvierung ein speicherplatz für der ArrayList .
    }

    /**
     * Diese Methode zeigt die gespeichert E-Mail Adresse .
     * @return E-Mail Adresse des Mitarbeiters .
     */
    public String getEmail (){
         return this.email;
         }

    /**
     * lässt sich die E-Mail adresse geaendert werden können .
     * @param email
     * @return die E-Mail in dieser Klass = die neue E-Mail .
     */
    public String setEmail (String email){
         return this.email = email;
         }

    /**
     *  speichert die Information der Resevierung 
     * und rueft die Methoden aus die Resvierung-Klasse.
     * @param raum // etage - gebaude . raum .
     * @param beginn // stund : minute .
     * @param ende // stund : minute .
     * @param bemerkung // notizen .
     */
    public  void reserviere(Raum raum , Uhrzeit beginn , Uhrzeit ende , String bemerkung)
    {   //ueberprueft , ob die Param null ist .
        if(raum == null || beginn == null || ende == null || bemerkung == null){
            throw new IllegalArgumentException("Die Eingaben mussen nicht null sein");
        }
        Reservierung temp = new Reservierung(beginn, ende); 
        temp.setMitarbeiter(this); 
        temp.setRaum(raum);
        temp.setBemerkung(bemerkung);
        raum.addResevierung(temp);
        if (!reservieteRaumList.contains(raum)){
            reservieteRaumList.add(raum);
        }
    }


    /**
     * ausgegeben: vorname nachname (email) 
     */
    @Override
    public String toString() {
        return super.toString()+" (" + email + ") ";
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;

        if (!super.equals(obj))
        return false;

        if (getClass() != obj.getClass())
        return false;

        Mitarbeiter other = (Mitarbeiter) obj;

        if (email == null) {
             if (other.email != null)
              return false;
        } else if (!email.equals(other.email))
               return false;

        if (reservieteRaumList == null) {
            if (other.reservieteRaumList != null)
             return false;
        } else if (!reservieteRaumList.equals(other.reservieteRaumList))
                return false;

             return true;
    }
}
