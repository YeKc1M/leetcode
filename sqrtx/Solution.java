public class Solution {
    //normal solution timeout
    public int mySqrt1(int x) {
        int left=0,right=x;
        do{
            int medium=(left+right)/2;
            if(medium*medium==x) return medium;
            else if(medium*medium<x){
                if((medium+1)*(medium+1)>x){
                    return medium;
                }else{
                    left=medium+1;
                }
            }else{
                right=medium-1;
            }
        }while(left<=right);
        return 0;
    }
    /*
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int mySqrt(int x) {
        if (x < 2) return x;
    
        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
      }
    public static void main(String[] args){
        System.out.println("sqrt x");
        test1();
    }
    private static void test1(){
        System.out.println(new Solution().mySqrt1(2147483647));
    }
}