package main;

import generators.MatrixCostGenerator;
import sourceTypes.Factory;
import sourceTypes.Warehouse;
import transporationPrbl.Destination;
import transporationPrbl.Problem;
import transporationPrbl.Source;

/**
 * Creaza toate obiectele necesare.
 * Creaza matricea cu costuri.
 * Setam toate obiectele in clasa Problem.
 * Metoda solve() rezolva problema
 */

public class Main {
    public static void main(String[] args) {

        Destination destination1 = new Destination("D1", 20);
        Destination destination2 = new Destination("D2", 25);
        Destination destination3 = new Destination("D3", 25);

        Source source1 = new Factory("S1", 10);
        Source source2 = new Warehouse("S2", 35);
        Source source3 = new Warehouse("S3", 25);

        int matrixSize = 3;
        int[][] matrixCost;
        matrixCost= MatrixCostGenerator.getMatrixCost(matrixSize);
        for(int i=0;i<matrixCost.length;i++){
            for (int j =0;j<matrixCost.length;j++){
                System.out.print(matrixCost[i][j]+" ");
            }
            System.out.println();
        }

        Problem problem = new Problem();
        problem.setDestination(destination1);
        problem.setDestination(destination2);
        problem.setDestination(destination3);
        problem.setSource(source1);
        problem.setSource(source2);
        problem.setSource(source3);
        problem.setMatrixCost(matrixCost);

        problem.solve();
        System.out.println("Total cost: " + problem.getTotalCost());
    }
}
