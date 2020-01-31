import java.util.HashMap;

public class Solution {
    //normal solution 96%-40%
    public boolean isValidSudoku(char[][] board) {
        //check rows
        for(int i=0;i<9;i++){
            boolean[] isEmpty={true, true, true, true, true, true, true, true, true};
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int num=(int)(board[i][j]-'1');
                if(isEmpty[num]) isEmpty[num]=false;
                else return false;
            }
        }
        //check column
        for(int i=0;i<9;i++){
            boolean[] isEmpty={true, true, true, true, true, true, true, true, true};
            for(int j=0;j<9;j++){
                if(board[j][i]=='.') continue;
                int num=(int)(board[j][i]-'1');
                if(isEmpty[num]) isEmpty[num]=false;
                else return false;
            }
        }
        //check square
        for(int i=0;i<9;i++){
            //i-th square
            boolean[] isEmpty={true, true, true, true, true, true, true, true, true};
            for(int j=0;j<9;j++){
                int indexX=(i%3)*3+(j/3);
                int indexY=(i/3)*3+(j%3);
                if(board[indexX][indexY]=='.') continue;
                int num=(int)(board[indexX][indexY]-'1');
                if(isEmpty[num]) isEmpty[num]=false;
                else return false;
            }
        }
        return true;
    }
    //by leetcode 48%-16%
    public boolean isValidSudoku1(char[][] board){
        HashMap[] row=new HashMap[9];
        HashMap[] col=new HashMap[9];
        HashMap[] box=new HashMap[9];
        for(int i=0;i<9;i++){
            row[i]=new HashMap<>();
            col[i]=new HashMap<>();
            box[i]=new HashMap<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int num=(int)(board[i][j]-'0');
                row[i].put(num, (int)row[i].getOrDefault(num, 0)+1);
                col[j].put(num, (int)col[j].getOrDefault(num, 0)+1);
                int boxNo=(i/3)*3+(j/3);
                box[boxNo].put(num, (int)box[boxNo].getOrDefault(num, 0)+1);
                if((int)row[i].get(num)>1||(int)col[j].get(num)>1||(int)box[boxNo].get(num)>1) return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("valid sudoku");
        //leetcode solution pass
        //test3();
        //test4();
        //normal solution pass
        //test1();
        //test2();
    }
    public static void test1(){
        char[][] arr={
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        if(new Solution().isValidSudoku(arr)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public static void test2(){
        char[][] arr={
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        if(new Solution().isValidSudoku(arr)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public static void test3(){
        char[][] arr={
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        System.out.println(new Solution().isValidSudoku1(arr));
    }
    public static void test4(){
        char[][] arr={
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        System.out.println(new Solution().isValidSudoku1(arr));
    }
}