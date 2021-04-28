/**
 * Diese Klasse behandelt sich um Stunde und Minuten .
 *
 * @author (Mofadhal Al-Manari und Leen AlKhadraa)
 * @version (27.04.2021)
 */
public class Uhrzeit
{
    private int stunde ; 
    private int minute ; 
    
    private final int MAX_STUNDE = 23;// maximal stunde
    private final int MAX_MINUTE = 59;// maximal stunde

    /**
     * ist der konstruktor dieser Klasse .
     * @param stunde
     * @param minute
     */
    public Uhrzeit (int stunde , int minute)
    {
        //  stunde (0 - 23) minute (0 - 59)
        if(stunde < 0 || minute < 0 || stunde > MAX_STUNDE || minute > MAX_MINUTE )
        throw new IllegalArgumentException("Die Eingaben sind nicht richtig ");

        this.minute = minute ;
        this.stunde = stunde ;
    }

    /**
     * 
     * @return die gespeicherte stund in dieser Klasse .
     */
    public int getStunde(){
         return this.stunde;
         }

    
    /**
     * 
     * @return die gespeicherte stund in dieser Klasse .
     */
    public int getMinute() { 
        return this.minute;
     }
 
    @Override
    public String toString()
    {
        return stunde +":"+ minute ;
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
    Uhrzeit other = (Uhrzeit) obj;
    if (minute != other.minute)
        return false;
    if (stunde != other.stunde)
        return false;
    return true;
    }
    
}
