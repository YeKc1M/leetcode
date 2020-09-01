public class SpiralMatrix2{
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        generateSub(matrix, 0, 0);
        return matrix;
    }
    private void generateSub(int[][] matrix, int level, int start){
        int length=matrix.length;
        if(level*2-length>1) return;
        int count=start;
        for(int i=level;i<length-level;i++){
            matrix[level][i]=++count;
        }
        for(int i=level+1;i<length-level;i++){
            matrix[i][length-level-1]=++count;
        }
        for(int i=length-level-2;i>=level;i--){
            matrix[length-level-1][i]=++count;
        }
        for(int i=length-level-2;i>=level+1;i--){
            matrix[i][level]=++count;
        }
        generateSub(matrix, level+1, count);
    }
    public static void main(String[] args){
        System.out.println("hello world!");
        SpiralMatrix2 spiralMatrix2=new SpiralMatrix2();
        spiralMatrix2.generateMatrix(3);
    }
}