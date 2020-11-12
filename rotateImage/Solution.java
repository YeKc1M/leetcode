package rotateImage;

public class Solution {
    //normal solution 100% 67%
    public void rotate(int[][] matrix) {
        int l=matrix.length;
        if(l%2==0){
            for(int i=0;i<l/2;i++){
                for(int j=0;j<l/2;j++){
                    int x1=i,y1=j;
                    int x2=l-j-1,y2=i;
                    int x3=l-i-1,y3=l-j-1;
                    int x4=j,y4=l-i-1;
                    int temp=matrix[x1][y1];
                    matrix[x1][y1]=matrix[x2][y2];
                    matrix[x2][y2]=matrix[x3][y3];
                    matrix[x3][y3]=matrix[x4][y4];
                    matrix[x4][y4]=temp;
                }
            }
        }else{
            for(int i=0;i<l/2+1;i++){
                for(int j=0;j<l/2;j++){
                    int x1=i,y1=j;
                    int x2=l-j-1,y2=i;
                    int x3=l-i-1,y3=l-j-1;
                    int x4=j,y4=l-i-1;
                    int temp=matrix[x1][y1];
                    matrix[x1][y1]=matrix[x2][y2];
                    matrix[x2][y2]=matrix[x3][y3];
                    matrix[x3][y3]=matrix[x4][y4];
                    matrix[x4][y4]=temp;
                }
            }
        } 
    }
    public static void main(String[] args){
        System.out.println("rotate image");
        //testDivide();
        test();
    }
    public static void test(){
        Solution s=new Solution();
        int[][] matrix={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        s.rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void testDivide(){
        int a=3;
        double b=a/2.0;
        System.out.println(b);
    }
}