import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Diese Klasse ruft alle Methoden .
 *
 * @author (Mofadhal Al-Manari)
 * @version (03.05.2021)
 */
public class Dialog {
    private final int ENDE = 0;//Ende Programmm .
    private final int MITARBEITER = 1;//Mitarbeiter anlegen oder in der Liste addieren .
    private final int RAUM = 2;//Raum anlegen oder in der Liste addieren .
    private final int RESEVIERUNG = 3; //Resvierung anlegen .
    private final int SET_ZEIT = 4; // Zeit der Resevierung des Raums aendern .
    private final int SET_MITARBEITER = 5; // aendern der Vorname , nachname , email der Mitarbeiter .
    private final int SET_RAUM = 6;//Raum Ort aendern .
    private final int GET_ANZAHL = 7;//get Anzahl der gespeicherten Mitarbeitern und der gespeicherten Räume .
    private final int GET_RESEVIERUNG = 8;//ausgeben der Elemnete der Mitarbeiters-List und Raum-List .
    private final int MAX_STUNDE = 23; // Maximal Stunde
    private final int MAX_MINUTE = 59; // Maximal MInute
    private List<Mitarbeiter> mitarbeiters; 
    private List<Raum> raumlisteDialog;
    public Scanner input = new Scanner(System.in);

    /**
     * EinlesenFunktion zeit der Benutzer ,was von Methoden er wählen kann.
     * @return die Eingegebene Nummer von dem Benutzer .
     */
    public int einlesenFunction() {
        
        System.out.println("\n"+
                           MITARBEITER + ": Mitarbeiter anlegen " + "  "+
                           RAUM +": Raum anlegen "+"  "+
                           RESEVIERUNG + ": Resvierung eines Raum " + "  " + 
                           SET_ZEIT+ ": set Beginnzeit & Endezeit " + "  " + 
                           SET_MITARBEITER + ": set Mitarbeiter " + " \n" + 
                           SET_RAUM+ ": set Ort des Raums  " + " " + 
                           GET_ANZAHL + ": Anzahl(Mitarbeiter & Räume) "+"  " + 
                           GET_RESEVIERUNG+ ": Alle Mitarbeitern & alle Räume  "+ " "+
                           ENDE + ": Ende Programm "); 
                          

        return input.nextInt();

    }
    
    /**
     * Diese Funktion gibt der Benutzer die Methode , die er gewählt hat .
     * @param funktion die eingegebene Nummer
     */
    public void ausfuehrungFunction(int funktion) {
        switch (funktion) {
        case ENDE:System.out.println("Ende Programm");break;
        case MITARBEITER:mitarbeiterAnlegen();break;
        case RAUM:raumAnlegen();break;
        case RESEVIERUNG:resvierungRaumAnlegen();break;
        case SET_RAUM:setRaum(); break;
        case SET_MITARBEITER:setMitarbeiterDialog();break;
        case SET_ZEIT:setZeit();break;
        case GET_ANZAHL:
         System.out.println("Anzahl der angelegte Mitarbeiter: "+mitarbeiters.size());
         System.out.println("Anzahl der resevierte Räume: "+raumlisteDialog.size()); 
          break;
        case GET_RESEVIERUNG:listenElemnte();break;
        default:
            System.out.println("Es gibt keine Funktion speichert unter diese Nummer");
        }

    }

    /**
     * Diese Methode lässt uns ein Mitarbeiter  legen , bzw. addieren
     */
    public void mitarbeiterAnlegen() {
        String vorname;
        String nachname;
        String email;

        System.out.println("Geben Sie den Vorname des Mitarbeiters ein:-");
        vorname = input.next();

        System.out.println("Geben Sie den Nachname des Mitarbeiters ein:-");
        nachname = input.next();

        System.out.println("Geben Sie die E-Mail des Mitarbeiters ein:-");
        email = input.next();
        Mitarbeiter neumit = new Mitarbeiter(vorname, nachname, email);
        mitarbeiters.add(neumit);

        System.out.println("\n"+"Die anglegete Mitarbeiter:- ");
        System.out.println( neumit.toString()+"\n");

    }

