import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MatrixWriter {
    public static void writeFile(String filename, int[][] matrix){
        File file = new File(filename);
        BufferedWriter bufferedWriter;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < matrix.length; i++) {
                String text = "";
                for (int j =0; j<matrix.length; j++) {
                    int num = matrix[i][j];
                    text += num;
                    if (j < 39)
                        text += " ";
                }
                if(i < matrix.length-1)
                    text+= "\n";
                bufferedWriter.write(text);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }


            bufferedWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}