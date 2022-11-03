package Serie_06;

public class Pfeil {
    private int gewicht = 1;
    private Element quelle;
    private Element ziel;


    public Pfeil(int gewicht) {
        this.gewicht = gewicht;
    }

    public void verbindePfeil(Element quelle, Element ziel) {
        this.quelle = quelle;
        this.ziel = ziel;

        this.quelle.addAusgehenderPfeil(this);
        this.ziel.addEingehenderPfeil(this);
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public boolean isNextStelle() {
        return this.ziel.istStelle();
    }

    public boolean isNextTransition() {
        return this.ziel.istTransition();
    }

    public boolean isValid() {
        return quelle != null && ziel != null && gewicht >= 1;
    }

    public boolean isTargetElementReadyToReceive() {
        return this.ziel.readyToReceiveTokens(this.gewicht);
    }

    public boolean isSourceElementReadyToSend() {
        return this.quelle.readyToSendTokens(this.gewicht);
    }

    public void fire() {
        this.quelle.moveTokens(this.gewicht * -1);
        this.ziel.moveTokens(this.gewicht);
    }
}
