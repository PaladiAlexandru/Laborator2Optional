package transporationPrbl;

import utils.PriceCalculator;

/**
 * Contine o sursa, o destinatie, costul unei mărfi  respectiv cantitatea mărfii.
 * Contine o metoda care calculeaza costul total
 */
public class Trade {
    private final Source source;
    private final Destination destination;
    private final int commodityCost;
    private final int commodityVolume;

    private final int totalCost;

    public Trade(Source source, Destination destination, int commodityCost,int commodityVolume) {
        PriceCalculator priceCalculator = new PriceCalculator();
        this.source = source;
        this.destination = destination;
        this.commodityCost = commodityCost;
        this.commodityVolume = commodityVolume;
        this.totalCost = priceCalculator.calulate(this);

    }

    public int getCommodityVolume() {
        return commodityVolume;
    }

    public int getComodityCost() {
        return commodityCost;
    }
    @Override
    public String toString() {
        return source.getName() +
                " -> " + destination.getName() +
                ": " + commodityVolume +
                " units * cost " + this.commodityCost +
                " = " + this.totalCost;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
