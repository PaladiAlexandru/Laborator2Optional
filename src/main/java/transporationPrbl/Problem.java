package transporationPrbl;

import java.util.ArrayList;
import java.util.List;

/**
 * O problema de tipul 'Transportation problem'.
 * Contine o lista de destinatii si de surse.
 * Are o metoda care rezolva problema.
 * Nu permite adaugarea surselor sau destinatiilor cu acelasi nume
 */
public class Problem {
    private final List<Destination> destinations = new ArrayList<>();
    private final List<Source> sources = new ArrayList<>();
    private int[][] matrixCost;

    private int totalCost = 0;

    /**
     * @return true daca toate destinatiile au demandul egal cu 0.
     * false daca gaseste cel putin un demand care este diferit de 0
     */
    public boolean isDemandZero() {
        int ok = 1;
        for (Destination destination : destinations) {
            if (destination.getDemand() != 0) {
                ok = 0;
                break;
            }
        }
        return ok != 0;
    }

    /**
     * Calculeaza costul minim pentru fiecare sursa, si face trade-ul corespunzator.
     * Apoi calculeaza costul total pentru fiecare tranzactie
     */
    public void solve() {
        int destinationIndex = -1, sourceIndex = -1, min = 10;
        while (!isDemandZero()) {
            for (int i = 0; i < matrixCost.length; i++) {
                for (int j = 0; j < matrixCost.length; j++) {
                    if (matrixCost[i][j] <= min) {
                        min = matrixCost[i][j];
                        destinationIndex = j;
                        sourceIndex = i;
                    }
                }
                //System.out.println(destinationIndex);
                int destinationDemand = destinations.get(destinationIndex).getDemand();
                int sourceCapacity = sources.get(sourceIndex).getCapacity();
                Destination destination = destinations.get(destinationIndex);
                Source source = sources.get(sourceIndex);
                int cost = matrixCost[sourceIndex][destinationIndex];

                if (destinationDemand <= sourceCapacity && destinationDemand != 0 && sourceCapacity != 0) {
                    Trade trade = new Trade(source, destination, cost, destinationDemand);
                    this.totalCost += trade.getTotalCost();
                    source.setCapacity(sourceCapacity - destinationDemand);
                    destination.setDemand(0);
                    System.out.println(trade);
                }
                if (destinationDemand > sourceCapacity && destinationDemand != 0 && sourceCapacity != 0) {
                    Trade trade = new Trade(source, destination, cost, sourceCapacity);
                    this.totalCost += trade.getTotalCost();
                    destination.setDemand(destinationDemand - sourceCapacity);
                    source.setCapacity(0);
                    System.out.println(trade);
                }

                matrixCost[sourceIndex][destinationIndex] = 10;
                min = 10;

            }


        }

    }

    /**
     * Adauga o destinatie la lista destinatiilor daca aceasta nu se regaseste deja in lista
     *
     * @param destination destinatia care urmeaza sa fie adaugata in lista
     */
    public void setDestination(Destination destination) {
        if (!destinations.contains(destination))
            this.destinations.add(destination);
        else
            System.err.println("Destinatia \"" + destination.getName() + "\" deja exista!");
    }

    /**
     * Adauga o sursa la lista surselor daca aceasta nu se regaseste deja in lista
     *
     * @param source sursa care urmeaza sa fie adaugata in lista
     */
    public void setSource(Source source) {
        if (!sources.contains(source))
            this.sources.add(source);
        else
            System.err.println("Sursa \"" + source.getName() + "\" deja exista!");
    }


    public void setMatrixCost(int[][] matrixCost) {
        this.matrixCost = matrixCost;
    }

    public int getTotalCost() {
        return totalCost;
    }


}
