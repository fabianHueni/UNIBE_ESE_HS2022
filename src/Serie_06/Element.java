package Serie_06;

import java.util.ArrayList;

public abstract class Element {
    private String name;
    private ArrayList<Pfeil> eingehendePfeile = new ArrayList<>();
    private ArrayList<Pfeil> ausgehendePfeile = new ArrayList<>();

    public Element(String name) {
        this.name = name;
    }

    public void addEingehenderPfeil(Pfeil pfeil) {
        this.eingehendePfeile.add(pfeil);
    }

    public void addAusgehenderPfeil(Pfeil pfeil) {
        this.ausgehendePfeile.add(pfeil);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pfeil> getEingehendePfeile() {
        return eingehendePfeile;
    }

    public void setEingehendePfeile(ArrayList<Pfeil> eingehendePfeile) {
        this.eingehendePfeile = eingehendePfeile;
    }

    public ArrayList<Pfeil> getAusgehendePfeile() {
        return ausgehendePfeile;
    }

    public void setAusgehendePfeile(ArrayList<Pfeil> ausgehendePfeile) {
        this.ausgehendePfeile = ausgehendePfeile;
    }

    public abstract boolean isValid();

    public boolean istTransition() {
        return false;
    }

    public boolean istStelle() {
        return false;
    }

    public boolean readyToReceiveTokens(int numberOfTokens) {
        return true;
    }

    public boolean readyToSendTokens(int numberOfTokens) {
        return true;
    }

    public void moveTokens(int changeOfTokens) {}
}
