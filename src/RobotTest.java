import java.util.Arrays;
import java.util.Scanner;

public class RobotTest {
    public static Scanner scannerRobi = new Scanner(System.in);


    //************************ ---== main-Methode ==--- ************************
    public static void main(String[] args) {
        Robot r1 = new Robot("R2-D2", false); // Instanzierung. Aus dem Bauplan wird ein konkretes Objekt
        //r1.position.x = 0;
        //r1.position.y = 0;
        char[][] spielfeld = new char[20][20]; // Spielfeld Groesse definieren (2D-Array)

        while (true) {
            // -------== Daten EINGABE  ==--------
            System.out.print("Wie soll sich der Roboter bewegen ? ('>'-vor, '<'-zurueck, 'r'-rechts drehen, 'l'-links drehen)  \n");
            String richtung = scannerRobi.nextLine();
            if (richtung.equals("exit")) {break;}
            String[] zeichen = richtung.toLowerCase().split(""); // wird Zeichenweise in ein Array zerlegt

            //  ---------==  SPIELFELD  ==----------
            for (char[] c : spielfeld) {
                Arrays.fill(c, 'x'); // Spielfeld Array mit 'x'-en befuellen
            }

            //  -------== Roboter BEWEGEN  ==--------
            move(zeichen, r1, spielfeld);

            feldZeichnen(spielfeld); // Spielfeld in der Console zeichnen

            //Koordinaten des Roboters
            System.out.println("Aktuele Y-Position = " + r1.getPosition().y);
            System.out.println("Aktuele X-Position = " + r1.getPosition().x);
            if(r1.getActRichtung()==0) {
                System.out.println("Aktuele Richtung = 'Osten'");
                System.out.println("******************************");
            } else if (r1.getActRichtung()==1) {
                System.out.println("Aktuele Richtung = 'Sueden'");
                System.out.println("*******************************");
            } else if (r1.getActRichtung()==2) {
                System.out.println("Aktuele Richtung = 'Westen'");
                System.out.println("********************************");
            } else if (r1.getActRichtung()==3) {
                System.out.println("Aktuele Richtung = 'Norden'");
                System.out.println("********************************");
            }
        } // Ende Schleife Eingabe


    } // Ende der main-Methode

    private static void move(String[] zeichen, Robot r1, char[][] spielfeld) {
        for (int i=0; i < zeichen.length; i++)
        {
            // Roboter vorwaerts bewegen
            if(/*i<zeichen.length &&*/ zeichen[i].equals(">")) {
                //i++;
                r1.moveRoboter(r1.getActRichtung(), 1);
                wegMarkieren(r1.getPosition().x, r1.getPosition().y, spielfeld);
            }

            // Roboter drehen wenn eine Buchstabe eingetragen wurde
            if(/*i<zeichen.length && */!zeichen[i].equals("<") && !zeichen[i].equals(">")) {
                r1.changeDirection(zeichen[i], r1.getActRichtung()); // Fahrrichtung des Roboters aendern
                //i++;
            }

            // Roboter rueckwaerts bewegen
            if(/*i<zeichen.length && */zeichen[i].equals("<")) {
                //i++;
                r1.moveRoboter(r1.getActRichtung(), -1);
                wegMarkieren(r1.getPosition().x, r1.getPosition().y, spielfeld);
            }
        }
        // ---------==  Roboter POSITIONIEREN  ==---------
        if(r1.getPosition().y>=0 && r1.getPosition().x>=0 && r1.getPosition().y<=19 && r1.getPosition().x<=19) {
            spielfeld [r1.getPosition().y] [r1.getPosition().x] = '@';
        }
    }

    //************************ --== Methoden der main-Klasse ==--  ************************
    public static void feldZeichnen (char[][] spielfeld) {
        for (char[] c : spielfeld) {
            System.out.println(Arrays.toString(c));
        }
    }

    public static void wegMarkieren (int positionX, int positionY, char[][] spielfeld) {
        if(positionY>=0 && positionX>=0 && positionY<=19 && positionX<=19) {
            spielfeld [positionY] [positionX] = ' '; // befahrene Positionen mit Leerzeichen markieren
        }
    }
}
