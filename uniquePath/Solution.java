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
    public static void main(String[] args){
        System.out.println("unique path");
        test();
    }
    public static void test(){
        System.out.println(new Solution().uniquePaths(10, 10));
    }
}