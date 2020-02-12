public class Solution {
    //Math solution 100% 16%
    public int uniquePaths(int m, int n) {
        int a=Math.max(m, n)-1, b=Math.min(m, n)-1;
        long res=1;
        for(int i=a+b;i>a;i--){
            res*=i;
        }
        for(int i=1;i<=b;i++) res/=i;
        return (int)res;
    }
    //dynamic programming 67% 14%
    public int uniquePaths1(int m, int n){
        if(m==1||n==1) return 1;
        int[][] matrix=new int[m][n];
        matrix[0][0]=0;
        for(int i=1;i<m;i++) matrix[i][0]=1;
        for(int i=1;i<n;i++) matrix[0][i]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
    public static void main(String[] args){
        System.out.println("unique path");
        //test();
        test1();
    }
    public static void test(){
        System.out.println(new Solution().uniquePaths(10, 10));
    }
    public static void test1(){
        System.out.println(new Solution().uniquePaths1(10, 10));
    }
}