package generators;

/**
 * Are o functie care returneaza o matrice cu toate elementele intre 1 si 10
 */
public class MatrixCostGenerator {
    public static int[][] getMatrixCost(int matrixSize){
        int[][] matrixCost =new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrixCost[i][j] = CostGenerator.getCost();
            }
        }
        return matrixCost;
    }
}
