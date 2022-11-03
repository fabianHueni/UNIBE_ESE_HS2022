package Serie_06;

import java.util.ArrayList;

public class Stelle extends Element{
    private int kapazitaet = 1;
    private int tokens;

    public Stelle(String name, int kapazitaet, int tokens) {
        super(name);
        this.kapazitaet = kapazitaet;
        this.tokens = tokens;
    }

    public int getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public boolean istStelle() {
        return true;
    }

    public boolean isValid() {
        if (tokens > kapazitaet || kapazitaet < 1 || tokens < 0) {
            return false;
        }

        for(Pfeil pfeil : super.getAusgehendePfeile()) {
            if(!pfeil.isNextTransition()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean readyToReceiveTokens(int numberOfTokens) {
        return this.kapazitaet - this.tokens >= numberOfTokens;
    }

    @Override
    public boolean readyToSendTokens(int numberOfTokens) {
        return this.tokens >= numberOfTokens;
    }

    @Override
    public void moveTokens(int changeOfTokens) {
        this.tokens += changeOfTokens;
    }
}
