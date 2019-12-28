public class Matrix {
    private int[][] matrixA, matrixB, matrixC;
    private int size;

    public Matrix(int[][]matrixA, int[][]matrixB, int size){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.size = size;
        matrixC = new int[size][size];
    }

    public void multiplyMatrix(int start, int end){
        for (int s = start; s<= end; s++) {
            for (int i = 0; i < size; i++) {
                int sum = 0;
                for (int j = 0; j < size; j++)
                    sum += (matrixA[i][j] * matrixB[j][s]);
                matrixC[i][s] = sum;
            }
        }
    }

    public synchronized void printPartMatrix(int s, int e, String thName){
        System.out.println("---"+thName+"["+s+", "+e+"]---");
        for(int i = 0; i<size; i++){
            for(int j = s; j<=e; j++)
                System.out.printf("%5d", matrixC[i][j]);
            System.out.println();
        }
    }
    public void printResultMatrix(){
        MatrixWriter.writeFile("c.dat", matrixC);
        System.out.println("finally result : ");
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++)
                System.out.printf("%5d ", matrixC[i][j]);
            System.out.println();
        }
    }
}