    /**
     * Diese Methode lässt uns ein Raum für ein bestimmte Mitarbeiter zu resevieren
     */
    public void resvierungRaumAnlegen() {
        if( mitarbeiters.isEmpty()){//chech ,ob die mitarbeiter-Array leer ist.
            System.out.println("es gibt kein mitarbeiter ");
            return;
        }
        if( raumlisteDialog.isEmpty()){//chech ,ob die raum-Array leer ist.
            System.out.println("Es gibt kein raum zum resevieren ");
            return;
        }
        //-------------------------Mitarbeiter Wählen------------------------------------
        System.out.println("\n"+"wählen sie ein Mitarbeiter:-");
        for(int i = 0 ; i < mitarbeiters.size() ; i++){
            System.out.println(i + " ----> " + mitarbeiters.get(i).toString());
        }
        System.out.println("-1 ----> zuruck");
        System.out.println("Geben Sie Index der Mitarbeiter ein:-");
        int mitarbeiterAuswahl = input.nextInt();
        if(mitarbeiterAuswahl == -1)return;
        for(int i = 0 ; i < mitarbeiters.size() ; i++){
            if(mitarbeiterAuswahl <-1 || mitarbeiterAuswahl > mitarbeiters.size())
            throw new  IllegalArgumentException("Dieser Mitarbeiter existiert nicht");
        }
        Mitarbeiter tempMitarbeiter = mitarbeiters.get(mitarbeiterAuswahl);
        //-------------------------Raum Wählen-------------------------------------------
        System.out.println("\n"+"wählen sie ein Raum:-");
        for (int i = 0; i < raumlisteDialog.size(); i++) {
            System.out.println(i+" ----> " + raumlisteDialog.get(i).toString());
        }
        System.out.println("-1 ----> zuruck");
        System.out.println("Geben Sie Index der Raum ein:-");
        int  raumAuswahl = input.nextInt();
        for(int i = 0; i < raumlisteDialog.size(); i++){
            if(raumAuswahl <-1 || raumAuswahl > raumlisteDialog.size())
            throw new  IllegalArgumentException("Dieses Raum existiert nicht");
        }
        if(raumAuswahl == -1)return;
         Raum tempRaum = raumlisteDialog.get(raumAuswahl);
        //-------------------------Beginnzeit Einlesen-----------------------------------
        Uhrzeit begin = zeitAnlegen("beginn");
        //-------------------------Endezeit Einlesen-----------------------------------
        Uhrzeit ende = zeitAnlegen("ende");
        //-------------------------Bemerkung Einlesen------------------------------------
        System.out.println("bitte geben sie eine Bemerkung ein:-");
        String bemerkung = input.next();
        //-------------------------------------------------------------------------------
        tempMitarbeiter.reserviere(tempRaum, begin, ende, bemerkung); 

    }
    
    /**
     * Diese Methode ist Zeit zu anlegen . (Beginn & ende)
     * @param bg wählen entwieder Beginn oder Ende
     * @return neu Uhrzeit resevierung
     */
    public Uhrzeit zeitAnlegen(String bg ) {
        System.out.println("Geben Sie  " + bg + "stunde ein:-");
        int stunde = input.nextInt();
        System.out.println("Geben Sie  " + bg + "minute ein:-");
        int minute = input.nextInt();
        if (stunde > MAX_STUNDE || minute > MAX_MINUTE || stunde < 0 || minute < 0)
            throw new IllegalArgumentException("Die Anzahl muss grosser als 0 sein | 23 Stunde , 59 Minute"+"\n");

        return new Uhrzeit(stunde , minute);
    }

    /**
     * Diese Methode ist ein Raum anzulegen , bzw addieren
     */
    public void raumAnlegen() {
        int etage;
        int geb;
        int raum;

        System.out.println("Geben Sie die nummer der Etage ein:-");
        etage = input.nextInt();
        System.out.println("Geben Sie die nummer der Gebude ein:-");
        geb = input.nextInt();
        System.out.println("Geben Sie die nummer des Raum ein:-");
        raum = input.nextInt();
        Raum neuRaum = new Raum(geb, etage, raum);
        raumlisteDialog.add(neuRaum);

        System.out.println("\n"+"Die verfügbare Räume:- ");
        System.out.println(neuRaum.toString());

            
    }

    /**
     * Diese Methode ändert der Mitarbeiter
     */
    public void setMitarbeiterDialog() {
        System.out.println("wählen sie ein Mitarbeiter\n");
        for(int i = 0 ; i < mitarbeiters.size() ; i++){
                System.out.println(i + "\t" + mitarbeiters.get(i).toString());
            }
            System.out.println("-1 ----> zuruck");
            System.out.println("\n"+"Nummer:- ");
            int mitarbeiterAuswahl = input.nextInt();
            for(int i = 0 ; i < mitarbeiters.size() ; i++){
                if(mitarbeiterAuswahl <-1 || mitarbeiterAuswahl > mitarbeiters.size())
                throw new  IllegalArgumentException("\n"+"Dieser Mitarbeiter existiert nicht");
            }
            if(mitarbeiterAuswahl == -1)return;
    
            String vorname;
            String nachname;
            String email;
    
            System.out.println("Geben Sie den Vorname des Mitarbeiters ein");
            vorname = input.next();
    
            System.out.println("Geben Sie den Nachname des Mitarbeiters ein");
            nachname = input.next();
    
            System.out.println("Geben Sie die E-Mail des Mitarbeiters ein");
            email = input.next();
    
            Mitarbeiter neumit = new Mitarbeiter(vorname, nachname, email);
            Mitarbeiter tempMitarbeiter = mitarbeiters.set(mitarbeiterAuswahl, neumit);

            System.out.println("\n"+"Die anglegete Mitarbeiter:- ");
            System.out.println( neumit.toString());
            
    }
     
