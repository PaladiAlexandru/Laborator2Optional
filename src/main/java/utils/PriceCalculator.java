package utils;

import transporationPrbl.Trade;

/**
 * Are o functie care calculeaza costul de la o sursa la destinatie
 */
public class PriceCalculator {
    public int calulate(Trade trade){
        return  trade.getCommodityVolume() * trade.getComodityCost();
    }
}
