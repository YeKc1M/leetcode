import java.util.LinkedList;
import java.util.List;

public class Solution {
    private boolean[][] matrix;
    public List<List<String>> partition(String s) {
        List res=new LinkedList<>();
        int n=s.length();
        if(n!=0){
            matrix=new boolean[n][n];
            for(int i=0;i<n;i++){
                matrix[i][i]=true;
            }
            for(int i=0;i<n-1;i++){
                matrix[i][i+1]=(s.charAt(i)==s.charAt(i+1));
            }
            for(int i=2;i<n;i++){
                for(int j=0;i+j<n;j++){
                    matrix[j][i+j]=matrix[j+1][i+j-1]&&(s.charAt(j)==s.charAt(i+j));
                }
            }
            backtrace(0, n, res, new LinkedList<>(), s);
        }
        return res;
    }
    private void backtrace(int start, int end, List res, List current, String s){
        if(start==end){
            res.add(current);
        }else{
            for(int i=start; i<end; i++){
                if(matrix[start][i]){
                    current.add(s.substring(start, i+1));
                    backtrace(i+1, end, res, new LinkedList<>(current), s);
                    current.remove(s.substring(start, i+1));
                }
            }
        }
    }
    public static void main(String[] args){
        new Solution().partition("aaba");
    }
}