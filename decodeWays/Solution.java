package decodeWays;

class Solution {
    int res;
    //normal solution timeout
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        res=0;
        backtrace(0, s);
        return res;
    }
    private void backtrace(int n, String s){
        if(n>=s.length()) res++;
        else{
            int num1=Integer.parseInt(s.substring(n, n+1));
            if(num1!=0){
                backtrace(n+1, s);
                if(n<s.length()-1){
                    int num2=Integer.parseInt(s.substring(n, n+2));
                    if(num2>0&&num2<27){
                        backtrace(n+2, s);
                    }
                }
            }
        }
    }
    //dynamic programming
    public int numDecodings1(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
    public static void main(String[] args){
        System.out.println("decode ways");
        test();
    }
    public static void test(){
        System.out.println(new Solution().numDecodings1("10"));
    }
}