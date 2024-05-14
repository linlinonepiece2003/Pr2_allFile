package Week_2;

public class Ex4 {
    //method to transpose a given 2D array
    public static int[][] transpose(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][] transposeMatrix = new int[cols][rows];// create the container
// create a loop to run through the row and inner loop to run the element of each loop

        for (int i =0; i < rows; i++){
            for (int j =0;j < cols; j++){
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }
    public static void print2DArray(int[][] array){
        for(int[] row : array){
            for (int element :row){
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        print2DArray(matrix);

        int[][] transposedMatrix = transpose(matrix);

        System.out.println("Transposed matrix:");
        print2DArray(transposedMatrix);
    }
}