    /**
     * Diese Methode ändert das Ort des Raums
     */
    public void setRaum(){
       int etage;
       int geb;
       int raum;

        System.out.println("wählen sie ein Raum");
        for (int i = 0; i < raumlisteDialog.size(); i++) {
            System.out.println(i+"\t" + raumlisteDialog.get(i).toString());
        }
         int raumAuswahl = input.nextInt();
         for(int i = 0; i < raumlisteDialog.size(); i++){
            if(raumAuswahl <-1 || raumAuswahl > raumlisteDialog.size())
            throw new IllegalArgumentException("Dieses Raum existiert nicht");
        }
         System.out.println("-1 ----> zuruck");
         if(raumAuswahl == -1)return;

        System.out.println("Geben Sie die nummer der Etage ein");
        etage = input.nextInt();
        System.out.println("Geben Sie die nummer der Gebude ein");
        geb = input.nextInt();
        System.out.println("Geben Sie die nummer des Raum ein");
        raum = input.nextInt();
        Raum neuRaum= new Raum(geb, etage, raum);
        Raum tempRaum = raumlisteDialog.set(raumAuswahl, neuRaum);

        System.out.println("\n"+"Die resevierte Räume:- ");
        System.out.println(neuRaum.toString());
        
    }

    /**
     * Diese Methode ändert die Zeit der Resevierung nach bestimmtes Raum
     */
    public void setZeit() {
        System.out.println("wählen sie ein Mitarbeiter");
        for(int i = 0 ; i < mitarbeiters.size() ; i++){
            System.out.println(i + " ----> " + mitarbeiters.get(i).toString());
        }
        System.out.println("-1 ----> zuruck");
        int mitarbeiterAuswahl = input.nextInt();
        for(int i = 0 ; i < mitarbeiters.size() ; i++){
            if(mitarbeiterAuswahl <-1 || mitarbeiterAuswahl > mitarbeiters.size())
            throw new  IllegalArgumentException("Dieser Mitarbeiter existiert nicht");
        }
        if(mitarbeiterAuswahl == -1)return;
        Mitarbeiter tempMitarbeiter = mitarbeiters.get(mitarbeiterAuswahl);

        System.out.println("wählen sie ein Raum");
        for (int i = 0; i < raumlisteDialog.size(); i++) {
            System.out.println(i+" ----> " + raumlisteDialog.get(i).toString());
        }
        System.out.println("-1 ----> zuruck");
        int raumAuswahl = input.nextInt();
        for(int i = 0; i < raumlisteDialog.size(); i++){
            if(raumAuswahl <-1 || raumAuswahl > raumlisteDialog.size())
            throw new IllegalArgumentException("Dieses Raum existiert nicht");
        }
        if(raumAuswahl == -1)return;
        Raum tempRaum = raumlisteDialog.get(raumAuswahl);

        Uhrzeit begin = zeitAnlegen("beginn");
        Uhrzeit ende = zeitAnlegen("ende");
        
    }

    /**
     * Diese Methode drückt entwieder die Mitarbeiter-List oder Räume-List
     */
    public void listenElemnte(){
        
        System.out.println("\n"+"Biite wahlen Sie ein :- ");
        System.out.println("1: Liste der Mitarbeitern   2: Liste der Räume   0:zuruck");
        int auswahl = input.nextInt();
        
        switch(auswahl){
            case 1:{
            System.out.println("\n"+"Liste der Mitarbeitern:- ");
            for(int i = 0 ; i < mitarbeiters.size() ; i++){
                System.out.println(i + " ----> " + mitarbeiters.get(i).toString());
                }
                listenElemnte();
            }
            case 2:{
            System.out.println("\n"+"Liste der Räume:- ");
            for (int i = 0; i < raumlisteDialog.size(); i++) {
                System.out.println(i+" ----> " + raumlisteDialog.get(i).toString());
                     }
                listenElemnte();
             }
             case 0: return;
             default: System.out.println("Bitte wahlen Sie entwieder 0 oder 1 oder 2");
        
    }
        
    }

    

    public void Start() {
        int funktion = -1;
        mitarbeiters = new ArrayList<>();
        raumlisteDialog = new ArrayList<>();
        while (funktion != ENDE) {
            try {
                funktion = einlesenFunction();
                ausfuehrungFunction(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        new Dialog().Start();
    }
}
