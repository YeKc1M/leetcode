public class Solution {
    //normal solution... StackOverFlow
    public double myPow(double x, int n) {
        if(n>0){
            if(n%2==0){
                double d=myPow(x, n/2);
                return d*d;
            }else{
                double d=myPow(x, n/2);
                return d*d*x;
            }
        }else if(n==0) return 1;
        else{
            return myPow(1/x,-n);
        }
    }
    //by leetcode pass
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
    public static void main(String[] args){
        System.out.println("pon(x,n)");
        test();
    }
    private static void test(){
        System.out.println(new Solution().myPow(4, -4));
    }
}