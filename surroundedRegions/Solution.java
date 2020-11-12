package surroundedRegions;

import java.util.HashSet;

class Solution {
    HashSet set;
    HashSet edge;
    //6%, 5%
    public void solve1(char[][] board) {
        int x=board.length;
        if(x==0) return;
        int y=board[0].length;
        set=new HashSet<>();
        edge=new HashSet<>();
        for(int i=0;i<y;i++){
            edge.add(i);
            edge.add((x-1)*y+i);
        }
        for(int i=0;i<x;i++){
            edge.add(i*y);
            edge.add(i*y+y-1);
        }
        for(int i=1;i<x-1;i++){
            for(int j=1;j<y-1;j++){
                if(board[i][j]=='O'){
                    groupO(board, i, j, x, y);
                    boolean isSurrounded=true;
                    for(Object obj: set){
                        if(edge.contains(obj)){
                            isSurrounded=false;
                            break;
                        }
                    }
                    if(isSurrounded){
                        for(Object obj: set){
                            int num=(int)obj;
                            board[num/y][num%y]='X';
                        }
                    }else{
                        for(Object obj: set){
                            int num=(int)obj;
                            board[num/y][num%y]='o';
                        }
                    }
                    set.clear();
                }
            }
        }
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='o'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void groupO(char[][] board, int i, int j, int x, int y){
        if(!set.contains(i*y+j)){
            set.add(i*y+j);
            if(i>0&&board[i-1][j]=='O') groupO(board, i-1, j, x, y);
            if(i<x-1&&board[i+1][j]=='O') groupO(board, i+1, j, x, y);
            if(j>0&&board[i][j-1]=='O') groupO(board, i, j-1, x, y);
            if(j<y-1&&board[i][j+1]=='O') groupO(board, i, j+1, x, y);
        }
    }
}