public class MatrixRunner implements Runnable {
    private Matrix matrix;
    private int start, end;

    public MatrixRunner(Matrix matrix, int start, int end) {
        this.matrix = matrix;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        try{
            matrix.multiplyMatrix(start, end);
        } finally {
            matrix.printPartMatrix(start, end, Thread.currentThread().getName());
        }
    }
}