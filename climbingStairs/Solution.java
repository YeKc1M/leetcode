package climbingStairs;

public class Solution {
    int count=0;
    //backtrace timeout
    public int climbStairs1(int n) {
        count=0;
        backtrace(n);
        return count;
    }
    private void backtrace(int n){
        if(n<=0) count++;
        else{
            if(n>=1) backtrace(n-1);
            if(n>=2) backtrace(n-2);
        }
    }
    //dynamic prigramming 100% 5%
    public int climbStairs(int n){
        if(n<=1) return 1;
        int[] arr=new int[n+1];
        arr[0]=1;arr[1]=1;
        for(int i=2;i<n+1;i++) arr[i]=arr[i-1]+arr[i-2];
        return arr[n];
    }
    public static void main(String[] args){
        System.out.println("climbing stairs");
        //test1();
    }
    private static void test1(){
        System.out.println(new Solution().climbStairs(0));
    }
}