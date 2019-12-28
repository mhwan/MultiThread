import java.io.*;

public class MatrixReader {

    public static int[][] getMatrixFromFile(String path){
        int[][] matrix = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            DataInputStream dataStream = new DataInputStream(fileInputStream);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(dataStream));

            String line = null;
            int lineNum = 0;
            while ((line = buffer.readLine()) !=null) {
                if (!line.isEmpty()) {
                    String[] a = line.split(" ");
                    if (matrix == null)
                        matrix = new int[a.length][a.length];

                    if (lineNum < a.length) {
                        for (int i = 0; i < a.length; i++) {
                            int num = Integer.parseInt(a[i]);
                            matrix[lineNum][i] = num;
                        }
                    } else
                        throw new Exception("Matrix size is wrong");

                    lineNum++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matrix;
    }
}
