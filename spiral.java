import java.io.*;
import java.util.*;

class MyCode {
	public static void main (String[] args) {
		int[][] res = generateMatrix(5);
    
        // For printing out the result
        List<String> list = new ArrayList<>();
        for(int[] ele : res){
            String str = Arrays.toString(ele);
            list.add(str);
        }
        System.out.println(list);
	}
  
  private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n<1) return matrix;
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        /* Traversing from left -> right */
        int cellValue = 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i=colBegin; i<=colEnd; i++){
                matrix[rowBegin][i] = cellValue;
                cellValue++;
            }
            rowBegin++;
            /* Down */
            for(int i=rowBegin; i<=rowEnd; i++){
                matrix[i][colEnd] = cellValue;
                cellValue++;
            }
            colEnd--;
            /* Left */
            for(int i=colEnd; i>=colBegin; i--){
                matrix[rowEnd][i]=cellValue;
                cellValue++;
            }
            rowEnd--;
            /* Up */
            for(int i=rowEnd; i>=rowBegin; i--){
                matrix[i][colBegin] = cellValue;
                cellValue++;
            }
            colBegin++;   
        }
        return matrix;
    }
}


