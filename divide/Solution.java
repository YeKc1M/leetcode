package divide;

public class Solution {
    /*
    作者：luca-zhao
    链接：https://leetcode-cn.com/problems/divide-two-integers/solution/zhi-xing-shi-jian-1msji-bai-100-by-luca-zhao/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }
    //xsl 100%,60%
    public int divide2(int dividend, int divisor){
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        return dividend/divisor;
    }
    //normal timeout
    public int divide1(int dividend, int divisor) {
        int res=0;
        if(dividend>0){
            if(divisor>0){
                while(dividend>=divisor){
                    dividend-=divisor;
                    res++;
                }
                if(res<0) res=Integer.MAX_VALUE;
                return res;
            }else{
                while(dividend>=divisor){
                    dividend+=divisor;
                    res--;
                }
                if(res+2>0) res=Integer.MAX_VALUE-2;
                return res+2;
            }
        }else if(dividend<0){
            if(divisor>0){
                while(dividend<=divisor){
                    dividend+=divisor;
                    res--;
                }
                if(res+2>0) res=Integer.MAX_VALUE-2;
                return res+2;
            }else{
                while(dividend<=divisor){
                    dividend-=divisor;
                    res++;
                }
                if(res<0) res=Integer.MAX_VALUE;
                return res;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println("divide two integers");
        test();
    }
    private static void test(){
        System.out.println(new Solution().divide(-2147483648, -1));
    }
}