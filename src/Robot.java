import java.awt.*;

public class Robot { // Jede Klasse erbt automatisch von Klasse Object
    String name;
    boolean stationaer; // erlaubte Werte: true oder false;
    String farbe;
    double gewicht;
    boolean weltherrschaftsAmbitionen;
    private int actRichtung; //aktuelle Richtung des Roboters als Int-Zahl
    public int getActRichtung() { // aktuelle Richtung fuer aussen sichtbar machen
        return actRichtung;
    }

    // private = Objekt kann nur selbst seine Eigenschaft verändern
    public Point position = new Point(); // enthält x und y mit Standardwert x:0, y:0

    public Point getPosition() {
        return position;
    }

    private static final String[] directions = {"o", "s", "w", "n"};


    // Eigenschaft ist private = keine direkte Manipulation möglich
    //r1.position.x = 10; // direktes Verändern der Eigenschaften kann zum ungültigen Zustand des Objetes führen
    public Robot(String name) {
        // name = Lokale Variable, existiert nur während der Ausführung der Methode
        // this.name = Objektvariable
        this.name = name; // lokaler Wert wird dauerhaft ins Objekt geschrieben
    }

    // Überladen von Konstruktoren = gleicher Name, andere Parameter
    public Robot(String name, boolean stationaer) {
        this.stationaer = stationaer;
        this.name = name;
    }

    /**
     * Die Methode liefert aktuelle Richtung zurueck als eine Ganzzahl:
     * @return 0 - rechts / osten
     *  1 - runter / sueden
     *  2 - links / westen
     *  3 - hoch / norden
     * @param 'Integer' Wert fuer Speicherung der aktuellen Richtung
     */
    public String changeDirection(String Eingabe, int richt) {

        if(Eingabe.equalsIgnoreCase("r")) {
            richt = richt+1;
            if(richt>3) {richt = 0;}
        }
        else if(Eingabe.equalsIgnoreCase("l")) {
            if(richt>0) {richt = richt-1;} else {richt=3;}
        }
        actRichtung = richt;
        return directions[richt];
    }


    /**
     * Roboter bewegen entsprechend vorgegebenen Richtung (x-Achse = ost/west-Rcihtung, y-Achse = Süd-/Nord-Richtung)
     * @param: Richtung
     *      <0=rechts/osten>
     *      <1=runter/sueden>
     *      <2=links/westen>
     *      <3=hoch/norden>
     * @param: Anzahl um wie viele Zeichen die Bewegung erfolgen soll als Int-Wert.
     */
    public void moveRoboter(int richtung, int kmh) {
        if(stationaer) {
            System.out.println(name + ": Kann sich nicht bewegen");
        }
        else {
            if (richtung ==0 && (position.x + kmh)<=20) {
                    position.x += kmh;
                } else if(richtung ==0) {
                    System.out.println("Der Roboter ist aus dem Feld Richtung -Osten- geflohen !");
                }
            if (richtung==2 && (position.x - kmh)>=0) {
                    position.x -= kmh;
                } else if(richtung ==2) {
                    System.out.println("Der Roboter ist aus dem Feld Richtung -Westen- geflohen !");
                }
            if (richtung==3 && (position.y - kmh)>=0) {
                    position.y -= kmh;
                } else if(richtung ==3) {
                    System.out.println("Der Roboter ist aus dem Feld Richtung -Norden- geflohen !");
                }
            if (richtung==1 && (position.y + kmh)<=20) {
                    position.y += kmh;
                    if(position.y<0) {System.out.println("Der Roboter ist aus dem Feld Richtung -Norden- geflohen !");}
                } else if(richtung==1 && (position.y>=20)) {
                   System.out.println("Der Roboter ist aus dem Feld Richtung -Sueden- geflohen !");
                }
        }
    }

    public void links() {
    }

    public void rechts() {
    }

    @Override
    public String toString() {
        return "Robot{" +
                "stationaer=" + stationaer +
                ", farbe='" + farbe + '\'' +
                ", gewicht=" + gewicht +
                ", weltherrschaftsAmbitionen=" + weltherrschaftsAmbitionen +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

}
