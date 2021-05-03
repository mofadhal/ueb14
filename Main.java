
/**
 * (Mofadhal Al-Manari und Leen AlKhadraa)
 */
/**
 * Diese Klasse ist eine Test-Klasse .
 *
 * @author (Mofadhal Al-Manari)
 * @version (03.05.2021)
 */
public class Main
{
    public static void main(String[] args) {

        Uhrzeit u = new Uhrzeit(12, 54);
        System.out.println(u); //12:54 Uhr

        Mitarbeiter m = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        System.out.println(m); //Max Mustermann (max@htwsaar.de)
    
        Raum r = new Raum(18, 0, 1);
        System.out.println(r); //Raum 18-0.1

        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter("John", "Doe", "john@htwsaar.de");
        Raum r1 = new Raum(18,0,1);
        Raum r2 = new Raum(2,1,9);
        Raum r3 = new Raum(2,1,10);

        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
        m1.reserviere(r2, new Uhrzeit(14, 30), new Uhrzeit(16, 30), "WebTech");
        m2.reserviere(r2, new Uhrzeit(12, 30), new Uhrzeit(13, 30), "Prog II");
        m2.reserviere(r3, new Uhrzeit(9, 30), new Uhrzeit(11,30), "ITM");

        System.out.println(r1);
        //Raum 18-0.1
        //gebucht von Max Mustermann (max@htwsaar.de) von 12:30 Uhr bis 14:30 für VOOP

        System.out.println(r2);
        //Raum 2-1.9
        //gebucht von Max Mustermann (max@htwsaar.de) von 14:30 Uhr bis 16:30 für WebTech
        //gebucht von John Doe (john@htwsaar.de) von 12:30 Uhr bis 13:30 Uhr für Prog II

        System.out.println(r3);
        //Raum 2-1.10
        //gebucht von John Doe (john@htwsaar.de) von 9:30 Uhr bis 11:30 Uhr für ITM




    }
}
