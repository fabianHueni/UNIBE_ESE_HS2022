package Serie_06;

public class Transition extends Element{

    public Transition(String name) {
        super(name);
    }

    public boolean isValid() {
        for(Pfeil pfeil : super.getAusgehendePfeile()) {
            if(!pfeil.isNextStelle()) {
                return false;
            }
        }

        return true;
    }

    public boolean istTransition() {
        return true;
    }

    public boolean isReadyToFire() {
        return this.areAllSourceElementsReadyToSend() && this.areAllTargetElementsReadyToReceive();
    }

    private boolean areAllTargetElementsReadyToReceive() {
        for (Pfeil pfeil : super.getAusgehendePfeile()) {
            if(!pfeil.isTargetElementReadyToReceive()) {
                return false;
            }
        }
        return true;
    }

    private boolean areAllSourceElementsReadyToSend() {
        for (Pfeil pfeil : super.getEingehendePfeile()) {
            if(!pfeil.isSourceElementReadyToSend()) {
                return false;
            }
        }
        return true;
    }

    public void fire() {
        this.getEingehendePfeile().forEach(pfeil -> pfeil.fire());
        this.getAusgehendePfeile().forEach(pfeil -> pfeil.fire());
    }
}
