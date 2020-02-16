import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    //normal solution 30% 49%
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return;
        int n=matrix[0].length;
        Set setR=new HashSet<>(),setC=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    setR.add(i);
                    setC.add(j);
                }
            }
        }
        Iterator itrR=setR.iterator();
        while(itrR.hasNext()){
            int i=(int)itrR.next();
            for(int j=0;j<n;j++){
                matrix[i][j]=0;
            }
        }
        Iterator itrC=setC.iterator();
        while(itrC.hasNext()){
            int j=(int)itrC.next();
            for(int i=0;i<m;i++){
                matrix[i][j]=0;
            }
        }
    }
    public static void main(String[] args){
        System.out.println("set matrix zeroes");
    }
}