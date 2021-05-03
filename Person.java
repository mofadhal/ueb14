
/**
 *Diese Klasse behandelt sich um einen Person , der vorname und nachname hat .
 *
 * @author (Mofadhal Al-Manari)
 * @version (03.05.2021)
 */
public class Person
{
    private String vorname;
    private String nachname;

    /**
     * ist der konstruktor dieser Klasse .
     * @param vorname
     * @param nachname
     */
    public Person (String vorname , String nachname)
    {   
        //check , ob die Paramen null oder Leer ist .
        if(vorname == null || nachname == null || vorname.isEmpty()  || nachname.isEmpty()  )
        {
            throw new IllegalArgumentException("Vorname oder Nachname ist falsch" );
        }
        this.nachname = nachname ;
        this.vorname = vorname ;
    }

    /**
     * 
     * @return der gespeicherte vorname .
     */
    public String getVorname () {
         return this.vorname ;
        }
    
    /**
     * 
     * @return der gespeicherte nachname .
     */
    public String getNachname(){
         return this.nachname; 
        }
   
    @Override
    public String toString ()
    {   //ausgegeben vorname nachname
        return vorname +" "+ nachname;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Person other = (Person) obj;
    if (nachname == null) {
        if (other.nachname != null)
            return false;
    } else if (!nachname.equals(other.nachname))
        return false;
    if (vorname == null) {
        if (other.vorname != null)
            return false;
    } else if (!vorname.equals(other.vorname))
        return false;
    return true;
    }

}
