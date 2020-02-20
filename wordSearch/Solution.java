import java.util.Stack;

class Solution {
    //normal solution 10% 15%
    Stack stack;
    public boolean exist(char[][] board, String word) {
        if(board.length==0) return false;
        stack=new Stack<>();
        int m=board.length,n=board[0].length;
        boolean res=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=backtrace(board, i, j, 0, word);
                if(res) return true;
            }
        }
        return false;
    }
    private boolean backtrace(char[][] board, int i, int j, int level, String word){
        int m=board.length;
        int n=board[0].length;
        if(board[i][j]==word.charAt(level)){
            if(stack.contains(i*n+j)) return false;
            else{
                stack.push(i*n+j);
                if(level==word.length()-1) return true;
                boolean res=false;
                if(i+1<m) res=backtrace(board, i+1, j, level+1, word);
                if(res) return res;
                if(i>0) res=backtrace(board, i-1, j, level+1, word);
                if(res) return res;
                if(j+1<n) res=backtrace(board, i, j+1, level+1, word);
                if(res) return res;
                if(j>0) res=backtrace(board, i, j-1, level+1, word);
                if(res) return res;
                stack.pop();
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println("search word");
        test();
    }
    private static void test(){
        char[][] board={{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}};
        System.out.println(new Solution().exist(board, "abceseeefs"));
    }
}