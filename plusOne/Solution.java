import java.util.Arrays;

class Solution {
    //normal solution 100%-5%
    public int[] plusOne(int[] digits) {
        int[] res=new int[digits.length+1];
        res[0]=0;
        int flag=1;
        for(int i=res.length-1;i>0;i--){
            int j=digits[i-1]+flag;
            res[i]=j%10;
            flag=j/10;
        }
        res[0]+=flag;
        if(res[0]==0) res=Arrays.copyOfRange(res, 1, res.length);
        return res;
    }
    //leetcode solution
    public int[] plusOne1(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0) return digits;
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
    public static void main(String[] args){
        System.out.println("plus one");
        test();
    }
    private static void test(){
        int[] digits={4,3,2,1};
        System.out.println(new Solution().plusOne(digits));
    }
}