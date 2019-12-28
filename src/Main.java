import java.util.ArrayList;

public class Main {
    private static final int THREAD_NUM = 4;
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Please input two matrix file");
            System.exit(1);
        }

        int[][] a = MatrixReader.getMatrixFromFile(args[0]);
        int[][] b = MatrixReader.getMatrixFromFile(args[1]);
        Matrix matrix = new Matrix(a, b, a.length);

        try {
            ArrayList<Thread> threadList = new ArrayList<>(THREAD_NUM);
            for (int i = 0; i < THREAD_NUM; i++) {
                Thread thread = new Thread(new MatrixRunner(matrix, i*10, (i*10)+9));
                thread.setName("thread"+(i+1));
                thread.start();
                threadList.add(thread);
            }

            for (Thread thread : threadList) {
                thread.join();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        matrix.printResultMatrix();

    }
}
