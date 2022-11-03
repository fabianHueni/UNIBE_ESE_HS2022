package Serie_06;

import java.util.ArrayList;
import java.util.List;

public class PetriNetz {

    private ArrayList<Stelle> stellen = new ArrayList<>();
    private ArrayList<Transition> transitions = new ArrayList<>();



    public boolean isValid() {
        return this.areTransitionsValid() && this.areStellenValid() && this.arePfeileValid();
    }


    public void addStelle(Stelle stelle) {
        this.stellen.add(stelle);
    }

    public void addTransition(Transition transition) {
        this.transitions.add(transition);
    }

    public ArrayList<Stelle> getStellen() {
        return stellen;
    }

    public void setStellen(ArrayList<Stelle> stellen) {
        this.stellen = stellen;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<Transition> transitions) {
        this.transitions = transitions;
    }

    private boolean areStellenValid() {
        for (Stelle stelle: this.stellen) {
            if (!stelle.isValid()) {
                return false;
            }
        }
        return true;
    }

    private boolean areTransitionsValid() {
        for (Transition trans: this.transitions) {
            if (!trans.isValid()) {
                return false;
            }
        }
        return true;
    }

    private boolean arePfeileValid() {
        ArrayList<Pfeil> allPfeile = new ArrayList<>();

        for (Transition trans: this.transitions) {
            allPfeile.addAll(trans.getAusgehendePfeile());
            allPfeile.addAll(trans.getEingehendePfeile());
        }

        for (Pfeil pfeil : allPfeile) {
            if (!pfeil.isValid()) {
                return false;
            }
        }

        return true;
    }

    public List<Transition> getAllTransitionsWhichAreReadyToFire() {
        return this.transitions.stream().filter(transition -> transition.isReadyToFire()).toList();
    }
}
