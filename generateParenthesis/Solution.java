package generateParenthesis;

import java.util.List;
import java.util.LinkedList;

public class Solution {
    private List l=new LinkedList<>();
    //normal solution
    public List<String> generateParenthesis(int n) {
        String result="";
        addParenthesis(result, 0, n);
        return l;
    }
    //numOfLeft is unmatched num of left parenthesis
    private void addParenthesis(String result, int numOfLeft, int n){
        if(n==0){
            l.add(result);
        }else{
            if(numOfLeft<n){
                addParenthesis(result+"(", numOfLeft+1, n);
            }
            if(numOfLeft>0){
                addParenthesis(result+')', numOfLeft-1, n-1);
            }
        }
    }
    //n-pair () is equal to (left)right where left and right is n-1 pair ()
    public List<String> generateParenthesis1(int n){
        List ans=new LinkedList<>();
        if(n==0){
            ans.add("");
        }else{
            for(int i=0;i<n;i++){
                //left has i-pair ()
                for(String left: generateParenthesis1(i)){
                    //right has n-1-i pair
                    for(String right: generateParenthesis1(n-1-i)){
                        ans.add("("+left+")"+right);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("generate parenthesis");
        //test1();
        test2();
    }
    public static void test1(){
        System.out.println(new Solution().generateParenthesis(3));
    }
    public static void test2(){
        System.out.println(new Solution().generateParenthesis1(3));
    }
}