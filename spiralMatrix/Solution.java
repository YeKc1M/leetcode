package spiralMatrix;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List l=new LinkedList<>();
        if (matrix.length == 0)
            return l;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) l.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) l.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) l.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) l.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return l;
    }
    public static void main(String[] args){
        System.out.println("spiral matrix");
        test();
    }
    private static void test(){
        //int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] matrix={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] matrix={{6,7,9}};
        System.out.println(new Solution().spiralOrder(matrix));
    }
}