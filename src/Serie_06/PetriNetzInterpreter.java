package Serie_06;

import java.util.List;
import java.util.Scanner;

public class PetriNetzInterpreter {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PetriNetz petrinetz = erzeugeBeispielPetriNetz();
        if (!validate(petrinetz)) {
            throw new Exception("> Das Petri Netz enthält syntaktische Fehler.");
        }
        while (true) {
            for (Stelle stelle : petrinetz.getStellen()) {
                System.out.println(stelle.getName() + ": token=" + stelle.getTokens());
            }
            List<Transition> schaltbereite = alleSchaltbereitenTransitionen(petrinetz);
            if (!schaltbereite.isEmpty()) {
                for (int i = 0; i < schaltbereite.size(); ++i) {
                    System.out.println("#" + i + " : " + schaltbereite.get(i).getName());
                }
                System.out.print("> Wählen Sie eine Transition aus: ");
                Transition transition = schaltbereite.get(scanner.nextInt());
                schalteTransition(transition);
            } else {
                System.out.print("> Das Petri-Netz ist terminiert.");
                break;
            }
        }
    }

    public static PetriNetz erzeugeBeispielPetriNetz() {
        PetriNetz petriNetz = new PetriNetz();

        Pfeil pfeil_0 = new Pfeil(1);
        Pfeil pfeil_1 = new Pfeil(1);
        Pfeil pfeil_2 = new Pfeil(2);

        Stelle stelle_0 = new Stelle("S0", 10, 5);
        Stelle stelle_1 = new Stelle("S1", 3, 0);
        Stelle stelle_2 = new Stelle("S2", 6, 0);

        petriNetz.addStelle(stelle_0);
        petriNetz.addStelle(stelle_1);
        petriNetz.addStelle(stelle_2);

        Transition transition = new Transition("T0");
        petriNetz.addTransition(transition);

        // Konfiguriere Pfeilverbindungen
        pfeil_0.verbindePfeil(stelle_0, transition);
        pfeil_1.verbindePfeil(transition, stelle_1);
        pfeil_2.verbindePfeil(transition, stelle_2);

        return petriNetz;
    }

    public static boolean validate(PetriNetz netz) {
        return netz.isValid();
    }

    public static boolean isSchaltbereit(Transition transition) {
        return transition.isReadyToFire();
    }

    public static List<Transition> alleSchaltbereitenTransitionen(PetriNetz netz) {
        return netz.getAllTransitionsWhichAreReadyToFire();
    }

    public static void schalteTransition(Transition transition) {
        transition.fire();
    }
}
